package swea.algo대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단식원 {
    static int[][] arr;
    static int[][] tmpArr;
    static int[][] smellArr;
    static int R, C, max, count;

    public static class Chicken {
        int r;
        int c;

        public Chicken(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new int[R][C];

            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(arr[i][j] == 0) {
                        copyMap();
                        tmpArr[i][j] = 1;
                        makePerfume(1);
                        tmpArr[i][j] = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }

    }

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void bfs() {
        Queue<Chicken> queue = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(tmpArr[i][j] == 2) {
                    queue.add(new Chicken(i, j));
                }
            }
        }

        copySmell();

        while (!queue.isEmpty()) {
            Chicken current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C || smellArr[nr][nc] != 0) {
                    continue;
                }
                smellArr[nr][nc] = 2;
                queue.add(new Chicken(nr, nc));
            }
        }

        count = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(smellArr[i][j] == 0) {
                    count++;
                }
            }
        }

        if(count > max) {
            max = count;
        }
    }

    public static void makePerfume(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(tmpArr[i][j] == 0) {
                    tmpArr[i][j] = 1;
                    makePerfume(cnt + 1);
                    tmpArr[i][j] = 0;
                }
            }
        }
    }

    public static void copyMap() {
        tmpArr = new int[R][C];
        for(int i = 0; i < R; i++) {
            System.arraycopy(arr[i],0, tmpArr[i], 0, C);
        }
    }

    public static void copySmell() {
        smellArr = new int[R][C];
        for(int i = 0; i < R; i++) {
            System.arraycopy(tmpArr[i],0, smellArr[i], 0, C);
        }
    }

}
