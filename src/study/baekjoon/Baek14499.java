package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14499 {
    public static int[][] arr;
    public static int[] dice;
    public static int n;
    public static int m;
    public static int r;
    public static int c;
    public static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dice = new int[6];
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nR = r + dr[dir];
            int nC = c + dc[dir];
            if (nR < n && nR >= 0 && nC < m && nC >= 0) { // 경계선을 넘어가지 않는다면
                move(dir);                      // 주사위 굴리고
                if(arr[nR][nC] == 0) {          // 맵이 0일때
                    arr[nR][nC] = dice[5];      // 주사위 바닥에 값을 복사
                } else {                        // 맵이 0이 아니면
                    dice[5] = arr[nR][nC];      // 맵 값을 주사위에 복사, 5 = 바닥면
                    arr[nR][nC] = 0;            // 맵을 0으로 만듬
                }

                r = nR;                         // 주사위 위치 이동
                c = nC;
                System.out.println(dice[0]);        // 0 = 현재 주사위의 천장면
            }
        }
    }

    public static int[] dr = {0, 0, 0, -1, 1};
    public static int[] dc = {0, 1, -1, 0, 0};
    public static void move(int d) {    // 주사위의 값이 이동함.
        int tmp;
        if(d == 1) {            // 동쪽
            tmp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = tmp;
        } else if (d == 2) {    // 서쪽
            tmp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = tmp;
        } else if (d == 3) {    // 북쪽
            tmp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = tmp;
        } else {                // 남쪽
            tmp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = tmp;
        }
    }
}
