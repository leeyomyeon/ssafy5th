package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2178 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        min = Integer.MAX_VALUE;
        bfs();
        System.out.println(min);
    }

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0 ,-1, 1};
    public static class Direction {
        int r;
        int c;
        int count;
        public Direction(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    public static void bfs() {
        Queue<Direction> queue = new LinkedList<>();
        queue.add(new Direction(0, 0, 1));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Direction direction = queue.poll();
            if(direction.r == N - 1 && direction.c == M - 1) {
                if(direction.count < min) {
                    min = direction.count;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nr = direction.r + dr[i];
                int nc = direction.c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && arr[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Direction(nr, nc, direction.count + 1));
                }
            }
        }
    }
}
