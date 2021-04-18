package baekjoon.b0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
빈 곳 : 언제나 이동할 수 있다. ('.‘로 표시됨)
벽 : 절대 이동할 수 없다. (‘#’)
열쇠 : 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. (a - f)
문 : 대응하는 열쇠가 있을 때만 이동할 수 있다. (A - F)
민식이의 현재 위치 : 빈 곳이고, 민식이가 현재 서 있는 곳이다. (숫자 0)
출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. (숫자 1)
 */
public class Baek1194 {
    static int N;
    static int M;
    static char[][] arr;
    static int min;
    static boolean[][][] visited;
    public static class Location {
        int r;
        int c;
        int key;
        int count;
        public Location() {}
        public Location(int r, int c, int key,int count) {
            this.r = r;
            this.c = c;
            this.key = key;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M][64];
        Location departure = new Location();    // 출발지

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '0') {
                    departure.r = i;
                    departure.c = j;
                    departure.count = 0;
                    arr[i][j] = '.';
                }
            }
        }

        min = Integer.MAX_VALUE;
        bfs(departure);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void bfs(Location location) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(location);
        visited[location.r][location.c][0] = true;

        while(!queue.isEmpty()) {
            Location current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc][current.key]) {
                    if(arr[nr][nc] == '#') {
                        continue;
                    }

                    if (arr[nr][nc] == '.') {
                        visited[nr][nc][current.key] = true;
                        queue.add(new Location(nr, nc, current.key ,current.count + 1));
                    }else if(arr[nr][nc] == '1') {
                        if(current.count + 1 < min) {
                            min = current.count + 1;
                        }
                    }else if(Character.isLowerCase(arr[nr][nc])) {
                        int nkey = current.key | (1 << (arr[nr][nc] - 'a'));
                        visited[nr][nc][nkey] = true;
                        queue.add(new Location(nr, nc, nkey, current.count + 1));
                    }else {
                        if((current.key & (1 << (arr[nr][nc] - 'A'))) >= 1) {
                            visited[nr][nc][current.key] = true;
                            queue.add(new Location(nr, nc, current.key, current.count + 1));
                        }
                    }
                    // 어떤 열쇠를 주웠는지?
                    // a b c d e f -> 000000
                    //여기에 열쇠 주운거 비트마스킹으로 current.key 변경
                    // 열쇠 주웠거나 문으로 갔거나
                }
            }
        }
    }
}