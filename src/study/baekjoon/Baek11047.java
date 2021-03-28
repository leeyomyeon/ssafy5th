package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if(num > K) {
                continue;
            }
            int a = K / num;
            K -= num * a;
            count += a;

            if(K == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
