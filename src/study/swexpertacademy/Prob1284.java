package study.swexpertacademy;

import java.util.Scanner;

public class Prob1284 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int w = scanner.nextInt();

            int a = p * w;
            int b = 0;
            if(w < r) {
                b = q;
            } else {
                b += q;
                b += (w - r) * s;
            }

            System.out.println("#" + tc + " " + (a > b ? b : a));
        }
    }
}
