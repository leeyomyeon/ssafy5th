package baekjoon.b0210;

import java.util.Scanner;

public class 배열돌리기1 {
    private static int[][] arr;

    private static int n;
    private static int m;
    private static int r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt();

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        while(r > 0) {
            rotate(0);
            r--;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int a) {
        int k = Math.min(m, n);
        if(a == k / 2) {
            return;
        }

        int temp = arr[a][a];
        int i = a, j = a;
        arr[i][j] = temp;

        for(; j < m - a - 1; j++) {
            arr[i][j] = arr[i][j + 1];
        }
        for(; i < n - a - 1; i++) {
            arr[i][j] = arr[i + 1][j];
        }
        for(; j > a; j--) {
            arr[i][j] = arr[i][j - 1];
        }
        for(; i > a; i--) {
            arr[i][j] = arr[i - 1][j];
        }
        arr[i + 1][j] = temp;

        rotate(a + 1);
    }
}
