package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14889 {
    static int n;
    static int[][] arr;
    static int[] start;
    static int[] link;
    static int MAX = Integer.MAX_VALUE;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        start = new int[n/2];
        link = new int[n/2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        combination(0, 1);
        System.out.println(MAX);
    }

    public static void combination(int cnt, int st) {
        if(cnt == n / 2) {
            int index = 0;

            for(int i = 1; i <= n; i++) {
                if(Arrays.binarySearch(start, i) < 0) {
                    link[index] = i;
                    index++;
                }
            }

            int startSum = 0;
            for(int j : start) {
                for(int k : start) {
                    if(j == k) {
                        continue;
                    }
                    startSum += arr[j-1][k-1];
                }
            }

            int linkSum = 0;
            for(int j : link) {
                for(int k : link) {
                    if(j == k) {
                        continue;
                    }
                    linkSum += arr[j-1][k-1];
                }
            }

            int diff = Math.abs(startSum - linkSum);
            if(diff < MAX) {
               MAX = diff;
               answer = diff;
            }
            return;
        }
        for(int i = st; i <= n; i++) {
            //i가 index
            start[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
}
