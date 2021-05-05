package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1260 {
    public static int N, M, V;
    public static boolean[] visited;
    public static int[][] arr;
    public static StringBuilder dfsSb;
    public static StringBuilder bfsSb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        visited = new boolean[N + 1];
        dfsSb = new StringBuilder();
        dfsSb.append(V).append(" ");
        dfs(V);

        visited = new boolean[N + 1];
        bfsSb = new StringBuilder();
        bfsSb.append(V).append(" ");
        bfs(V);

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    public static void dfs(int v) {
        int current = v;
        visited[v] = true;
        for(int i = 1; i <= N; i++) {
            if(arr[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfsSb.append(i).append(" ");
                dfs(i);
            }
        }
    }
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i = 1; i <= N; i++) {
                if(arr[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    bfsSb.append(i).append(" ");
                }
            }
        }
    }
}
