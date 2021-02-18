package com.ssafy.divide;

import java.util.Scanner;

public class SquareNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(exp(x, y));
    }

    public static long exp(long x, long y) {
        if(y == 1) {
            return x;
        }
        long r = exp(x, y / 2);
        long result = r * r;

        if(y % 2 == 1) {
            result *= x;
        }

        return result;

    }
}
