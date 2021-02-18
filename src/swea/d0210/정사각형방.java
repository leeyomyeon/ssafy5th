package swea.d0210;

import java.util.Scanner;

public class 정사각형방 {
    static int count;
    static int n;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T =scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = scanner.nextInt();

            arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int max = 0;
            int min = 10000000;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j <n; j++) {
                    count = 1;
                    move(i,j);
                    if(count == max && arr[i][j] > min) {
                        continue;
                    }
                    if(count >= max) {
                        max = count;
                        min = arr[i][j];
                    }
                }
            }

            System.out.println("#" + tc + " " + min + " " + max);
        }
    }

    public static void move(int p, int q) {
        if(p - 1 >= 0 && arr[p - 1][q] == arr[p][q] + 1) {   // 위로 이동
            count++;
            move(p - 1, q);
            return;
        }
        if(p + 1 < n && arr[p + 1][q] == arr[p][q] + 1) {   // 아래로 이동
            count++;
            move(p + 1, q);
            return;
        }
        if(q - 1 >= 0 && arr[p][q - 1] == arr[p][q] + 1) {   // 왼쪽으로 이동
            count++;
            move(p, q - 1);
            return;
        }
        if(q + 1 < n && arr[p][q + 1] == arr[p][q] + 1) {   // 오른쪽으로 이동
            count++;
            move(p, q + 1);
        }
    }
}
