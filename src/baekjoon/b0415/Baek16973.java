package baekjoon.b0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16973 {
    public static int N, M;
    public static int H, W;
    public static int[][] arr;
    public static Position start;
    public static Position end;
    public static boolean[][] visited;
    public static class Position {
        int r;
        int c;
        int count;
        public Position(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        // 직사각형 크기
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        // 시작 좌표
        start = new Position(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, 0);
        // 도착 좌표
        end = new Position(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, 0);

        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        visited[start.r][start.c] = true;

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if(current.r == end.r && current.c == end.c) {
                result = current.count;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr <= N - H && nc <= M - W && !visited[nr][nc]) {
                    if (wallCheck(nr, nc)) { // 새로운 칸에서 정사각형 둘레에 벽이 있는지 검사
                        continue;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new Position(nr, nc, current.count + 1));
                }
            }

        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static boolean wallCheck(int nr, int nc) {
        // 가로 위,아래 검사
        for(int j = nc; j < nc + W; j++) {
            if(arr[nr][j] == 1 || arr[nr + H - 1][j] == 1) {
                // 1이 있어서 못감
                return true;
            }
        }
        // 세로 왼쪽, 오른쪽 검사
        for(int j = nr; j < nr + H; j++) {
            if(arr[j][nc] == 1 || arr[j][nc + W - 1] == 1) {
                // 1이 있어서 못감
                return true;
            }
        }
        return false;
    }
}
