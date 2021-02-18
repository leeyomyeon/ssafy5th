package swea.d0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int tt = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < 8; i++) {
                queue.offer(scanner.nextInt());
            }
            
            while(true) {
                boolean k = false;
                for(int cnt = 1; cnt <= 5; cnt++) {
                    int a = queue.poll();
                    a -= cnt;
                    if (a <= 0) {
                        a = 0;
                        k = true;
                        queue.offer(a);
                        break;
                    } else {
                        queue.offer(a);
                    }
                }
                if(k) {
                    break;
                }
            }

            System.out.print("#" + tc + " ");
            for(int i = 0; i < 8; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
