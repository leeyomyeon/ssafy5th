package study.swexpertacademy;

import java.util.Scanner;

public class Prob1221 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            String testCase = scanner.next();

            int num = scanner.nextInt();
            int[] numArr = new int[10];

            String[] str = new String[10];

            for(int i = 0; i < num; i++) {
                String gns = scanner.next();
                switch (gns) {
                    case "ZRO" : numArr[0]++; break;
                    case "ONE" : numArr[1]++; break;
                    case "TWO" : numArr[2]++; break;
                    case "THR" : numArr[3]++; break;
                    case "FOR" : numArr[4]++; break;
                    case "FIV" : numArr[5]++; break;
                    case "SIX" : numArr[6]++; break;
                    case "SVN" : numArr[7]++; break;
                    case "EGT" : numArr[8]++; break;
                    case "NIN" : numArr[9]++; break;
                }
            }

            System.out.println(testCase);

            for(int i = 0; i < numArr.length; i++) {
                for(int j = 0; j < numArr[i]; j++) {
                    switch (i) {
                        case 0 : System.out.print("ZRO "); break;
                        case 1 : System.out.print("ONE "); break;
                        case 2 : System.out.print("TWO "); break;
                        case 3 : System.out.print("THR "); break;
                        case 4 : System.out.print("FOR "); break;
                        case 5 : System.out.print("FIV "); break;
                        case 6 : System.out.print("SIX "); break;
                        case 7 : System.out.print("SVN "); break;
                        case 8 : System.out.print("EGT "); break;
                        case 9 : System.out.print("NIN "); break;
                    }
                }
            }

            System.out.println();
        }
    }
}
