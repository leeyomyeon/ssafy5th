package baekjoon.b0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2458 {
    public static int[][] adjMatrix;
    public static int N, M;
    public static int gCount, lCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjMatrix = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {    // 학생들을 M번만큼 비교함(간선 수)
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = 1; // from은 to보다 키가 작다
        }
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            gCount = 0;
            lCount = 0;
            gtBfs(i);
            ltBfs(i);
            if(gCount + lCount == N - 1) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    private static void gtBfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i <= N; i++) {
                if(!visited[i] && adjMatrix[current][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    gCount++;
                }
            }
        }
    }

    private static void ltBfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i <= N; i++) {
                if(!visited[i] && adjMatrix[i][current] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    lCount++;
                }
            }
        }
    }
}
