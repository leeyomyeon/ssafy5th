package study.baekjoon;

import java.util.Scanner;

public class Baek13458 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long count = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int b = scanner.nextInt();
        int c = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] -= b;
            count++;
            if(arr[i] > 0) {
                count += (arr[i] / c);
                if(arr[i] % c > 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
