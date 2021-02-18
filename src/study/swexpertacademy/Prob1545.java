package study.swexpertacademy;

import java.util.Scanner;

public class Prob1545 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        for(int i = a; i >= 0; i--) {
            System.out.print(i + " ");
        }
    }
}
