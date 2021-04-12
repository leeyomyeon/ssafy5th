package study.baekjoon;

import java.util.Scanner;

public class Baek9663 {
    public static int[] arr;
    public static int N;
    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        arr = new int[N + 1];

        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int row) {
        for(int i = 1; i < row; i++) {
            // 해당 행에 퀸이 있을 경우             대각선에 놓여있는 경우
            if(arr[row] == arr[i] || Math.abs(arr[row] - arr[i]) == row - i) {
                return;
            }
        }
        if(row == N) {
            count++;
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[row + 1] = i;
            dfs(row + 1);
        }
    }
}
