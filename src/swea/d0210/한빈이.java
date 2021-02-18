package swea.d0210;

import java.util.Scanner;

public class 한빈이{
    public static int[] arr;
    public static int n;
    public static int m;
    public static int sum;
    public static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            max = -1;
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    sum = arr[i] + arr[j];
                    if(sum <= m && sum >= max) {
                        max = sum;
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
