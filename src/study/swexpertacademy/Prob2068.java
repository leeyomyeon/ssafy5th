package study.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class Prob2068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int[] arr = new int[10];

            for(int i = 0; i < 10; i++) {
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);

            System.out.println("#"+tc+" "+arr[9]);
        }
    }
}
