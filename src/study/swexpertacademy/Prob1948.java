package study.swexpertacademy;

import java.util.Scanner;

public class Prob1948 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int answer = 0;

            int beforeMonth = scanner.nextInt();
            int beforeDay = scanner.nextInt();
            int afterMonth = scanner.nextInt();
            int afterDay = scanner.nextInt();

            int before = getDay(beforeMonth, beforeDay);
            int after = getDay(afterMonth, afterDay);

            answer = after - before + 1;

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int getDay(int month, int day) {
        int result = 0;
        if(month >= 2) {
            switch (month) {
                case 12:
                    result += 30;
                case 11:
                    result += 31;
                case 10:
                    result += 30;
                case 9:
                    result += 31;
                case 8:
                    result += 31;
                case 7:
                    result += 30;
                case 6:
                    result += 31;
                case 5:
                    result += 30;
                case 4:
                    result += 31;
                case 3:
                    result += 28;
                case 2:
                    result += 31;
            }
        }

        result += day;

        return result;
    }
}
