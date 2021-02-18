package swea.d0210;

import java.util.Scanner;
import java.util.Stack;

public class 퍼펙트셔플 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            String arr[] = new String[n];
            Stack<String> stack = new Stack<>();

            for(int i = 0; i < n; i++) {
                arr[i] = scanner.next();
            }

            int jump;
            if(n % 2 == 1) {
                jump = n / 2 + 1;
            } else {
                jump = n / 2;
            }

            int i = 0;
            for(; i < n / 2; i++) {
                stack.push(arr[i]);
                stack.push(arr[i + jump]);
            }

            if(n % 2 == 1) {
                stack.push(arr[i]);
            }

            System.out.print("#" + tc + " ");
            for(int j = 0; j < stack.size(); j++) {
                System.out.print(stack.elementAt(j) + " ");
            }
            System.out.println();
        }
    }
}
