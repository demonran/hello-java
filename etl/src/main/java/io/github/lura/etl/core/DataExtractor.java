package io.github.lura.etl.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ description: DataExtractor
 * @ author: Liu Ran
 * @ data: 7/7/23 12:36
 */
public interface DataExtractor<T> {





    T extract(ResultSet resultSet) throws SQLException;


}
