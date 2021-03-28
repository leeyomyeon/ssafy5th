package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int answer = 0;
        for(int i = 1; i < sb.length(); i++) {
            if(sb.charAt(0) != sb.charAt(i)) {
                answer++;
                if(sb.charAt(i - 1) == sb.charAt(i)) {
                    answer--;
                }
            }
        }
        System.out.println(answer);
    }
}
