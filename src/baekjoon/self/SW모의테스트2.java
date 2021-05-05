package baekjoon.self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1
3
1 2 0
1 2 2
2 2 3
50 100 0
800 110 500
150 200 150
15 300 0
10 200 1500
25 500 100
 */
public class SW모의테스트2 { // 삼국지
    public static int N;
    public static int[][][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[3][N][N];
            //지역, 병력, 보충 순서
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < N; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int k = 0; k < N; k++) {
                        arr[i][j][k] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            게임을시작하지();
        }

    }

    public static void 게임을시작하지() {
        int turn = 1;
        while(true) {   // 턴
            if(게임이끝났나요()) {
                break;
            }
            turn = (turn % 3) + 1;
            공격(turn);
            지원(turn);
            보충();
            turn++;
        }
    }
    public static void 공격(int k) {

    }
    public static void 지원(int k) {

    }
    public static void 보충() {

    }
    public static boolean 게임이끝났나요() {
        return true;
    }
}
