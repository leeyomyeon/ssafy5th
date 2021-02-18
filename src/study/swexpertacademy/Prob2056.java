package study.swexpertacademy;

import java.util.Scanner;

public class Prob2056 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            String str = scanner.next();

            String year = str.substring(0,4);
            int condMonth = Integer.parseInt(str.substring(4,6));
            if(condMonth > 12) {
                System.out.println("#"+tc+" -1");
                continue;
            } else {
                int condDay = Integer.parseInt(str.substring(6,8));
                String month = str.substring(4,6);
                String day = str.substring(6,8);
                if((condMonth == 1 || condMonth == 3 || condMonth == 5 || condMonth == 7 || condMonth == 8 || condMonth == 10 || condMonth == 12) && condDay <= 31) {
                    System.out.println("#"+tc+" "+year+"/"+month+"/"+day);
                } else if ((condMonth == 9 || condMonth == 11 || condMonth == 4 || condMonth == 6) && condDay <= 30) {
                    System.out.println("#"+tc+" "+year+"/"+month+"/"+day);
                } else if (condMonth == 2 && condDay <= 28) {
                    System.out.println("#"+tc+" "+year+"/"+month+"/"+day);
                } else {
                    System.out.println("#"+tc+" -1");
                }
            }
        }
    }
}
