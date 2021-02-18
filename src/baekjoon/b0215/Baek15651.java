package baekjoon.b0215;

import java.util.Scanner;
// 시간 초과
public class Baek15651 {
    static int[] number;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        number = new int[m];

        perm(0);
    }

    public static void perm(int idx) {
        if(idx == m) {
            return;
        }

        for(int i = 0; i < n; i++) {
            perm(idx + 1);
        }
    }
}