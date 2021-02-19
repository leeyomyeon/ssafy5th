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
                int np = p;
                int nq = q;
                np += move[j];
                nq += move[k];
                if(r == 1 && np >= 0 && nq >= 0 && np < n && nq < n) {
                    if(arr[np][nq] == 2) {
                        while(true) {
                            np += move[j];
                            nq += move[k];
                            if(arr[np][nq] == 2 && np >= 0 && nq >= 0 && np < n && nq < n) {
                                for(int i = p; i < np; i++) {
                                    for(int l = q; l < nq; l++) {
                                        arr[i][l] = 1;
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else if (r == 2 && np >= 0 && nq >= 0 && np < n && nq < n) {
                    if(arr[np][nq] == 1) {
                        while(true) {
                            np += move[j];
                            nq += move[k];
                            if(arr[np][nq] == 1 && np >= 0 && nq >= 0 && np < n && nq < n) {
                                for(int i = p; i < np; i++) {
                                    for(int l = q; l < nq; l++) {
                                        arr[i][l] = 2;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}
