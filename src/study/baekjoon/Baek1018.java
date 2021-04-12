package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1018 {
    static int N;
    static int M;
    static char[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            arr[i] = sb.toString().toCharArray();
        }
        // 8 by 8로 쪼갬
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                // 시작 위치 지정
                int countA = 0;

                // 현재 칸과 같을 경우
                for(int k = i; k < i + 8; k++) {
                    for(int l = j; l < j + 8; l++) {
                        if((k - i) % 2 == 0 && (l - j) % 2 == 0 && arr[k][l] != arr[i][j]) {
                            countA++;
                        }
                        else if((k - i) % 2 == 1 && (l - j) % 2 == 1 && arr[k][l] != arr[i][j]) {
                            countA++;
                        }
                        else if((k - i) % 2 == 0 && (l - j) % 2 == 1 && arr[k][l] == arr[i][j]) {
                            countA++;
                        }
                        else if((k - i) % 2 == 1 && (l - j) % 2 == 0 && arr[k][l] == arr[i][j]) {
                            countA++;
                        }
                    }
                }

                int countB = 0;

                // 현재 칸과 다를 경우
                for(int k = i; k < i + 8; k++) {
                    for(int l = j; l < j + 8; l++) {
                        if((k - i) % 2 == 0 && (l - j) % 2 == 0 && arr[k][l] == arr[i][j]) {
                            countB++;
                        }
                        else if((k - i) % 2 == 1 && (l - j) % 2 == 1 && arr[k][l] == arr[i][j]) {
                            countB++;
                        }
                        else if((k - i) % 2 == 0 && (l - j) % 2 == 1 && arr[k][l] != arr[i][j]) {
                            countB++;
                        }
                        else if((k - i) % 2 == 1 && (l - j) % 2 == 0 && arr[k][l] != arr[i][j]) {
                            countB++;
                        }
                    }
                }

                min = Math.min(min, Math.min(countA, countB));
            }
        }

        System.out.println(min);
    }
}
/*
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
 */