package study.swexpertacademy;

import java.util.Scanner;

public class Prob1936 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        switch (a) {
            case 1 : if(b == 3) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
                break;

            case 2 : if(b == 1) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
                break;

            case 3 : if(b == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
                break;
        }
    }
}
