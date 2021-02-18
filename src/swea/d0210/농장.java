package swea.d0210;

import java.util.Scanner;

public class 농장 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0;

            for(int i = 0; i < n; i++) {
                String str = scanner.next();

                for(int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            for(int i = 0; i < n; i++) {
                if(i <= n / 2) {
                    for(int j = n / 2 - i; j <= n / 2 + i; j++) {
                        sum += arr[i][j];
                    }
                } else {
                    for(int j = n / 2 - (n - i - 1) ; j <= n / 2 + (n - i - 1) ; j++) {
                        sum += arr[i][j];
                    }
                }
            }

            System.out.println("#" + tc + " " + sum);
        }

        scanner.close();
    }
}
