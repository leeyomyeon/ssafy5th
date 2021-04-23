package swea.d0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2623 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N];
        int[][] adjList = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = 0;
            for(int j = 0; j < num; j++) {
                if(k == 0) {
                    k = Integer.parseInt(st.nextToken()) - 1;
                } else {
                    int to = Integer.parseInt(st.nextToken()) - 1;
                    if(adjList[k][to] == 1) {
                        indegree[to] -= 1;
                    }
                    adjList[k][to] = 1;
                    indegree[to] += 1;
                    k = to;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i < N; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            list.add(current + 1);

            for(int i = 0; i < N; i++) {
                if(adjList[current][i] == 1) {
                    indegree[i] -= 1;
                    if(indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        if(list.size() != N) {
            System.out.println(0);
        } else {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
/*
6 3
3 1 4 3
4 6 2 5 4
2 2 3

6 3
3 1 4 3
4 6 2 5 4
2 3 2

2 2
2 1 2
2 1 2
 */