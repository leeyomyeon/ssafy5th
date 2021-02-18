package baekjoon.b0215;

import java.util.Scanner;

public class Baek15650 {
    static int[] number;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        number = new int[m];

        comb(0, 0);
    }

    public static void comb(int idx, int start) {
        if(idx == m) {
            StringBuilder sb = new StringBuilder();
            for(int k : number) {
                sb.append(k).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for(int i = start; i < n; i++) {
            number[idx] = i + 1;
            comb(idx + 1, i + 1);
        }
    }
}
