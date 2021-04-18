package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek7562 {
    public static int N;
    public static boolean[][] visited;
    public static class Point {
        int r;
        int c;
        int count;
        Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    // 8방 탐색
    public static int[] dr = {-2, -1, 1, 2, 2, 1, -2, -1};
    public static int[] dc = {1, 2, 2, 1, -1, -2, -1, -2};
    public static Point end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            System.out.println(bfs(R, C));
        }
    }

    public static int bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if(current.r == end.r && current.c == end.c) {
                // 종료조건
                return current.count;
            }
            visited[current.r][current.c] = true;

            for(int i = 0; i < 8; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                // 벗어나지마
                if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc, current.count + 1));
                }
            }
        }

        return 0;
    }
}
