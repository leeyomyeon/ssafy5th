package com.ssafy.보충;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486 {
    static int result;
    static int N, B;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            result = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            map = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int idx, int sum) {
        if(sum >= B) {
            result = Math.min(sum - B, result);
            return;
        }

        if(idx == N) {
            int d = sum - B;
            if(d < 0) {
                return;
            }
            result = Math.min(d, result);
            return;
        }

//        현재 위치의 사람의 키 선택
        sum += map[idx];
        dfs(idx + 1, sum);

//        현재 위치의 사람의 키 선택하지 않음ß
        sum -= map[idx];
        dfs(idx + 1, sum);

    }
}
