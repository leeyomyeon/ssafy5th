import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기 {
    static int n;
    public static int[][] arr;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        dfs(0, 1, 0);

        System.out.println(count);
    }

    static int[] dp = {0, 1, 1};
    static int[] dq = {1, 1, 0};

    public static void dfs(int p, int q, int d) {
        if(p == n-1 && q == n-1) {
            count++;
            return;
        }

        int i = 0, j = 0;
        if(d == 0) {
            i = 0;
            j = 1;
        } else if (d == 1) {
            i = 0;
            j = 2;
        } else if (d == 2) {
            i = 1;
            j = 2;
        }

        for(; i <= j; i++) {
            int np = p + dp[i];
            int nq = q + dq[i];

            if(np >= n || nq >= n) {
                continue;
            }
            if(arr[np][nq] == 1) {
                continue;
            }
            if(i == 1 && ((np -1 >= 0 && arr[np-1][nq] == 1) || (nq -1 >= 0 && arr[np][nq-1] == 1))) {
                continue;
            }

            dfs(np, nq, i);
        }
    }
}
