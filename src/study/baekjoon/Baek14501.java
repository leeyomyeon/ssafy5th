package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14501 {
    static int n;
    static int[][] advice;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        advice = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            advice[i][0] = Integer.parseInt(st.nextToken());
            advice[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        resign(0, 0);
        System.out.println(answer);
    }

    public static void resign(int index, int sum) {
        if(index > n) {
            return;
        }
        if(sum > answer) {
            answer = sum;
        }
        for(int i = index; i < n; i++) {
            resign(i + advice[i][0], sum + advice[i][1]);
        }
    }
}
