package swea.d0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2115 {
    static int N, M, C;
    static int[][] arr;
    static int maxSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());   // 벌통의 개수
            C = Integer.parseInt(st.nextToken());   // 꿀의 최대 채취 양

            arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " "+honey());
        }
    }

    public static int honey() {
        int profit = 0, sumA, sumB;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= N - M; j++) {
                maxSum = 0;
                subSet(i, j, 0, 0, 0);
                sumA = maxSum;

                maxSum = 0;
                sumB = 0;
                for(int j2 = j + M; j2 <= N - M; j2++) {
                    subSet(i, j2, 0 ,0 ,0);
                    if(sumB < maxSum) {
                        sumB = maxSum;
                    }
                }

                for(int i2 = i + 1; i2 < N; i2++) {
                    for(int j2 = 0; j2 <= N - M; j2++) {
                        subSet(i2, j2, 0, 0, 0);
                        if(sumB < maxSum) {
                            sumB = maxSum;
                        }
                    }
                }

                profit = Math.max(profit, sumA + sumB);
            }
        }


        return profit;
    }
    public static void subSet(int i, int j, int cnt, int sum, int powerSum) {
        if(sum > C) {
            return;
        }
        if(cnt == M) {
            if(maxSum < powerSum) {
                maxSum = powerSum;
            }
        }
        // 선택
        subSet(i, j + 1, cnt + 1, sum + arr[i][j], powerSum + (arr[i][j]*arr[i][j]));
        // 비선택
        subSet(i, j + 1, cnt + 1, sum, powerSum);
    }
}
