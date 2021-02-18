package swea.d0210;

import java.util.Scanner;

public class 파리퇴치 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int sum = 0;

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            for(int i = 0; i <= n - m; i++) {
                for(int j = 0; j <= n - m; j++) {
                    int tmp = 0;

                    for(int k = i; k < i + m; k++) {
                        for(int l = j; l < j + m; l++) {
                            tmp += arr[k][l];
                        }
                    }

                    if(tmp > sum) {
                        sum = tmp;
                    }
                }
            }

            System.out.println("#"+ tc +" "+sum);
        }

        scanner.close();
    }
}
