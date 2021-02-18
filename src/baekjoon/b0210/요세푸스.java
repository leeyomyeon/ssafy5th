package baekjoon.b0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int k = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 1;
        while(!queue.isEmpty()) {
            int t = queue.poll();
            if(count == k) {
                sb.append(t + ", ");
                count = 1;
            } else {
                queue.offer(t);
                count++;
            }
        }

        String result = sb.substring(0, sb.length() - 2);
        System.out.println(result + ">");
    }
}
