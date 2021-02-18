package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {
    public static void main(String[] args) {
        String s1 = "안 \n녕\n";
        Scanner sc = new Scanner(s1);

        System.out.println("읽은 문자열 : " + sc.next());
        System.out.println(",읽은 문자열 : " + sc.next());
        System.out.println("\n=============================");

        String s2 = "안 녕\n";
        Scanner sc2 = new Scanner(s2);
        System.out.println("읽은 문자열 : " + sc2.nextLine());
        System.out.println("\n=============================");

        String s3 = "안 \n   녕\n";
        Scanner sc3 = new Scanner(s3);
        System.out.print("읽은 문자열 : " + sc3.nextLine());
        System.out.print("읽은 문자열 : " + sc3.nextLine());
    }
}
