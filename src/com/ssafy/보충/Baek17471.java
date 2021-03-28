package com.ssafy.보충;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek17471 {
    static int N;   // 도시 수
    static int[] p;
    static int[][] map; // 도시 연결관리 인접 행렬
    static int[] teams;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        p = new int[N + 1];
        map = new int[N + 1][N + 1];
        teams = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            p[i] = scanner.nextInt();
        }

        int cnt;
        int k;
        for(int i = 1; i <= N; i++) {
            cnt = scanner.nextInt();
            for(int j = 0; j < cnt; j++) {
                k = scanner.nextInt();
                map[i][k] = 1;
                map[k][i] = 1;
            }
        }

        // 동작
        dfs(0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static boolean check(int type) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[N + 1];

        for(int i = 1; i < N; i++) {
            if(teams[i] == type) {
                q.offer(i);
                v[i] = true;
                break;
            }
        }

        if(q.size() == 0) {
            return false;
        }

        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int i = 1; i <= N; i++) {
                if(map[cur][i] == 0 || v[i] || teams[i] != type) {
                    continue;
                }
                v[i] = true;
                q.offer(i);
            }
        }

        for(int i = 1; i <= N; i++) {
            if(teams[i] != type) {
                continue;
            }
            if(!v[i]) {
                return false;
            }
        }

        return true;
    }
    public static int getCount() {
        int team1 = 0;
        int team2 = 0;
        for(int i = 1; i <= N; i++) {
            if(teams[i] == 0) {
                team1 += teams[i];
            } else if (teams[i] == 1) {
                team2 += teams[i];
            }
        }
        return Math.abs(team1 - team2);
    }
    static void dfs(int idx) {
        if(idx == N + 1) {
            if(check(0) && check(1)) {
                int r = getCount();
                result = Math.min(result, r);

            }
            return;
        }
        teams[idx] = 0;
        dfs(idx + 1);

        teams[idx] = 1;
        dfs(idx + 1);
    }
}
