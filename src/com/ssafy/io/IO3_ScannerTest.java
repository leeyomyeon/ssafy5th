package com.ssafy.io;

import java.util.Scanner;

public class IO3_ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("기수 : " + scanner.nextInt());
        System.out.println("이름 : " + scanner.nextLine());
    }
}
