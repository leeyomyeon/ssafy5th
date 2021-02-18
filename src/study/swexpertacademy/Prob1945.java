package study.swexpertacademy;

import java.util.Scanner;

public class Prob1945 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();

            int[] arr = new int[5];

            while(n % 2 == 0) {
                n /= 2;
                arr[0]++;
            }
            while(n % 3 == 0){
                n /= 3;
                arr[1]++;
            }
            while(n % 5 == 0){
                n /= 5;
                arr[2]++;
            }
            while(n % 7 == 0){
                n /= 7;
                arr[3]++;
            }
            while(n % 11 == 0){
                n /= 11;
                arr[4]++;
            }

            System.out.println("#"+tc+" "+arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]);
        }
    }
}
