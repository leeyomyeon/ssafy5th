package study.baekjoon;

import java.util.Scanner;

public class Baek1592 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        int count = 0;

        int[] arr = new int[n];

        int k = 0;
        while(true) {
            if(k >= n) {
                k %= n;
            } else if(k < 0) {
                k += n;
            }
            arr[k]++;
            if(arr[k] == m) {
                break;
            }
            count++;

            if(arr[k] % 2 == 1) {
                k += l;
            } else {
                k -= l;
            }
        }

        System.out.println(count);
    }
}
