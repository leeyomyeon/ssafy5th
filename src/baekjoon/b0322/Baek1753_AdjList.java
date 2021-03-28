package baekjoon.b0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1753_AdjList {
    static int V;
    static int E;
    static int start;
    static List<Node>[] list;
    static int[] d;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine()) - 1;
        list = new ArrayList[V];
        visited = new boolean[V];
        d = new int[V];

        for(int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v , w));
        }

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        for(int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j = 0; j < V; j++) {
                if(!visited[j] && d[j] < min) {
                    minIdx = j;
                    min = d[j];
                }
            }

            if(minIdx == -1) {
                break;
            }
            visited[minIdx] = true;

            for(int j = 0; j < list[minIdx].size(); j++) {
                if(!visited[list[minIdx].get(j).vertex] && list[minIdx].get(j).weight != 0 && list[minIdx].get(j).weight + d[minIdx] < d[list[minIdx].get(j).vertex]) {
                    d[list[minIdx].get(j).vertex] = list[minIdx].get(j).weight + d[minIdx];
                }
            }
        }

        for(int j = 0; j < V; j++) {
            if(d[j] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(d[j]);
            }
        }
    }
}
