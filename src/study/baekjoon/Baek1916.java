package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1916 {
    static int N;
    static int M;
    static List<Node>[] list;
    static int[] dist;
    static int start;
    static int end;
    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 노드 수

        list = new List[N + 1];
        dist = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        M = Integer.parseInt(br.readLine());    // 간선 수

        // 시작위치
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dist[start] = 0;
        end = Integer.parseInt(st.nextToken());
        System.out.println(bfs(start));
    }

    public static int bfs(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(visited[current.vertex]) {      // 이미 방문했으면 건너뜀
                continue;
            }
            if(dist[current.vertex] < current.weight) { // 지나가는 경로에서 이미 값이 넘어가면 건너뜀
                continue;
            }
            visited[current.vertex] = true;

            for(Node temp : list[current.vertex]) {
                if(dist[temp.vertex] > dist[current.vertex] + temp.weight) {
                    dist[temp.vertex] = dist[current.vertex] + temp.weight;
                    queue.add(new Node(temp.vertex, dist[temp.vertex]));
                }
            }
        }

        return dist[end];
    }

}
