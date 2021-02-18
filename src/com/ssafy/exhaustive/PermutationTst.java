package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTst {
    static int[] numbers;
    static boolean[] isSelected;
    static int N;
    static int count = 1;
    static void permutation(int cnt) {
        if(cnt == N) {
            System.out.println(count+" : "+ Arrays.toString(numbers));
            count++;
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(isSelected[i]) {
                continue;
            }

            numbers[cnt] = i;
            isSelected[i] = true;

            permutation(cnt + 1);

            isSelected[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        numbers = new int[N];
        isSelected = new boolean[N + 1];

        permutation(0);
    }
}
