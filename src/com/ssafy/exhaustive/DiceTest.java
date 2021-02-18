package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
    static int[] numbers;
    static int N, totalCnt;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();      // 주사위 던진 수

        numbers = new int[N];
        isSelected = new boolean[7];    // 1~6까지 주사위 눈의 수

        int M = scanner.nextInt();  // 던지는 모드 입력
        totalCnt = 0;

        switch (M) {
            case 1 :
                dice1(0);
                break;
            case 2 :
                dice2(0);
                break;
            case 3 :
                dice3(0, 1);
                break;
            case 4 :
                dice4(0, 1);
                break;
        }

        System.out.println("경우의 수 : " + totalCnt);
    }

    // 중복 순열 n∏r = n의 r제곱
    private static void dice1(int cnt) {
        if(cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 1; i <= 6; i++) {
            numbers[cnt] = i;
            dice1(cnt + 1);
        }
    }

    // 순열 nPr n * (n - 1) * (n - 2) ... (n - r + 1)
    private static void dice2(int cnt) {
        if(cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 1; i <= 6; i++) {
            if(isSelected[i]) {
                continue;
            }

            numbers[cnt] = i;
            isSelected[i] = true;

            dice2(cnt + 1);

            isSelected[i] = false;
        }
    }

    // 중복 조합 nHr = n+r-1Cr 8C3 = 56
    private static void dice3(int cnt, int start) {
        if(cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice3(cnt + 1, i);
        }
    }

    // 조합 nCr 모두 다른 수, 중복 허용 안함
    private static void dice4(int cnt, int start) {
        if(cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice4(cnt + 1, i + 1);
        }
    }
}
