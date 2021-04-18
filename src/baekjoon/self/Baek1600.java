package baekjoon.self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1600 {
    public static int K;
    public static int C, R;
    public static int[][] arr;
    public static boolean[][][] visited;
    public static int min;
    public static class Point {
        int r;
        int c;
        int move;
        int cnt;

        public Point(int r, int c, int move, int cnt) {
            this.r = r;
            this.c = c;
            this.move = move;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new boolean[R][C][K + 1];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        bfs(new Point(0, 0, 0, 0));
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static int[] dr = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -2, -1};
    public static int[] dc = {0, 0, -1, 1, 1, 2, 2, 1, -1, -2, -1, -2};
    public static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.r][p.c][p.cnt] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.r == R - 1 && current.c == C - 1) {
                min = Math.min(min, current.move);
                break;
            }

            for(int i = 0; i < (current.cnt < K ? 12 : 4) ; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                // 말처럼 이동 해보기
                int nCnt = (i >= 4 ? current.cnt + 1 : current.cnt);
                if(nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc][nCnt] && arr[nr][nc] == 0) {
                    visited[nr][nc][nCnt] = true;
                    queue.add(new Point(nr, nc, current.move + 1, nCnt));
                }
            }
        }

    }
}
