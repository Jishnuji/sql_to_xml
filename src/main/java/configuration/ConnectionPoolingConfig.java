package configuration;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectionPoolingConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}

