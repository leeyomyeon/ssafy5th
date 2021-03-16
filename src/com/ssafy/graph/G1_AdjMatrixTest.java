package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
무향 그래프 인접행렬
7개의 정점, 8개의 간선
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
public class G1_AdjMatrixTest {
    static int N;
    static boolean[][] adjMatrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        adjMatrix = new boolean[N][N];
        StringTokenizer st = null;

        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = adjMatrix[to][from] =true;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        // 탐색 시작점 : 0
        int start = 0;
        queue.offer(0);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char)(current + 65));

            for(int i = 0; i < N; i++) {
                if(adjMatrix[current][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
