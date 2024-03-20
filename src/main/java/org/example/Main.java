package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("== 프로젝트 시작 ==");

        Scanner sc = new Scanner(System.in);
        int lastArticleId = 0;


        while (true){
            System.out.printf("명령어) ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();


            if(cmd.length() == 0) {
                continue;
            }

            if(cmd.equals("exit")){
                break;
            }
            if(cmd.equals("article write")){ //article = 게시물
                int id = lastArticleId + 1; // 갱신
                lastArticleId = id;
                System.out.printf("제목 :");
                String title = sc.nextLine();
                System.out.printf("내용 :");
                String body = sc.nextLine();

                System.out.printf("%d번 글이 생성 되었습니다\n", id);
            }

            else if(cmd.equals("article list")){ //article = 게시물
                System.out.println("게시물이 없습니다.");
            }
            else {
                System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", cmd);
            }

        }


        sc.close();
        System.out.println("== 프로젝트 끝 ==");

    }
}