package baekjoon.b0421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2846 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i] < arr[j]) {  // 오르막길
                    if(arr[j - 1] >= arr[j]) {
                        break;
                    }
                    max = Math.max(max, arr[j] - arr[i]);
                }
                else if (arr[i] >= arr[j]) {
                    break;
                }
            }
        }

        System.out.println(max);
    }
}
