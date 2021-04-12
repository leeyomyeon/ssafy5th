package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek3085 {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            arr[i] = sb.toString().toCharArray();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 가로
                char[][] tmp = copyArr();
                char tmpChar;
                int horizontal = 0;
                if(i < N - 1) {
                    tmpChar = tmp[i][j];
                    tmp[i][j] = tmp[i + 1][j];
                    tmp[i + 1][j] = tmpChar;
                    horizontal = validate(tmp);
                }

                // 세로
                int vertical = 0;
                if(j < N - 1) {
                    tmp = copyArr();
                    tmpChar = tmp[i][j];
                    tmp[i][j] = tmp[i][j + 1];
                    tmp[i][j + 1] = tmpChar;
                    vertical = validate(tmp);
                }

                max = Math.max(max, Math.max(horizontal, vertical));
            }
        }

        System.out.println(max);
    }

    public static int validate(char[][] tmp) {
        // 행 검사
        int horCount = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            char c = tmp[i][0];
            int cnt = 1;
            for(int j = 1; j < N; j++) {
                if(c == tmp[i][j]) {
                    cnt++;
                } else {
                    c = tmp[i][j];
                    horCount = Math.max(cnt, horCount);
                    cnt = 1;
                }
                horCount = Math.max(cnt, horCount);
            }
        }

        // 열 검사
        int verCount = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            char c = tmp[0][i];
            int cnt = 1;
            for(int j = 1; j < N; j++) {
                if(c == tmp[j][i]) {
                    cnt++;
                } else {
                    c = tmp[j][i];
                    verCount = Math.max(cnt, verCount);
                    cnt = 1;
                }
                verCount = Math.max(cnt, verCount);
            }
        }

        return Math.max(horCount, verCount);
    }

    public static char[][] copyArr() {
        char[][] tmp = new char[N][N];
        for(int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, tmp[i], 0, N);
        }
        return tmp;
    }
}
