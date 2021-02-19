package baekjoon.b0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17136 {
    static int[][] arr;
    static final int n = 10;
    static int ans;
    static int[] quantity = {0, 5, 5, 5, 5, 5};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 99999;
        color(0);
        System.out.println(ans == 99999 ? -1 : ans);
    }

    public static void color(int count) {
        int sR = -1, sC = -1;
        Loop1:
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(arr[i][j] == 1) {
                    sR = i;
                    sC = j;
                    break Loop1;
                }
            }
        }

        if(sR == -1 && sC == -1) {
            ans = Math.min(ans, count);
            return;
        }

        int max = 5;

        while(max > 0) {
            boolean isOK = true;
            // max 크기로 색종이 붙일수 있는지
            Loop2:
            for(int i = 0; i < max; i++) {
                for(int j = 0; j < max; j++) {
                    if(sR + i >= 10 || sC + j >= 10 || arr[sR + i][sC + j] == 0) {
                        isOK = false;
                        break Loop2;
                    }
                }
            }
            if(isOK) {
                break;
            }
            max--;
        }

        for(int i = 1; i <= max; i++) {
            if(quantity[i] == 0) {
                continue;
            }

            for(int r = sR; r < sR + i; r++) {
                for(int c = sC; c < sC + i; c++) {
                    arr[r][c] = 0;
                }
            }
            quantity[i]--;
            color(count + 1);
            for(int r = sR; r < sR + i; r++) {
                for(int c = sC; c < sC + i; c++) {
                    arr[r][c] = 1;
                }
            }
            quantity[i]++;
        }
    }
}
