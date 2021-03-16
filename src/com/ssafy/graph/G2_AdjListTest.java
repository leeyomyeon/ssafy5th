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
public class G2_AdjListTest {
    static int N;
    static Node[] adjList;

    static class Node {
        int vertex;
        Node next;
        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
        public Node(int vertex) {
            this.vertex = vertex;
        }
        @Override
        public String toString() {
            return "Node[" +
                    "vertex=" + vertex +
                    ", next=" + next +
                    ']';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        adjList = new Node[N];

        StringTokenizer st;

        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
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

            for(Node temp = adjList[current]; temp != null; temp = temp.next) {
                if(!visited[temp.vertex]) {
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
    }

    static boolean[] visited;
    private static void dfs(int current) {
        visited[current] = true;

        System.out.println((char)(current + 45));

        for(Node temp = adjList[current]; temp != null; temp = temp.next) {
            if(!visited[temp.vertex]) {
                dfs(temp.vertex);
            }
        }
    }
}
