package io.github.lura.etl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.github.lura.etl.core.AbstractEtl;
import io.github.lura.etl.core.SqlConfig;
import io.github.lura.etl.flight.FlightEtl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @ description: DataSync
 * @ author: Liu Ran
 * @ data: 7/7/23 12:36
 */
public class DataSync {
    public static void main(String[] args) throws Exception {
        start();
    }

    public static void start() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String directory = "migration";
        File dbDirectory = new File(DataSync.class.getClassLoader().getResource(directory).getFile());
        for (File file : dbDirectory.listFiles()) {
            System.out.println(file);
            XmlMapper xmlMapper = new XmlMapper();
            // 从 XML 文件中读取数据并映射到 Data 类
            SqlConfig sqlConfig = xmlMapper.readValue(file, SqlConfig.class);
            Object etl = Class.forName(sqlConfig.getEtl()).getDeclaredConstructor().newInstance();
            if (etl instanceof AbstractEtl<?, ?>) {
                ((AbstractEtl<?, ?>) etl).action(sqlConfig);
            }
        }
    }

}
