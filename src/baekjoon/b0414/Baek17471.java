package baekjoon.b0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17471 {
    public static int N;
    public static int[][] adjMatrix;    // 연결 정보
    public static int[] population;     // 인구 수(및 번호)
    public static boolean[] visited;   //
    public static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adjMatrix = new int[N + 1][N + 1];
        population = new int[N + 1];
        visited = new boolean[N + 1];

        // 인구 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                adjMatrix[i][k] = 1;
            }
        }

        // 편 나누기
        min = Integer.MAX_VALUE;
        subset(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void subset(int cnt) {
        if (cnt == N + 1) {
            isConnected();
            return;
        }

        visited[cnt] = true;
        subset(cnt + 1);

        visited[cnt] = false;
        subset(cnt + 1);
    }

    public static void isConnected() {
        Queue<Integer> select = new LinkedList<>();
        Queue<Integer> notSelect = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(visited[i]) {
                select.add(i);
                break;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                notSelect.add(i);
                break;
            }
        }

        if(select.size() == 0 || notSelect.size() == 0) {   // 구역이 하나도 없을 시
            return;
        }

        // true인 구역이 서로 연결되어 있는지?
        boolean[] check = new boolean[N + 1];
        while (!select.isEmpty()) {
            int k = select.poll();
            check[k] = true;
            for(int i = 1; i <= N; i++) {
                if(visited[i] && adjMatrix[k][i] == 1 && !check[i]) {
                    select.add(i);
                }
            }
        }
        for(int i = 1; i <= N; i++) {   // 구역이 전부 연결되어 있으면 통과될 것
            if(check[i] != visited[i]) {
                return;
            }
        }

        // false인 구역이 서로 연결되어 있는지?
        check = new boolean[N + 1];
        while (!notSelect.isEmpty()) {
            int k = notSelect.poll();
            check[k] = true;
            for(int i = 1; i <= N; i++) {
                if(!visited[i] && adjMatrix[k][i] == 1 && !check[i]) {
                    notSelect.add(i);
                }
            }
        }
        for(int i = 1; i <= N; i++) {   // 구역이 전부 연결되어 있으면 통과될 것
            if(check[i] == visited[i]) {
                return;
            }
        }

        // 전부 통과하면 여기서 구역끼리 계산
        int groupA = 0;
        int groupB = 0;
        for(int i = 1; i <= N; i++) {
            if(visited[i]) {
                groupA += population[i];
            } else if(!visited[i]) {
                groupB += population[i];
            }
        }

        if(min > Math.abs(groupA - groupB)) {
            min = Math.abs(groupA - groupB);
        }
    }

}
