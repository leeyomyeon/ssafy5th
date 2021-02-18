package baekjoon.b0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2468 {
    static int n;
    static int[][] arr;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }

        int maxCount = 0;
        for(int k = 0; k <= maxHeight; k++) {
            int count = 0;
            map = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] > k && !map[i][j]) {
                        safety(i, j, k);
                        count++;
                    }
                }
            }

            if(count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }

    static int[] dp = {-1, 1, 0, 0};
    static int[] dq = {0, 0, -1, 1};
    public static void safety(int p, int q, int r) {
        map[p][q] = true;
        // map 을 0으로 만듬
        for(int i = 0; i < 4; i++) {
            int np = p;
            int nq = q;
            np += dp[i];
            nq += dq[i];
            if(np >= 0 && nq >= 0 && np < n && nq < n && arr[np][nq] > r && !map[np][nq]) {
                map[np][nq] = true;
                safety(np, nq, r);
            }
        }
    }
}
