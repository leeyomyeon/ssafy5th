import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역 {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int maxWater = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxWater) {
                    maxWater = arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int k = 1; k <= maxWater; k++) {
            count = 0;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] > k && !visited[i][j]) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            if(max < count) {
                max = count;
            }
        }

        System.out.println(max);
    }

    public static int[] dp = {1, -1, 0, 0};
    public static int[] dq = {0, 0, 1, -1};

    public static void dfs(int p, int q, int r) {
        visited[p][q] = true;
        for(int i = 0; i < 4; i++) {
            int np = p + dp[i];
            int nq = q + dq[i];
            if(np >= 0 && nq >= 0 && np < n && nq < n && arr[np][nq] > r && !visited[np][nq]) {
                visited[np][nq] = true;
                dfs(np, nq, r);
            }
        }
    }
}
