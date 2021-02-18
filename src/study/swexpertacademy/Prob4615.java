package study.swexpertacademy;

import java.util.Scanner;

public class Prob4615 {
    static int[] move = {-1, 0, 1};
    static int[][] arr;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            n = scanner.nextInt();
            arr = new int[n][n];

            arr[n / 2][n / 2] = 2;
            arr[n / 2 - 1][n / 2 - 1] = 2;
            arr[n / 2 - 1][n / 2] = 1;
            arr[n / 2][n / 2 - 1] = 1;


            int m = scanner.nextInt();

            for(int i = 0; i < m; i++) {
                int p = scanner.nextInt() - 1;
                int q = scanner.nextInt() - 1;
                int r = scanner.nextInt();

                arr[q][p] = r;

                othello(p, q, r);
            }

            int black = 0;
            int white = 0;
            for(int i = 0; i <n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == 1) {
                        black++;
                    } else if(arr[i][j] == 2) {
                        white++;
                    }
                }
            }

            System.out.println("#" + tc + " " + black + " " + white);
        }
    }

    public static void othello(int p, int q, int r) {
        for(int j = 0; j < move.length; j++) {
            for(int k = 0; k < move.length; k++) {
                
            }
        }
    }

}
