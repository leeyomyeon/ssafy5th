package study.swexpertacademy;

import java.util.Scanner;

public class Prob2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for(int i = 0; i <= a; i++) {
            int b = 1 << i;
            System.out.print(b + " ");
        }
    }
}
