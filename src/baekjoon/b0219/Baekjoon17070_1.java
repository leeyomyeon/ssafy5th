package baekjoon.b0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17070_1 {
    static int n;
    static int[][] arr;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        pipe(0, 1, 0);
        System.out.println(count);
    }

    static int[] rotateP = {0, 1, 1};
    static int[] rotateQ = {1, 1, 0};

    public static void pipe(int p, int q, int d) {
        if(p == n - 1 && q == n - 1) {
            count++;
            return;
        }

        int i = 0, j = 0;

        if(d == 0) {            // 파이프 모양이 가로
            i = 0;
            j = 1;
        } else if (d == 1) {    // 파이프 모양이 대각선
            i = 0;
            j = 2;
        } else if(d == 2) {     // 파이프 모양이 세로
            i = 1;
            j = 2;
        }

        for(; i <= j; i++) {
            int np = p;
            int nq = q;
            np += rotateP[i];
            nq += rotateQ[i];

            if(np >= n || nq >= n) {
                // 벽 나가면 다른방향 찾음
                continue;
            }
            if(arr[np][nq] == 1) {
                // 가려는 방향에 벽이 있으면 다음 방향 찾음
                continue;
            }
            if(i == 1 && ((np - 1 >= 0 && arr[np - 1][nq] == 1) || (nq - 1 >= 0 && arr[np][nq - 1] == 1))) {
                // 대각선이었고 종착점 기준 왼쪽이나 위에 벽이 있으면 다음 방향 찾음
                continue;
            }

            pipe(np, nq, i);
        }
    }
}
