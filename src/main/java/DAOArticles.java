
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOArticles {
    public List<Article> getArticlesFromBD () {
        List<Article> articles = new ArrayList<>();
        String sql = "select id_art, name, code, username, guid from whs.article limit 10000";
        try(Connection connection = ConnectionPooling.getConnection(); Statement statement = connection.createStatement()){
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               long id_art = resultSet.getLong("id_art");
               String name = resultSet.getString("name");
               long code = resultSet.getLong("code");
               String username = resultSet.getString("username");
               String guid = resultSet.getString("guid");
               articles.add(new Article(id_art, name, code, username, guid));
            }

            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articles;
    }
}
