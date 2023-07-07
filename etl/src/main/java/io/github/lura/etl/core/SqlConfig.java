package io.github.lura.etl.core;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @ description: SqlConfig
 * @ author: Liu Ran
 * @ data: 7/7/23 13:11
 */
@Data
@JacksonXmlRootElement(localName = "root")
public class SqlConfig {

    private String etl;
    private Config oldConfig;
    private Config newConfig;
    @Data
    public static class Config {
        private String driver = "com.mysql.jdbc.Driver";
        private String url = "jdbc:mysql://localhost/old_system_db";
        private String username = "username";
        private String password;
        private String sql;

    }
}
