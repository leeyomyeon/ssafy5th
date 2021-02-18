package swea.d0210;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int[] arr = new int[100];

            int count = scanner.nextInt();

            for(int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }

            for(int i=0;i<count;i++){
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);

            System.out.println("#"+tc+" "+(arr[99]-arr[0]));
        }
    }
}