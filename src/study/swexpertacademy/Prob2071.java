package study.swexpertacademy;

import java.util.Scanner;

public class Prob2071 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();


        for(int tc = 1; tc <= T; tc++) {
            double sum = 0;

            for(int i = 0; i < 10; i++) {
                int a = scanner.nextInt();
                sum += a;
            }

            System.out.println("#"+tc+" "+Math.round(sum / 10));
        }

    }
}
