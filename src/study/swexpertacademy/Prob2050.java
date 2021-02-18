package study.swexpertacademy;

import java.util.Scanner;

public class Prob2050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] str = scanner.nextLine().split("");

        for(int i = 0; i < str.length; i++) {
            int c = str[i].charAt(0) - 64;
            System.out.print(c + " ");
        }
    }
}
