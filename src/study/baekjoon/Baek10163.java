package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10163 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[101][101];

        int cnt = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + dx; j++) {
                for (int k = y; k < y + dy; k++) {
                    arr[j][k] = i;
                }
            }
        }

        for(int i = 1; i <= cnt; i++) {
            int result = 0;
            for(int j = 0; j < 101; j++) {
                for(int k = 0; k < 101; k++) {
                    if(arr[j][k] == i) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
