package baekjoon.b0217;

import java.util.Scanner;

public class Baekjoon4963 {
    public static int[][] map;
    public static int w;
    public static int h;
    public static int count;
    public static int[] move = {-1, 0, 1};
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            if(w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];

            count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        go(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
    public static void go(int m, int n) {
        for (int k : move) {
            for (int i : move) {
                if(k == 0 && i == 0) {
                    continue;
                }
                int dh = m;
                int dw = n;
                dh += k;
                dw += i;
                if (dw >= 0 && dh >= 0 && dw < w && dh < h && map[dh][dw] == 1) {
                    map[dh][dw] = 0;
                    go(dh, dw);
                }
            }
        }
    }
}