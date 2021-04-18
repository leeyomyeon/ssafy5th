package swea.d0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4014 {
    static int N;   // 땅의 크기
    static int X;   // 경시로 높이
    static int[][] arr;
    static int max;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            max = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] > max) {
                        max = arr[i][j];        // 최대값인 곳은 설치 안해도 됨
                    }
                }
            }

            count = 0;
            for(int i = 0; i < N; i++) {
                executeHorizontal(i);  // 세로 탐색
                executeVertical(i);  // 가로 탐색
            }
        }
    }
    // 방향(상하01 / 좌우23)
    static void executeHorizontal(int k) {  // 가로 탐색
        // 한줄복사
        int[] tmpArr = new int[N];
        System.arraycopy(arr[k], 0, tmpArr, 0, N);
        boolean[] visited = new boolean[N];

        for(int i = 0; i <= N - X; i++) {
            for(int j = i + X; j <= N - X; j++) {
                if(tmpArr[i] == max || tmpArr[j] == max) {
                    continue;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(arr[k][i] == max) {
                continue;
            }
            int nk = k;

            // 범위 벗어나거나 경사로의 시작칸과 끝칸의 크기가 다르거나 경사로가 설치된경우
            if(nk < 0 || nk >= N || (arr[nk][i] != arr[k][i]) || visited[i]) {
                continue;
            }
        }
    }

    static void executeVertical(int k) {    // 세로 탐색
        // 한줄복사
        int[] tmpArr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            tmpArr[i] = arr[i][k];
        }

        for(int i = 0; i < N; i++) {
            if(arr[i][k] == max) {
                continue;
            }
            int nk = k;
            if(nk < 0 || nk >= N || (arr[i][nk] != arr[i][k]) || visited[i]) {    // 범위 벗어나거나 경사로의 시작칸과 끝칸의 크기가 다르면
                continue;
            }

        }
    }
}

/*
1. 가로 분할(행 고정) 활주로 건설 가능 체크 및 카운팅
2. 세로 분할(열 고정) 활주로 건설 가능 체크 및 카운팅
3. 높이 비교
이전 높이 == 현재 높이  연속 동일 높이 카운팅 관리
이전 높이 + 1 == 현재높이 -> 오르막    연속 동일 높이 카운팅 이용 경사로 사용 체크
이전 높이 - 1 == 현재 높이 -> 내리막   현위치 앞으로 쭉 연속 동일 높이 계산 경사로 사용 체크
나머지 상황 -> 활주로 건설 불가
 */