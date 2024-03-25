package org.example;

import dao.MemberDao;
import org.example.dao.ArticleDao;
import org.example.dto.Article;

public class Container {
    public  static ArticleDao articleDao;
    public  static MemberDao memberDao;

    static {
        articleDao = new ArticleDao();
        memberDao = new MemberDao();
    }
}
