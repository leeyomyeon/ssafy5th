package swea.d0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA2112 {
    public static int N, M, K;
    public static int[][] arr;
    public static boolean[] selected;
    public static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            selected = new boolean[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 처음 검사 한번 해보고
            if(통과기준(arr)) {
                System.out.println("#" + tc + " 0");
                continue;
            }

            // 통과되지 않으면 경우의수 만듦
            min = Integer.MAX_VALUE;
            subset(0);
            System.out.println("#" + tc + " " + min);
        }
    }
    public static void subset(int cnt) {
        if(cnt == N) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                if(selected[i]) {
                    list.add(i);
                }
            }
            if(list.size() == 0) {
                return;
            }
            boolean[] aorb = new boolean[list.size()];
            permutation(0, list, aorb);
            return;
        }
        selected[cnt] = true;
        subset(cnt + 1);
        selected[cnt] = false;
        subset(cnt + 1);
    }

    public static void permutation(int cnt, ArrayList<Integer> list, boolean[] aorb) {
        if(cnt == list.size()) {
            int[][] tmpArr = copyArr();
            for(int i = 0; i < list.size(); i++) {
                int k = list.get(i);    // 선택된 행 번호
                if(aorb[i]) {   // 해당 행을 1로 바꾼다
                    for(int j = 0; j < M; j++) {
                        tmpArr[k][j] = 0;
                    }
                } else {   // 해당 열을 0으로 바꾼다.
                    for(int j = 0; j < M; j++) {
                        tmpArr[k][j] = 1;
                    }
                }
            }
            if(통과기준(tmpArr)) {
                min = Math.min(min, list.size());
            }
            return;
        }
        aorb[cnt] = true;
        permutation(cnt + 1, list, aorb);
        aorb[cnt] = false;
        permutation(cnt + 1, list, aorb);
    }

    public static int[][] copyArr() {
        int[][] tmpArr = new int[N][M];
        for(int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(arr[i], 0, tmpArr[i], 0, M);
        }
        return tmpArr;
    }

    public static boolean 통과기준(int[][] arr) {
        int t = 0;
        for(int i = 0; i < M; i++) {
            int cnt = 1;
            for(int j = 0; j <= N - K; j++) {
                cnt = 1;
                for(int k = j; k < j + K - 1; k++) {
                    if(arr[k][i] == arr[k + 1][i]) {
                        cnt++;
                    } else {
                        cnt = 1;
                    }
                }
                if(cnt >= K) {
                    t++;
                    break;
                }
            }
            if(cnt < K) {
                return false;
            }
        }
        return t == M;
    }
}
