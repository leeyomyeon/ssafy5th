package com.ssafy;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bm = BookManager.getInstance();;

        int sel;

        do {
            System.out.println("1. 도서추가");
            System.out.println("2. 도서삭제");
            System.out.println("3. 도서모두보기");
            System.out.println("4. 고유번호로 도서정보 반환");
            System.out.println("0. 종료");

            sel = sc.nextInt();

            if (sel == 1) {
                //도서추가
                System.out.print("도서 이름 : ");
                String title = sc.next();

                System.out.print("ISBN : ");
                String ISBN = sc.next();

                System.out.print("작가 : ");
                String author = sc.next();

                System.out.print("출판사 : ");
                String publisher = sc.next();

                System.out.print("설명 : ");
                String desc = sc.next();

                System.out.print("가격 : ");
                int price = sc.nextInt();

                bm.addBook(title, ISBN, author, publisher, price, desc);

            } else if (sel == 2) {
                //도서의 ISBN을 입력받아서,
                System.out.print("도서고유번호 : ");
                String ISBN = sc.next();

                bm.removeBook(ISBN);

            } else if (sel == 3) {
                for (Book b : bm.getList()) {
                    System.out.println(b);
                }

            } else if (sel == 4) {
                Book bi;

                System.out.println("도서고유번호 : ");
                String ISBN = sc.next();

                bi = bm.searchByISBN(ISBN);

                if (bi == null) {
                    System.out.println("해당 도서가 없습니다!!");
                } else {
                    System.out.println(bi);
                }
            }
        } while (sel != 0);
        sc.close();
    }
}
