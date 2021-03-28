package study.baekjoon;

import java.util.Scanner;

public class Baek2225 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long[][] d = new long[K + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            d[1][i] = 1;        // k가 1일때 경우의 수는 전부 1개
        }
        for(int i = 1; i <= K; i++) {
            d[i][1] = i;        // n이 1일때 경우의 수는 전부 k개
        }

        for(int i = 2; i <= K; i++) {
            for(int j = 2; j <= N; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1];
                d[i][j] %= 1000000000;
            }
        }

        System.out.println(d[K][N]);
    }
}
