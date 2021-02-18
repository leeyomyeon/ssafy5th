package study.baekjoon;

import java.util.Scanner;

public class Baek2567 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arr = new int[101][101];

        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for(int j = x; j < x + 10; j++) {
                for(int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        int count = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                if(arr[i][j] == 1) {
                    for(int k = 0; k < 4; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];

                        if(arr[newX][newY] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
