package baekjoon.b0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1753_AdjArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[V];
        int[][] arr = new int[V][V];
        int[] d = new int[V];

        int start = Integer.parseInt(br.readLine()) - 1;

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            arr[u][v] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        for(int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;

            for(int j = 0; j < V; j++) {
                if(!visited[j] && d[j] < min) {
                    minIdx = j;
                    min = d[j];
                }
            }

            visited[minIdx] = true;

            for(int j = 0; j < V; j++) {
                if(!visited[j] && arr[minIdx][j] != 0 && arr[minIdx][j] + d[minIdx] < d[j]) {
                    d[j] = arr[minIdx][j] + d[minIdx];
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
