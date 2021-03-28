package baekjoon.b0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon17472 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int islandCount;
    public static Queue<Island> queue;
    public static PriorityQueue<Node> pq;

    public static class Island {
        int p;
        int q;
        int islandNum;
        public Island(int p, int q, int islandNum) {
            this.p = p;
            this.q = q;
            this.islandNum = islandNum;
        }
    }
    public static class Node {
        int from;
        int to;
        int vertex;
        public Node(int from, int to, int vertex) {
            this.from = from;
            this.to = to;
            this.vertex = vertex;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }

        queue = new LinkedList<>();
        islandCount = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == -1) {
                    islandCount++;
                    queue.add(new Island(i, j, islandCount));
                    map[i][j] = islandCount;
                    findIsland(i, j);
                }
            }
        }
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.vertex));

        while (!queue.isEmpty()) {
            Island island = queue.poll();
            makeBridge(island);        // 각 섬에서 도착 가능한 섬까지 다리 연결
        }

        int[][] adjMatrix = new int[islandCount + 1][islandCount + 1];
        int[] minEdge = new int[islandCount + 1];
        boolean[] visited = new boolean[islandCount + 1];
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int from = node.from;
            int to = node.to;
            int vertex = node.vertex;
            if(adjMatrix[from][to] != 0) {
                adjMatrix[from][to] = Math.min(vertex, adjMatrix[from][to]);
            } else {
                adjMatrix[from][to] = vertex;
            }
        }

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        int result = 0;
        minEdge[1] = 0;

        for(int c = 1; c <= islandCount; c++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for(int i = 1; i <= islandCount; i++) {
                if(!visited[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            if(minVertex == -1) {
                result = -1;
                break;
            }

            result += min;
            visited[minVertex] = true;

            for(int i = 1; i <= islandCount; i++) {
                if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }

        System.out.println(result);
    }

    public static int[] dp = {-1, 1, 0, 0};
    public static int[] dq = {0, 0, -1, 1};
    public static void makeBridge(Island island) {
        for(int i = 0; i < 4; i++) {
            int np = island.p;
            int nq = island.q;
            int length = 0;
            while(true) {
                np += dp[i];
                nq += dq[i];
                if(np < 0 || nq < 0 || np >= N || nq >= M) {
                    break;  // 섬에 못 닿았을시
                }
                if(map[np][nq] == island.islandNum && map[np][nq] != 0) {
                    break;  // 자기 섬
                }
                if(map[np][nq] != island.islandNum && map[np][nq] != 0) {
                    if(length >= 2) {
                        pq.add(new Node(island.islandNum, map[np][nq], length));
                    }
                    break;
                }
                length++;
            }
        }
    }

    public static void findIsland(int p, int q) {   // 섬의 개수 파악하여 번호 붙이기
        for(int i = 0; i < 4; i++) {
            int np = p + dp[i];
            int nq = q + dq[i];
            if(np < 0 || nq < 0 || np >= N || nq >= M || map[np][nq] >= 0) {
                continue;
            }
            queue.add(new Island(np, nq, islandCount));
            map[np][nq] = islandCount;
            findIsland(np, nq);
        }
    }
}
