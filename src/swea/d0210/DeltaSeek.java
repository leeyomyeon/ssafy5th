package swea.d0210;

import java.util.Arrays;
import java.util.Scanner;

public class DeltaSeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            int[][] tmp = new int[n+2][n+2];
            int[][] arr2 = new int[n][n];

            for(int i = 0; i < n; i++) {
                String str = scanner.next();

                for(int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            for(int i = 1; i < tmp.length-1; i++) {
                for(int j = 1; j < tmp.length-1; j++) {
                    tmp[i][j] = arr[i-1][j-1];
                }
            }

            for(int i = 1; i <= arr2.length; i++) {
                for(int j = 1; j <= arr2.length; j++) {
                    arr2[i-1][j-1] = tmp[i][j] + tmp[i-1][j] + tmp[i+1][j] + tmp[i][j-1] + tmp[i][j+1];
                }
            }

            System.out.println("arr");
            for(int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }

            System.out.println("arr2");
            for(int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(arr2[i]));
            }

            System.out.println("#"+tc+" ");
        }
    }
}
