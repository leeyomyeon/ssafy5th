package baekjoon.b0217;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2667 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        arr = new int[n][n];
        count = 0;
        for(int i = 0; i < n; i++) {
            String str = scanner.next();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = (int)str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    sum = 0;
                    move(i, j);
                    count++;
                    if(sum == 0) {
                        sum += 1;
                    }
                    list.add(sum);
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int k : list) {
            System.out.println(k);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static int sum;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void move(int p, int q) {
        for(int i = 0; i < 4; i++) {
            int dp = p;
            int dq = q;
            dp += dx[i];
            dq += dy[i];
            if(dp >= 0 && dq >= 0 && dp < n && dq < n && arr[dp][dq] == 1) {
                arr[dp][dq] = 0;
                sum++;
                move(dp, dq);
            }
        }
    }

}
