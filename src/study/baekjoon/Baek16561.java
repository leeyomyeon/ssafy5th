package study.baekjoon;

import java.util.Scanner;

public class Baek16561 {
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int answer = 0;
        for(int i = 0; i < n / 3 - 1; i++) {
            answer += i;
        }

        System.out.println(answer);
    }
}
