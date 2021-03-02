package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[][] arr = new int[6][2];
        int cnt = 0;

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            arr[g - 1][s]++;
        }

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j <= 1; j++) {
                while(true) {
                    if(arr[i][j] <= 0) {
                        break;
                    }
                    arr[i][j] -= max;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
