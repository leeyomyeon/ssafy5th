package study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        a %= 12;

        if(a < 3) {
            System.out.println("winter");
        } else if (a < 6) {
            System.out.println("spring");
        } else if (a < 9) {
            System.out.println("summer");
        } else if (a < 12) {
            System.out.println("fall");
        }
    }
}