package baekjoon.b0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준카드2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int result = 0;
        while(true) {
            if(queue.size() == 1) {
                result = queue.peek();
                break;
            }
            queue.remove();
            int a = queue.poll();
            queue.offer(a);
        }

        System.out.println(result);
    }
}
