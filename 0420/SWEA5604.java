import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5604 {
    static long start, end, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            answer = 0;

            // 규칙
            // 0 ~ 9 = 45 * 1 * 10^0
            // 0 ~ 99 = 45 * 2 * 10^1
            // 0 ~ 999 = 45 * 3 * 10^2
            // 0 ~ (10^n - 1) = 45 * n * 10^(n-1)


        }
    }
}
