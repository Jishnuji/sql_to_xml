package dao;

import configuration.ConnectionPoolingConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOArticlesJDBCImpl implements DAOArticles {
    private static final String SELECT_ARTICLES = "select id_art, name, code, username, guid from whs.article limit 10000";

    public ResultSet getArticleResultSetFromDB() {
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPoolingConfig.getDataSource().getConnection();
            Statement statement = connection.createStatement()){
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            resultSet = statement.executeQuery(SELECT_ARTICLES);
            connection.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return resultSet;
    }
}
