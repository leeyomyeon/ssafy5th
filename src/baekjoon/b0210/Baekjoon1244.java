package baekjoon.b0210;

import java.util.Scanner;

public class Baekjoon1244 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        boolean[] arr = new boolean[n];

        for(int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            if(p == 1) {
                arr[i] = true;
            }
        }

        int num = scanner.nextInt();

        for(int i = 0; i < num; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int r = q - 1;

            arr[r] = !arr[r];
            if(p == 1) {        // 남학생의 경우
                if(q <= n / 2) {
                    int m = 2;

                    while(true) {
                        if(q * m > n) {
                            break;
                        }
                        arr[q * m - 1] = !arr[q * m - 1];
                        m++;
                    }
                }
            } else {                        // 여학생의 경우
                int j = 1;
                while(true) {
                    if(r - j < 0 || r + j >= n) {
                        break;
                    }
                    if(arr[r - j] == arr[r + j]) {
                        arr[r - j] = !arr[r - j];
                        arr[r + j] = !arr[r + j];
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(arr[i-1]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
            if(i % 20 == 0)
                sb.append("\n");
        }
        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }
}
