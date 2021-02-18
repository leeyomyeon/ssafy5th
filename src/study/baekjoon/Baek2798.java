package study.baekjoon;

import java.util.Scanner;

public class Baek2798 {
    public static int n;
    public static int m;
    public static int[] arr;
    public static int max;
    public static int[] numbers = new int[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n];
        max = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        combination(0, 0);

        System.out.println(max);
    }

    public static void combination(int cnt, int start) {
        if(cnt == 3) {
            int sum = 0;
            for(int k : numbers) {
                sum += k;
            }
            if(sum <= m && sum >= max) {
                max = sum;
            }
            return;
        }

        for(int i = start; i < n; i++) {
            numbers[cnt] = arr[i];
            combination(cnt + 1, i + 1);
        }
    }
}
