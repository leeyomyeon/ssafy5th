package swea.d0210;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의붕어빵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();  // 손님
            int m = scanner.nextInt();  // m초의 시간을 들이면
            int k = scanner.nextInt();  // k개의 붕어빵을 만들 수 있다.

            String possible = "#" + tc + " Possible";
            String impossible = "#" + tc + " Impossible";

            if(n == 0) {
                System.out.println(impossible);
                continue;
            }

            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);

            int count = 0;
            int j = 0;
            boolean p = true;

            for(int i = 0; i <= arr[n-1]; i++) {
                if (i > 0 && i % m == 0) {
                    count += k;
                }

                while(j < arr.length && i == arr[j]) {
                    count--;
                    j++;
                    if(count < 0) {
                        p = false;
                        break;
                    }
                }
            }

            if(p) {
                System.out.println(possible);
            } else {
                System.out.println(impossible);
            }
        }
    }
}
