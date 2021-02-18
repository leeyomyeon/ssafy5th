package study.swexpertacademy;

import java.util.Scanner;

public class Prob2029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("#" + tc + " " + a/b + " " + a%b);
        }
    }
}
