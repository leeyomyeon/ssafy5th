package com.ssafy.dp;

import java.util.Scanner;

public class DP1_KnapsackTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 물건의 개수
        int W = scanner.nextInt(); // 가방의 무게

        int[] weights = new int[N + 1]; // 물건의 무게 정보
        int[] profits = new int[N + 1]; // 물건의 가치 정보
        int[][] D = new int[N + 1][W + 1]; // 해당 물건까지 고려하여 해당 무게를 만들때까지의 최대 가치

        for(int i = 1; i <= N; i++) {
            weights[i] = scanner.nextInt();
            profits[i] = scanner.nextInt();
        }


        for(int i = 1; i <= N; i++) {
            for(int w = 0; w <= W; w++) {
                if(weights[i] <= w) { // 가방에 넣을 수 있으면
                    D[i][w] = Math.max(D[i - 1][w - weights[i]] + profits[i], D[i - 1][w]);

                } else {            // 가방에 넣지 못하면
                    D[i][w] = D[i - 1][w];
                }
            }
        }

        System.out.println(D[N][W]);
    }
}
