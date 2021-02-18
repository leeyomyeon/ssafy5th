package study.swexpertacademy;

import java.util.Scanner;

public class Prob1979 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();      // 단어의 길이

            int[][] arr = new int[n][n];

            int[] num = new int[n + 1];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            // 가로 검사
            for(int i = 0; i < n; i++) {
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == 1) {
                        count++;
                        if(j == n-1) {
                            num[count]++;
                        }
                    } else {
                        if(count >= 2) {
                            num[count]++;
                        }
                        count = 0;
                    }
                }
            }
            // 세로 검사
            for(int i = 0; i < n; i++) {
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(arr[j][i] == 1) {
                        count++;
                        if(j == n-1) {
                            num[count]++;
                        }
                    } else {
                        if(count >= 2) {
                            num[count]++;
                        }
                        count = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + num[k]);
        }
    }
}
