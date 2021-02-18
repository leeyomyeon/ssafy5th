package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
    static int[] numbers;
    static int n;
    static int r;
    static int count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        r = scanner.nextInt();

        numbers = new int[r];

        Combination(0, 1);
    }

    private static void Combination(int cnt, int start) {
        if(cnt == r) {
            System.out.println(count+" : "+ Arrays.toString(numbers));
            count++;
            return;
        }
        for(int i = start; i <= n; i++) {
            numbers[cnt] = i;
            Combination(cnt + 1, i + 1);
        }
    }
}
