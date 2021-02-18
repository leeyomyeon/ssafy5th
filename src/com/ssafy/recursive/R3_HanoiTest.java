package com.ssafy.recursive;

import java.util.Scanner;

public class R3_HanoiTest {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        hanoi(n,1,2,3);
    }

    private static void hanoi(int cnt, int from, int temp, int to) {
        count++;
        if(cnt == 0) {
            return;
        }
        // n-1개 원판 이동
        hanoi(cnt-1, from, to, temp);
        System.out.println(cnt+":"+from+"->"+to+" 횟수 : "+count);
        //n-1개 원판 이동
        hanoi(cnt-1, temp, from, to);
    }
}
