package com.ssafy.dp;

import java.util.Scanner;

public class DP2_LISTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N];
        int[] LIS = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            LIS[i] = 1; // 혼자 세웠을 때
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
                if(max < LIS[i]) {
                    max = LIS[i];
                }
            }
        }

        System.out.println(max);
    }
}
