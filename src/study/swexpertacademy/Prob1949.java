package study.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1949 {
    static int N;
    static int K;
    static boolean[][] visited;
    static int[][] arr;
    static int maxLen;
    static int cut;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            visited = new boolean[N][N];

            int max = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(max <= arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }

            maxLen = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == max) {
                        visited[i][j] = true;
                        cut = 0;
                        dfs(i, j, 1);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + maxLen);
        }
    }

    static int[] dp = {-1, 1, 0, 0};
    static int[] dq = {0, 0, -1, 1};

    public static void dfs(int p, int q, int count) {
        maxLen = Math.max(maxLen, count);

        for(int i = 0; i < 4; i++) {
            int np = p + dp[i];
            int nq = q + dq[i];

            if(np < 0 || nq < 0 || np >= N || nq >= N || visited[np][nq]) {
                continue;
            }

            if(arr[p][q] <= arr[np][nq]) {
                if(cut == 0) {
                    for(int j = 1; j <= K; j++) {
                        int tmp = arr[np][nq];
                        int land = arr[np][nq] - j;

                        if(arr[p][q] > land) {
                            visited[np][nq] = true;
                            arr[np][nq] = land;
                            cut++;
                            dfs(np, nq, count+1);
                            cut--;
                            arr[np][nq] = tmp;
                            visited[np][nq] = false;
                        }
                    }
                }
            } else {
                visited[np][nq] = true;
                dfs(np, nq, count+1);
                visited[np][nq] = false;
            }
        }
    }
}
