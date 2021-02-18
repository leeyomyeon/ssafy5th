package swea.d0210;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = scanner.nextInt();

            String str = scanner.next();
            char[] c = str.toCharArray();

            int result = 0;

            Stack<Character> stack = new Stack<>();

            int k = 0;
            // '()', '[]', '{}', '<>'
            for(int i = 0; i < c.length; i++) {
                stack.push(c[i]);
                k = stack.size() - 1;
                if (k > 0) {
                    if(     (stack.elementAt(k - 1) == '(' && stack.elementAt(k) == ')') ||
                            (stack.elementAt(k - 1) == '{' && stack.elementAt(k) == '}') ||
                            (stack.elementAt(k - 1) == '[' && stack.elementAt(k) == ']') ||
                            (stack.elementAt(k - 1) == '<' && stack.elementAt(k) == '>') ){
                        stack.pop();
                        stack.pop();
                    }
                }
            }

            if(stack.empty()) {
                result = 1;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
