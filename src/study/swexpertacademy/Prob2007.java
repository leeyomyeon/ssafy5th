package study.swexpertacademy;

import java.util.Scanner;

public class Prob2007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder(scanner.next());
            String str = "";

            for(int i = 1; i <= sb.length(); i++) {
                str = sb.substring(0, i);

                if(sb.substring(str.length(), str.length() * 2).equals(str)) {
                    break;
                }
            }

            System.out.println("#" + tc + " " + str.length());
        }
    }
}
