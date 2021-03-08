package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek14888 {
    static int[] arr;
    static int n;
    static ArrayList<Character> operation;
    static char[] selectOperation;
    static boolean[] selected;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selectOperation = new char[n - 1];
        selected = new boolean[n - 1];
        operation = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++) {
                if(i == 0) {
                    operation.add('+');
                } else if (i == 1) {
                    operation.add('-');
                } else if (i == 2) {
                    operation.add('*');
                } else if (i == 3) {
                    operation.add('/');
                }
            }
        }

        permutation(0);
        System.out.println(max);
        System.out.println(min);

    }

    public static void permutation(int cnt) {
        if(cnt == n-1) {
            int sum = arr[0];
            for(int i = 0; i < n - 1; i++) {
                if(selectOperation[i] == '+') {
                    sum += arr[i + 1];
                } else if (selectOperation[i] == '-') {
                    sum -= arr[i + 1];
                } else if (selectOperation[i] == '*') {
                    sum *= arr[i + 1];
                } else if (selectOperation[i] == '/') {
                    sum /= arr[i + 1];
                }
            }
            if(sum >= max) {
                max = sum;
            }
            if(min >= sum) {
                min = sum;
            }
            return;
        }

        for(int i = 0; i < n-1; i++) {
            if(!selected[i]) {
                selectOperation[cnt] = operation.get(i);
                selected[i] = true;
                permutation(cnt + 1);
                selected[i] = false;
            }
        }
    }
}
