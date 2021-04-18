import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek7576 { // 토마토
    static int N;
    static int M;
    static int[][] arr;
    public static class Tomato {
        int r;
        int c;

        public Tomato(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        Queue<Tomato> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }
        int day = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Tomato tomato = queue.poll();
                for(int d = 0; d < 4; d++) {
                    int nr = tomato.r + dr[d];
                    int nc = tomato.c + dc[d];
                    if(nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] == 0) {
                        arr[nr][nc] = 1;
                        queue.offer(new Tomato(nr, nc));
                    }
                }
            }
            day++;
        }

        Loop1:
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    day = -1;
                    break Loop1;
                }
            }
        }
        System.out.println(day);
    }
}
