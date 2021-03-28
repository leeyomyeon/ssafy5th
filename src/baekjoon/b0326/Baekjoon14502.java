package baekjoon.b0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14502 {
    public static int m;
    public static int n;
    public static int[][] arr;

    public static int[] dp = {-1, 1, 0, 0};
    public static int[] dq = {0, 0, -1, 1};

    public static int[][] tmp;
    public static int[][] virusMap;
    public static int count;
    public static int max;

    public static class Virus {
        int p;
        int q;
        public Virus(int p, int q){
            this.p = p;
            this.q = q;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    copyMap();
                    tmp[i][j] = 1;
                    makeWall(1);
                    tmp[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs() {
        Queue<Virus> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(tmp[i][j] == 2) {
                    q.add(new Virus(i, j));
                }
            }
        }
        copyVirus();
        while (!q.isEmpty()) {
            Virus v = q.poll();

            for(int i = 0; i < 4; i++) {
                int np = v.p + dp[i];
                int nq = v.q + dq[i];
                if(np < 0 || nq < 0 || np >= m || nq >= n || virusMap[np][nq] != 0) {
                    continue;
                }
                virusMap[np][nq] = 2;
                q.add(new Virus(np, nq));
            }
        }
        count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++) {
                if(virusMap[i][j] == 0) {
                    count++;
                }
            }
        }

        if(count > max) {
            max = count;
        }
    }

    public static void makeWall(int idx) {
        if(idx == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(tmp[i][j] == 0) {
                    tmp[i][j] = 1;
                    makeWall(idx + 1);
                    tmp[i][j] = 0;
                }
            }
        }
    }

    public static void copyMap() {
        tmp = new int[m][n];
        for(int i = 0; i < m; i++) {
            if (n >= 0) System.arraycopy(arr[i], 0, tmp[i], 0, n);
        }
    }

    public static void copyVirus() {
        virusMap = new int[m][n];
        for(int i = 0; i < m; i++) {
            if (n >= 0) System.arraycopy(tmp[i], 0, virusMap[i], 0, n);
        }
    }
}
