package swea.d0210;

import java.util.Scanner;

public class Solution {
    static int N; // 재료의 수
    static int limit; // 칼로리 리미트
    static int[] score;
    static int[] cal;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc < T; tc++) {
            int N = sc.nextInt();
            int limit = sc.nextInt();
            score = new int[N];
            cal = new int[N];
            for(int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            sel = new boolean[N];
            ans = 0;
            System.out.println("#" + tc + " " + ans);
        }
    }
    static boolean[] sel;
    static int ans = 0;

    static void hamburger(int idx, int sumCal, int sumScore) {
        if (sumCal > limit) {
            return;
        }
        if (sumScore > ans) {
            return;
        }
        if (idx == N) {
            return;
        }

        hamburger(idx + 1, sumCal + cal[idx], sumScore + score[idx]);
        hamburger(idx + 1, sumCal, sumScore);
    }

    static void powerset(int idx) {
        if(idx == N) {
            // 이번 케이스에서 선택되어진 재료들의 칼로리와 점수의 총합 구하기
            int sumCal = 0;
            int sumScore = 0;
            for(int i = 0; i < N; i++) {
                if(sel[i]) {
                    sumCal += cal[i];
                    sumScore += score[i];
                }
            }
            if(sumCal < limit && sumScore > ans) {
                ans = sumScore;
            }
            return;
        }
        sel[idx] = true;
        powerset(idx + 1);
        sel[idx] = false;
        powerset(idx + 1);
    }
}
