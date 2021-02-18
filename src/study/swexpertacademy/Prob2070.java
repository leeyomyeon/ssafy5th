package study.swexpertacademy;

import java.util.Scanner;

public class Prob2070 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            char c = '=';

            if(a > b) {
                c = '>';
            } else if (a < b) {
                c = '<';
            }
            System.out.println("#"+tc+" "+c);
        }
    }
}
