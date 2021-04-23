package baekjoon.b0421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16985 {
    public static int[][][] tmpArr, arr;
    public static int N = 5;
    public static int[] floor, rotate;
    public static boolean[] selected;
    public static int min = Integer.MAX_VALUE;
    public static class Point {
        int h, r, c;
        int move;
        public Point(int h, int r, int c, int move) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tmpArr = new int[N][N][N];
        arr = new int[N][N][N];
        floor = new int[N];
        selected = new boolean[N];
        rotate = new int[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        makeFloor(0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void makeFloor(int cnt) {    // 층 순서 만들기(순열)
        if(cnt == N) {
            makeRotate(floor, 0);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!selected[i]) {
                floor[cnt] = i;
                selected[i] = true;
                makeFloor(cnt + 1);
                selected[i] = false;
            }
        }
    }

    public static void makeRotate(int[] f, int cnt) {    // 회전순서(중복순열)
        if(cnt == N) {
            // 배열 회전하고 쌓은 순서대로 복사
            copyArr(f, rotate);
            // 여기서 dfs bfs 구현
            bfs(new Point(0, 0, 0, 0));
            return;
        }

        for(int i = 0; i < 4; i++) {
            rotate[cnt] = i;
            makeRotate(f, cnt + 1);
        }
    }

    public static int[] dh = {0, 0, 0, 0, -1, 1};
    public static int[] dr = {-1, 1, 0, 0, 0, 0};
    public static int[] dc = {0, 0, -1, 1, 0, 0};
    public static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        boolean[][][] visited = new boolean[N][N][N];
        visited[p.h][p.r][p.c] = true;
        if(tmpArr[p.h][p.r][p.c] == 0 || tmpArr[N - 1][N - 1][N - 1] == 0) {
            return;
        }
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            if(current.h == N - 1 && current.r == N - 1 && current.c == N - 1) {
                min = Math.min(min, current.move);
                return;
            }
            for(int i = 0; i < 6; i++) {
                int nh = current.h + dh[i];
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                boolean border = nh >= 0 && nr >= 0 && nc >= 0 && nh < N && nr < N && nc < N;
                if(border && !visited[nh][nr][nc] && tmpArr[nh][nr][nc] == 1) {
                    visited[nh][nr][nc] = true;
                    queue.add(new Point(nh, nr, nc, current.move + 1));
                }
            }
        }
    }

    public static void copyArr(int[] f, int[] r) {  // 배열 복사
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.arraycopy(arr[f[i]][j], 0, tmpArr[i][j], 0, N);
            }
            for(int k = 0; k < r[i]; k++) {// 여기서 회전
                tmpArr[i] = rotateArr(i);   // i번째 층을 r[i]만큼 회전
            }
        }
    }

    public static int[][] rotateArr(int f) {   // 배열 회전
        int[][] tmp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                tmp[i][j] = tmpArr[f][N - j -1][i];
            }
        }
        return tmp;
    }
}
