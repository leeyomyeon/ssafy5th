package baekjoon.b0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16236 {
    public static int N;
    public static int[][] arr;
    public static int cnt, R, C, grade = 2;
    public static boolean[][] visited;
    public static class Fish implements Comparable<Fish>{
        int r;
        int c;
        int distance;
        public Fish(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        public int compareTo(Fish o) {
            if(distance == o.distance) {
                if(o.r == r) {
                    return c - o.c;
                } else {
                    return r - o.r;
                }
            }
            return distance - o.distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    R = i;
                    C = j;
                    arr[i][j] = 0;
                }
            }
        }
        int answer = 0;
        cnt = 0;
        while(true) {
            PriorityQueue<Fish> pq = new PriorityQueue<>(); // 먹이 저장할 우선순위 큐
            Queue<Fish> queue = new LinkedList<>(); // 상어 위치 저장할 큐

            queue.add(new Fish(R, C, 0));
            visited = new boolean[N][N];
            visited[R][C] = true;
            int distance = Integer.MAX_VALUE;
            while(!queue.isEmpty()) {   // 먹이 찾으러감
                Fish current = queue.poll();    // 상어
                if(arr[current.r][current.c] < grade && arr[current.r][current.c] != 0) {
                    // 먹을수 있는 먹이면 먹이 큐에 넣음
                    distance = current.distance;
                    pq.add(current);    // 상어가 위치한 곳 = 먹을수 있는 현재 위치의 먹이
                }
                if(distance < current.distance) {
                    break;
                }
                for(int i = 0; i < 4; i++) {
                    int nr = current.r + dr[i];
                    int nc = current.c + dc[i];
                    // 상어 등급이 맵이 등급보다 낮거나 맵이 0인경우 가능
                    if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && (grade >= arr[nr][nc] || arr[nr][nc] == 0)) {
                        visited[nr][nc] = true;
                        queue.add(new Fish(nr, nc, current.distance + 1));
                    }
                }
            }   // 먹을수 있는 먹이 다 찾으면
            //먹이를 먹자
            Fish fish = pq.poll();
            if(fish == null) {
                break;
            }
            arr[fish.r][fish.c] = 0;
            R = fish.r;
            C = fish.c;
            cnt++;
            if(cnt == grade) {
                grade++;
                cnt = 0;
            }
            answer += fish.distance;
        }
        System.out.println(answer);
    }
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
}
