package study.swexpertacademy;

import java.util.Scanner;

public class Prob1959 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[] Ai = new int[n];
            int[] Bj = new int[m];

            for(int i = 0; i < n; i++) {
                Ai[i] = scanner.nextInt();
            }
            for(int i = 0; i < m; i++) {
                Bj[i] = scanner.nextInt();
            }

            int max = 0;
            int lenA = Ai.length;
            int lenB = Bj.length;

            if(lenA > lenB) {
                for(int i = 0; i <= lenA - lenB; i++) {
                    int sum = 0;
                    for(int k = 0; k < lenB; k++) {
                        sum += Bj[k] * Ai[k + i];
                    }
                    if(sum >= max) {
                        max = sum;
                    }
                }
            } else if (lenB > lenA) {
                for(int i = 0; i <= lenB - lenA; i++) {
                    int sum = 0;
                    for(int k = 0; k < lenA; k++) {
                        sum += Ai[k] * Bj[k + i];
                    }
                    if(sum >= max) {
                        max = sum;
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
