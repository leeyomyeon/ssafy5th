package com.ssafy.back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_12_식당_풀이 {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        makePipe();
        System.out.println(count);
    }

    private static void makePipe() {
        count = 0;
        for(int i = 0; i < R; i++) {
            visited[i][0] = true;
            dfs(i, 0);
        }
    }
    static int[] dr = {-1, 0, 1};
    static int count;

    private static boolean dfs(int r, int c) {
        if(c == C - 1) {
            count++;
            return true;
        }

        int nr, nc = c + 1;
        for(int i = 0; i < 3; i++) {
            nr = r + dr[i];
            if(nr < 0 || nr >= R || map[nr][nc] == 'x' || visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            if(dfs(nr, nc)) {
                return true;
            }
        }

        return false;
    }
}
