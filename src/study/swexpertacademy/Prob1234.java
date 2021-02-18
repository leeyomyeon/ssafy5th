package study.swexpertacademy;

import java.util.Scanner;
import java.util.Stack;

public class Prob1234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = scanner.nextInt();
            String[] str = scanner.next().split("");

            Stack<String> stack = new Stack<>();
            for(int i = 0; i < n; i++) {
                if(stack.size() == 0) {
                    stack.push(str[i]);
                    continue;
                }
                if(stack.peek().equals(str[i])) {
                    stack.pop();
                } else {
                    stack.push(str[i]);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(stack.size() > 0) {
                sb.append(stack.pop());
            }
            sb.reverse();
            System.out.println("#" + tc + " " + sb.toString());
        }
    }
}
