package study.swexpertacademy;

import java.util.Scanner;

public class Prob1938 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print((a + b) + "\n" + (a - b) + "\n" + (a * b) + "\n" + (a / b));
    }
}