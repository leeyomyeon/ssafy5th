package study.swexpertacademy;

import java.util.Scanner;

public class Prob2072 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {

            int[] arr = new int[10];

            int sum = 0;
            for(int i = 0; i < 10; i++) {
                arr[i] = scanner.nextInt();
                if(arr[i] % 2 == 0) {
                    continue;
                }
                sum += arr[i];
            }

            System.out.println("#"+tc +" "+sum);
        }
    }
}
