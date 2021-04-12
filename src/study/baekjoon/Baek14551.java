package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14551 {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 1;
        for(int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k == 0) {
                continue;
            }
            answer = (answer * k) % M;
        }

        System.out.println(answer % M);
    }
}
