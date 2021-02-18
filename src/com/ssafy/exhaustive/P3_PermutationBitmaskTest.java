package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class P3_PermutationBitmaskTest {
    static int N;
    static int[] numbers;
    static int[] input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        numbers = new int[N];
        input = new int[N];

        for(int i = 0; i < N; i++) {
            input[i] = scanner.nextInt();
        }

        permutation(0, 0);
    }

    private static void permutation(int cnt, int flag) {
        if(cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) == 1) {
                continue;
            }

            numbers[cnt] = input[i];
            permutation(cnt + 1, flag | 1 << i);
        }
    }
}

