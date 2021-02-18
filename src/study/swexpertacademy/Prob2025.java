package study.swexpertacademy;

import java.util.Scanner;

public class Prob2025 {
    public static int func(int num) {
        if(num > 1) {
            return num + func(num - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        System.out.println(func(num));
    }
}
