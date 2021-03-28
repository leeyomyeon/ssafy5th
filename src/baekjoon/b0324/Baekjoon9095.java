package baekjoon.b0324;

import java.util.Scanner;

public class Baekjoon9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int tc = 0; tc < T; tc++) {
            int num = scanner.nextInt();
            int[] arr = new int[num + 1];
            if(num >= 1) {
                arr[1] = 1;
            }
            if(num >= 2) {
                arr[2] = 2;
            }
            if(num >= 3) {
                arr[3] = 4;
            }
            for(int i = 4; i <= num; i++) {
                arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
            }

            System.out.println(arr[num]);
        }
    }
}
