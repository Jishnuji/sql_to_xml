package service;

import dao.DAOArticles;
import dao.DAOArticlesJDBCImpl;
import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceArticles {
    DAOArticles daoArticles = new DAOArticlesJDBCImpl();
    ResultSet resultSet = daoArticles.getArticleResultSetFromDB();

    public List<Article> getArticlesFromResultSet() {
        List<Article> articles = new ArrayList<>();
        Optional<ResultSet> optionalResultSet = Optional.ofNullable(resultSet);

        try {
            if(optionalResultSet.isPresent()) {
                while (resultSet.next()) {
                    long id_art = resultSet.getLong("id_art");
                    String name = resultSet.getString("name");
                    long code = resultSet.getLong("code");
                    String username = resultSet.getString("username");
                    String guid = resultSet.getString("guid");
                    articles.add(new Article(id_art, name, code, username, guid));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
