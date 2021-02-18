package study.swexpertacademy;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;
public class Prob1928 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();

        for(int tc = 1; tc <= T; tc++) {
            String str = scanner.nextLine();

            Decoder decoder = Base64.getDecoder();

            byte[] b = decoder.decode(str);
            String decodeStr = new String(b);

            System.out.println("#"+tc+" "+decodeStr);
        }
    }
}
