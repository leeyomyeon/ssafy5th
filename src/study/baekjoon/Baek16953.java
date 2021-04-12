package study.baekjoon;

import java.util.Scanner;

public class Baek16953 {
    static int A;
    static int B;
    static int min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        min = Integer.MAX_VALUE;
        bfs(A, 1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    public static void bfs(double result, int count) {
        if(result > B) {
            return;
        }
        if(result == B) {
            min = Math.min(count, min);
            return;
        }
        bfs(result * 2, count + 1);
        bfs(result * 10 + 1, count + 1);
    }
}
