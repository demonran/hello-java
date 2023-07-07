package io.github.lura.etl.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ description: DataLoader
 * @ author: Liu Ran
 * @ data: 7/7/23 12:37
 */
public interface DataLoader<N> {

    void load(N obj, PreparedStatement ps) throws SQLException;


}
