package study.baekjoon;

import java.util.Scanner;

public class Baek1309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        }

        System.out.println(dp[N]);
    }
}
