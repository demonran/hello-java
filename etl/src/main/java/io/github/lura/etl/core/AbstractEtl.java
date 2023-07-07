package io.github.lura.etl.core;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ description: AbstractEtl
 * @ author: Liu Ran
 * @ data: 7/7/23 12:54
 */
public abstract class AbstractEtl<O, N> implements DataExtractor<O>, DataTransformer<O, N>, DataLoader<N> {

    private static final int BATCH_SIZE = 100;

    public void action(SqlConfig sqlConfig) {
        try {

            List<O> oldObjs = this.extract(sqlConfig.getOldConfig());

            List<N> newObjects = oldObjs.stream().map(this::transform).collect(Collectors.toList());
            this.load(newObjects, sqlConfig.getNewConfig());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<O> extract(SqlConfig.Config sqlConfig) {
        List<O> obj = new ArrayList<>();
        try (Connection connection = getConnection(sqlConfig)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlConfig.getSql());
            while (resultSet.next()) {
                obj.add(extract(resultSet));
            }
            return obj;

        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }

    }


    public void load(List<N> newObjs, SqlConfig.Config sqlConfig) {
        try (Connection connection = getConnection(sqlConfig);
             PreparedStatement statement = connection.prepareStatement(sqlConfig.getSql())) {
            for (int i = 0; i < newObjs.size(); i++) {
                // 在这里获取转换后的数据，并执行写入操作
                // 示例：将转换后的数据写入新系统表中
                load(newObjs.get(i), statement);
                statement.addBatch();

                // 当积累足够的数据时，批量执行写入操作
                if (i % BATCH_SIZE == 0) {
                    statement.executeBatch();
                }
            }
            statement.executeBatch();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection(SqlConfig.Config sqlConfig) throws ClassNotFoundException, SQLException {

        Class.forName(sqlConfig.getDriver());
        return DriverManager.getConnection(sqlConfig.getUrl(), sqlConfig.getUsername(), sqlConfig.getPassword());

    }
}
