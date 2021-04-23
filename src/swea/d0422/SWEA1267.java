package swea.d0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1267 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] indegree = new int[V];
            int[][] adj = new int[V][V];

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                adj[from][to] = 1;
                indegree[to] += 1;
            }

            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i <V; i++) {
                if(indegree[i] == 0) {
                    queue.add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()) {
                int node = queue.poll();
                sb.append(node).append(" ");
                for(int i = 0; i < V; i++) {
                    if(adj[node][i] == 1) {
                        indegree[i] -= 1;
                        if(indegree[i] == 0) {
                            queue.add(i);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + sb);
        }
    }
}
