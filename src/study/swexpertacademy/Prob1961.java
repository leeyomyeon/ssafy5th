package study.swexpertacademy;

import java.util.Scanner;

public class Prob1961 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            // 출력 편하게 하기 위해서 3개 만듬
            int[][] arr90 = rotate(arr);
            int[][] arr180 = rotate(arr90);
            int[][] arr270 = rotate(arr180);

            System.out.println("#" + tc);

            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();

                for(int j = 0; j < n; j++) {
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");

                for(int j = 0; j < n; j++) {
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");

                for(int j = 0; j < n; j++) {
                    sb.append(arr270[i][j]);
                }

                System.out.println(sb.toString());
            }
        }
    }

    public static int[][] rotate(int[][] arr) {
        int k = arr.length;

        int[][] tmp = new int[k][k];

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                tmp[i][j] = arr[k - 1 - j][i];
            }
        }

        return tmp;
    }
}
