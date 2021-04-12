package swea.d0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5644_answer {
    static int M, bcCnt;
    static int[] pathA, pathB, playerA, playerB;
    static int[][] bc;

    static int dx[] = {0, 0, 1, 0, -1};
    static int dy[] = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        playerA = new int[2];
        playerB = new int[2];

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            bcCnt = Integer.parseInt(st.nextToken());

            playerA[0] = playerA[1] = 1;
            playerB[0] = playerB[1] = 10;

            pathA = new int[M + 1];
            pathB = new int[M + 1];
            bc = new int[bcCnt][4];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++) {
                pathA[i] = Integer.parseInt(st1.nextToken());
                pathB[i] = Integer.parseInt(st2.nextToken());
            }

            for(int i = 0; i < bcCnt; i++) {
                st = new StringTokenizer(br.readLine());
                bc[i][0] = Integer.parseInt(st.nextToken());    // x
                bc[i][1] = Integer.parseInt(st.nextToken());    // y
                bc[i][2] = Integer.parseInt(st.nextToken());    // distance
                bc[i][3] = Integer.parseInt(st.nextToken());    // performance
            }

            System.out.println("#" + tc + " " + move());
        }
    }

    public static int move() {
        int totalSum = 0;
        for(int i = 0; i <= M; i++) {
            playerA[0] += dx[pathA[i]];
            playerA[1] += dy[pathA[i]];
            playerB[0] += dx[pathB[i]];
            playerB[1] += dy[pathB[i]];

            totalSum += getMaxCharge();
        }

        return totalSum;
    }

    public static int getMaxCharge() {
        int max = 0;
        for(int a = 0; a < bcCnt; a++) {
            for(int b = 0; b < bcCnt; b++) {
                int sum = 0;

                int amountA = check(a, playerA[0], playerA[1]);
                int amountB = check(b, playerB[0], playerB[1]);

                if(a != b) {
                    sum += amountA + amountB;
                } else {
                    sum = Math.max(amountA, amountB);
                }

                if(max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    private static int check(int a, int x, int y) {
        return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
    }
}
