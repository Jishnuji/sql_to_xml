package dao;

import model.Article;

import java.util.List;

public interface DAOArticles {
    List<Article> getArticlesFromDB ();
}
