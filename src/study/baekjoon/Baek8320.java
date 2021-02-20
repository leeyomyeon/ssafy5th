package study.baekjoon;

import java.util.Scanner;

public class Baek8320 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            int j = 1;
            while (i * j <= n) {
                cnt++;
                j++;
            }
        }
        int s = (int) Math.sqrt(n);
        cnt -= s;
        cnt /= 2;
        cnt += s;
        System.out.println(cnt);
    }
}
