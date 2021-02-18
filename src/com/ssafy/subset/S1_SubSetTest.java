package com.ssafy.subset;

import java.util.Scanner;

public class S1_SubSetTest {

    static int N, totalCnt;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        input = new int[N];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++) {
            input[i] = scanner.nextInt();
        }

        generateSubset(0);
        System.out.println("총 경우의 수 : " + totalCnt);
    }

    private static void generateSubset(int cnt) {
        if(cnt == N) {
            totalCnt++;

            for(int i = 0; i < N; i++) {
                System.out.print((isSelected[i] ? input[i] : "X") + "\t");
            }


            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        generateSubset(cnt + 1);

        isSelected[cnt] = false;
        generateSubset(cnt + 1);
    }
}

