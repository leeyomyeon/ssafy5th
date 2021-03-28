package swea.d0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] volume = new int[N + 1];
            int[] weight = new int[N + 1];
            int[][] arr = new int[N + 1][K + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                volume[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++) {
                for(int k = 0; k <= K; k++) {
                    if(k >= weight[i]) {
                        arr[i][k] = Math.max(arr[i - 1][k], arr[i - 1][k - weight[i]] + volume[i]);
                    } else {
                        arr[i][k] = arr[i - 1][k];
                    }
                }
            }

            System.out.println("#" + tc + " " + arr[N][K]);
        }
    }
}
