package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = 1;
            arr[to][from] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int cnt = 0;
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 1; i <= N; i++) {
                if(arr[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
/*
4
3
1 2
2 4
3 4
 */
