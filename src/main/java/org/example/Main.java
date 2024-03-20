package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로젝트 시작 ==");


        Scanner sc = new Scanner(System.in);
        int lastArticleId = 0;

        List<Article> articles = new ArrayList<>();


        String cmd;
        while (true) {
            System.out.printf("명령어) ");
            cmd = sc.nextLine();
            cmd = cmd.trim();


            if (cmd.length() == 0) {
                continue;
            }

            if (cmd.equals("exit")) {
                break;
            }


            if (cmd.equals("article write")) {
                int id = lastArticleId + 1;
                lastArticleId = id;
                System.out.printf("제목 :");
                String title = sc.nextLine();
                System.out.printf("내용 :");
                String body = sc.nextLine();

                articles.add(new Article(id, title, body));

                System.out.printf("%d번 글이 생성되었습니다.\n", id);
            } else if (cmd.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("게시물이 없습니다.");
                    continue;
                }

                System.out.println("번호 | 제목");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    System.out.printf("%d | %s\n", article.id, article.title);
                }

            }

            else if (cmd.startsWith("article detail")) {
                System.out.print("게시물 번호 : ");
                int articleId = sc.nextInt();
                sc.nextLine();

                Article foundArticle = null;
                for (Article article : articles) {
                    if (article.id == articleId) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle != null) {
                    LocalDateTime currentTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    System.out.println("날짜: " + currentTime.format(formatter));
                    System.out.println("제목: " + foundArticle.title);
                    System.out.println("내용: " + foundArticle.body);
                } else {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", articleId);
                }
            } else {
                System.out.printf("%s(은)는 존재하지 않는 명령어입니다.\n", cmd);
            }
        }
        sc.close();
        System.out.println("== 프로젝트 끝 ==");
    }
}

class Article {
    int id;
    String title;
    String body;

    public Article(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
