package dao;

import configuration.ConnectionPoolingConfig;
import model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOArticlesJDBCImpl implements DAOArticles {
    private static final String SELECT_ARTICLES = "select id_art, name, code, username, guid from whs.article limit 10000";

    public List<Article> getArticlesFromDB () {
        List<Article> articles = new ArrayList<>();
        try(Connection connection = ConnectionPoolingConfig.getDataSource().getConnection();
            Statement statement = connection.createStatement()){
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery(SELECT_ARTICLES);

            while (resultSet.next()) {
               long id_art = resultSet.getLong("id_art");
               String name = resultSet.getString("name");
               long code = resultSet.getLong("code");
               String username = resultSet.getString("username");
               String guid = resultSet.getString("guid");
               articles.add(new Article(id_art, name, code, username, guid));
            }

            connection.commit();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return articles;
    }
}
