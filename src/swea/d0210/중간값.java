package swea.d0210;

import java.util.Scanner;

public class 중간값 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[101];

        for(int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            arr[a]++;
        }

        int len = n / 2;
        int mid = 0;
        for(int i = 1; i <= arr.length; i++) {
            len -= arr[i];
            if(len <= 0) {
                mid = i;
                break;
            }
        }
        System.out.println(mid);
    }
}
