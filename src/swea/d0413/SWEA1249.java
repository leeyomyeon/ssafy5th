package swea.d0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1249 { // 보급로 정리
    static int N, INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        //다익스트라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    map[i][j] = ch[j] - '0';
                }
            }

            System.out.println("#" + tc + " " + dijkstra(0, 0));
        }
    }

    public static int dijkstra(int startR, int startC) {
        // 종점 : N - 1, N - 1
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                minTime[i][j] = INF;
            }
        }

        minTime[startR][startC] = 0;

        int r = 0, c = 0, cost = 0, nr, nc;

        while (true) {
            cost = INF;
            // 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소 정점인 상태
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && cost > minTime[i][j]) {
                        cost = minTime[i][j];
                        r = i;
                        c = i;
                    }
                }
            }
            visited[r][c] = true;
            if(r == N - 1 && c == N - 1) {
                return cost;
            }
            // 선택된 정점 기준으로 방문하지 않은 나머지 정점들 자신과의 경유시의 비용과 기존 최소비용을 비교하여 업데이트
            // 현재 정점 기준 4방향의 인접정점 처리
            for(int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && minTime[nr][nc] > cost + map[nr][nc]) {
                    minTime[nr][nc] = cost + map[nr][nc];
                }
            }
        }
    }
}
