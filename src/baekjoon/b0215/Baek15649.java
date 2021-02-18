package baekjoon.b0215;

import java.util.Scanner;

public class Baek15649 {
    static int[] number;
    static boolean[] selected;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        number = new int[m];
        selected = new boolean[n];

        perm(0);
    }

    public static void perm(int idx) {
        if(idx == m) {
            StringBuilder sb = new StringBuilder();
            for(int k : number) {
                sb.append(k).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!selected[i]) {
                number[idx] = i + 1;
                selected[i] = true;
                perm(idx + 1);
                selected[i] = false;
            }
        }
    }
}
