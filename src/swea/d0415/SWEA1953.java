package swea.d0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {
    static int N, M, R, C, L;
    static int[][] arr;
    static boolean[][] visited;
    public static class Location {
        int r;
        int c;
        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + tc + " " + bfs(new Location(R, C)));
        }
    }
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int[][] direction = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1}};

    public static int bfs(Location location) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(location);
        visited[location.r][location.c] = true;
        int time = 1;
        int count = 1;
        while(time++ < L) {
            int size = queue.size();

            while (size--> 0) {
                Location current = queue.poll();
                int[] dir = direction[arr[current.r][current.c]];

                for (int i = 0; i < 4; i++) {
                    if (dir[i] == 0) {
                        continue;
                    }
                    int nr = current.r + dr[i];
                    int nc = current.c + dc[i];

                    // 갈수있는 곳이면
                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && arr[nr][nc] != 0) {
                        if (direction[arr[nr][nc]][(i + 2) % 4] == 1) {  // 연결되어있으면
                            visited[nr][nc] = true;
                            count++;
                            queue.offer(new Location(nr, nc));
                        }
                    }
                }
            }
        }

        return count;
    }
}
