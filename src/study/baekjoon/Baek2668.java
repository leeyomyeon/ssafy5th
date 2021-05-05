package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2668 {
    public static int N;
    public static int[] arr;
    public static boolean[] selected;
    public static int[] resNum;
    public static int maxSize = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        selected = new boolean[N + 1];
        powerSet(1, 0);
        System.out.println(resNum.length);
        for(int i : resNum) {
            System.out.println(i);
        }
    }

    public static void powerSet(int cnt, int selectCnt) {
        if(cnt == N + 1) {
            if(selectCnt < maxSize) {
                return;
            }
            int[] selectNum = new int[selectCnt];
            int k = 0;
            for(int i = 1; i <= N; i++) {
                if(selected[i]) {
                    selectNum[k] = arr[i];
                    k++;
                }
            }

            Arrays.sort(selectNum);
            k = 0;
            for(int i = 1; i <= N; i++) {
                if(selected[i] && i == selectNum[k]) {
                    k++;
                } else if(selected[i] && i != selectNum[k]) {
                    return;
                }
            }

            if(maxSize < selectCnt) {
                maxSize = selectCnt;
                resNum = new int[selectCnt];
                System.arraycopy(selectNum, 0, resNum, 0, selectCnt);
            }
            return;
        }

        selected[cnt] = true;
        powerSet(cnt + 1, selectCnt + 1);
        selected[cnt] = false;
        powerSet(cnt + 1, selectCnt);
    }
}
/*
7
2
6
5
4
3
2
7
*/
