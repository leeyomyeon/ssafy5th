package swea.d0210;

import java.util.Scanner;

public class swea스도쿠 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int[][] arr = new int[9][9];
            boolean isOK = false;

            for(int i = 0; i < 9; i++) {        // 가로 검사
                int sum = 0;
                for(int j = 0; j < 9; j++) {
                    arr[i][j] = scanner.nextInt();
                    sum += arr[i][j];
                }
                if(sum != 45) {
                    isOK = true;
                }
            }

            if(isOK) {
                System.out.println("#" + tc + " 0");
                continue;
            }

            for(int i = 0; i < 9; i++) {        // 세로 검사
                int sum = 0;
                for(int j = 0; j < 9; j++) {
                    sum += arr[j][i];
                }
                if(sum != 45) {
                    isOK = true;
                    break;
                }
            }

            if(isOK) {
                System.out.println("#" + tc + " 0");
                continue;
            }

            for(int l = 0; l < 3; l++) {            // 네모칸 검사
                for (int k = 0; k < 3; k++) {
                    int sum = 0;
                    for (int i = 3 * l; i < 3 * (l + 1); i++) {
                        for (int j = 3 * k; j < 3 * (k + 1); j++) {
                            sum += arr[i][j];
                        }
                    }
                    if (sum != 45) {
                        isOK = true;
                        break;
                    }
                }
            }

            if(isOK) {
                System.out.println("#" + tc + " 0");
                continue;
            }

            System.out.println("#" + tc + " 1");
        }
    }
}
