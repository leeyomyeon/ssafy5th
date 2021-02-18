package study.swexpertacademy;

import java.util.Scanner;

public class Prob1976 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int bHour = scanner.nextInt();
            int bMinute = scanner.nextInt();
            int aHour = scanner.nextInt();
            int aMinute = scanner.nextInt();

            int minute = bMinute + aMinute;
            int hour = bHour + aHour;

            if(minute >= 60) {
                minute %= 60;
                hour++;
            }

            if(hour > 12) {
                hour -= 12;
            }

            System.out.println("#" + tc + " " + hour + " " + minute);
        }
    }
}
