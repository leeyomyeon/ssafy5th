package study.swexpertacademy;

import java.util.Scanner;

public class Prob1986 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int sum = 0;

            for(int i = 1; i <= n; i++) {
                if(i % 2 == 0) {
                    sum -= i;
                } else {
                    sum += i;
                }
            }

            System.out.println("#" + tc + " " + sum);
        }
    }
}
