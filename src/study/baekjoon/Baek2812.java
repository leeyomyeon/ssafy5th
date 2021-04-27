package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
/*
7 5
8818913
 */
public class Baek2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        Deque<Character> deque = new ArrayDeque<>();

        String num = br.readLine();
        char[] arr = num.toCharArray();

        for (char c : arr) {
            while (K > 0 && !deque.isEmpty() && c > deque.getLast()) {
                deque.removeLast();
                K--;
            }
            deque.addLast(c);
        }

        StringBuilder sb = new StringBuilder();
        while(deque.size() > K) {
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);
    }
}
