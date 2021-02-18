package com.java.first;

import java.util.Scanner;

public class Compute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("곱="+(a*b));
        System.out.println("몫="+(a/b));

        scanner.close();
    }
}
