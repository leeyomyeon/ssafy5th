package swea.d0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5607 { // [Professional] 조합
    static int MOD = 1234567891;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long[] factorial = new long[N + 1];
            factorial[0] = 1;

            for(int i = 1; i <= N; i++) {
                factorial[i] = (factorial[i - 1] * i) % MOD;
            }

            long p = (factorial[N - R] * factorial[R]) % MOD; // (n - r)! * r!

            long d = dnq(p, MOD - 2);
            long result = (factorial[N] * d) % MOD;
            // p ^ (mod - 2) 구하기

            System.out.println("#" + tc + " " + result);
        }
    }
    public static long dnq(long p, int n) {  // 분할정복
        if(n == 0) {
            return 1;
        }

        long tmp = dnq(p, n / 2);
        if (n % 2 == 0) { // 짝수면
            return ((tmp % MOD) * (tmp % MOD)) % MOD;
        } else { // 홀수면
            return (((tmp * p) % MOD) * (tmp % MOD)) % MOD;
        }
    }
}
