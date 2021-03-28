package swea.d0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1263 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 0) {
                        arr[i][j] = N;
                    }
                }
            }

            for(int k = 0; k < N; k++) {
                for(int i = 0; i < N; i++) {
                    if(i == k) {
                        continue;
                    }
                    for(int j = 0; j < N; j++) {
                        if(i == j || j == k) {
                            continue;
                        }
                        if(arr[i][j] > arr[i][k] + arr[k][j]) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < N; j++) {
                    if(i == j) {
                        continue;
                    }
                    sum += arr[i][j];
                }
                if(min > sum) {
                    min = sum;
                }
            }

            System.out.println("#" + tc + " " + min);
        }
    }
}
