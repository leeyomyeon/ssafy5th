package baekjoon.b0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1600 {
    static int K;
    static int W;
    static int H;
    static int[][] arr;
    static boolean[][][] visited;

    public static class Monkey {
        int p;
        int q;
        int cnt;
        int k;

        public Monkey(int p, int q, int cnt, int k) {
            this.p = p;
            this.q = q;
            this.cnt = cnt;
            this.k = k;
        }
    }
    public static int[] dp = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -2, -1};
    public static int[] dq = {0, 0, -1, 1, 1, 2, 2, 1, -1, -2, -1, -2};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[W][H];
        visited = new boolean[W][H][K + 1];

        Queue<Monkey> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.add(new Monkey(0, 0, 0, 0));

        int cnt = -1;
        while(!queue.isEmpty()) {
            Monkey m = queue.poll();
            if(m.p == W - 1 && m.q == H - 1) {
                cnt = m.cnt;
                break;
            }

            for(int d = 0; d < (m.k < K ? 12 : 4); d++) {
                int np = m.p + dp[d];
                int nq = m.q + dq[d];
                int nCnt = m.cnt + 1;
                int nK = (d >= 4 ? m.k + 1 : m.k);
                if(np < 0 || nq < 0 || np >= W || nq >= H) {
                    continue;
                }
                if(arr[np][nq] == 1){
                    continue;
                }
                if(visited[np][nq][nK]) {
                    continue;
                }
                visited[np][nq][nK] = true;
                queue.add(new Monkey(np, nq, nCnt, nK));
            }
        }

        System.out.println(cnt);
    }
}
