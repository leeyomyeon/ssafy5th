package baekjoon.b0323;

import java.util.Scanner;

public class Baek1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] arr = new int[num + 1];
        arr[1] = 0;
        int a = 2;

        while(a <= num) {
            int minusOne;
            int divideTwo = Integer.MAX_VALUE;
            int divideThree = Integer.MAX_VALUE;
            if(a % 2 == 0) {    // 2로 나누어 떨어질 때
                divideTwo = arr[a / 2] + 1;
            }
            if(a % 3 == 0) {    // 3으로 나누어 떨어질 때
                divideThree = arr[a / 3] + 1;
            }
            minusOne = arr[a - 1] + 1;

            int res = Math.min(minusOne, Math.min(divideThree, divideTwo));
            arr[a] = res;
            a++;
        }

        System.out.println(arr[num]);
    }
}
