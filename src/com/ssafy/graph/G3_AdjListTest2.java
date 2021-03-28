package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_AdjListTest2 {
    static int N;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        bfs();
        visited = new boolean[N];
        dfs(0);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        int start = 0;
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char)(current + 65));

            for(int temp : adjList[current]) {  // temp 는 current 와 인접인 번호
                if(!visited[temp]) {
                    queue.offer(temp);
                    visited[temp] = true;
                }
            }
        }
    }

    private static void dfs(int current) {
        visited[current] = true;

        System.out.println((char)(current + 45));

        for(int temp : adjList[current]) {
            if(!visited[temp]) {
                dfs(temp);
            }
        }
    }
}
