import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class 식당테스트 {
    public static char[][] arr;
    public static int r;
    public static int c;

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("/Users/iyomyeon/Downloads/input.txt");
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for(int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        count = 0;

        for(int i = 0; i < r; i++) {
            pipeLine(i, 0);
        }

        System.out.println(count);
    }
    public static int[] dp = {-1, 0, 1};
    public static int count;

    public static void pipeLine(int p, int q) {
        if(q == c - 1) {
            count++;
            return;
        }
        for(int i = 0; i < dp.length; i++) {
            int np = p;
            int nq = q;
            np += dp[i];
            nq += 1;
            if(np >= 0 && np < r && arr[np][nq] == '.') {
                arr[np][nq] = 'P';
                pipeLine(np, nq);
                if(nq == c - 1) {
                    break;
                }
            }
        }
    }
}