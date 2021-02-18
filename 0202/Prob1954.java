import java.util.Scanner;

public class Prob1954 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int num = 1;
            int n = scanner.nextInt();

            int[][] arr = new int[n][n];
            int i = 0;
            int j = 0;
            int m = 0;

            n -= 2;
            while (true) {
                if(n < 1 && arr.length % 2 == 1) {
                    int k = arr.length / 2;
                    arr[k][k] = num;
                    break;
                } else if (n < 0 && arr.length % 2 == 0) {
                    break;
                }

                for(; i <= n; i++) {
                    arr[j][i] = num;
                    num++;
                }
                for(; j <= n; j++) {
                    arr[j][i] = num;
                    num++;
                }
                for(; i > m; i--) {
                    arr[j][i] = num;
                    num++;
                }
                for(; j > m; j--) {
                    arr[j][i] = num;
                    num++;
                }

                n--;
                i++;
                j++;
                m++;
            }

            System.out.println("#"+tc);
            for(i = 0; i < arr.length; i++) {
                for(j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
