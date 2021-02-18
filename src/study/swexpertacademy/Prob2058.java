package study.swexpertacademy;

import java.util.Scanner;

public class Prob2058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int sum = 0;

        while(num >= 1) {
            sum += (num % 10);
            num /= 10;
        }

        System.out.println(sum);
    }
}
