import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_12_식당 {
    public static char[][] arr;
    public static int r;
    public static int c;
    public static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        pipeLine();

        System.out.println(count);
    }
    public static int[] dp = {-1, 0, 1};
    public static int count;

    public static void pipeLine() {
        count = 0;
        for(int i = 0; i < r; i++) {
            visited[i][0] = true;
            dfs(i, 0);
        }
    }
    public static boolean dfs(int p, int q) {
        if(q == c - 1) {
            count++;
            return true;
        }

        for(int i = 0; i < 3; i++) {
            int np = p;
            int nq = q;
            np += dp[i];
            nq += 1;
            if(np >= 0 && np< r && arr[np][nq] == '.' && !visited[np][nq]) {
                visited[np][nq] = true;
                if(dfs(np, nq)) {
                    return true;
                }
            }
        }

        return false;
    }
}
