package baekjoon.self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] list = new LinkedList[N];
        int[] indegree = new int[N];

        for(int i = 0; i < N; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            list[from].add(to);
            indegree[to] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print((current + 1) + " ");
            for(int next : list[current]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
/*
8 8
1 2
2 3
3 7
3 8
2 6
1 4
4 5
6 3
 */