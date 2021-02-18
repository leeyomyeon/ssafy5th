package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class P4_PermutationNPTest {
    static int N;
    static int[] input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        input = new int[N];

        for(int i = 0; i < N; i++) {
            input[i] = scanner.nextInt();
        }

        Arrays.sort(input); // 최초 오름차순 정령 1회 실시

        do{
            System.out.println(Arrays.toString(input));
        } while(np());
    }

    public static boolean np() {
        // STEP 1
        int i = N - 1;  // 꼭대기

        while(i > 0 && input[i - 1] >= input[i]) {  // 인접한 것 비교
            --i;                                    // 뒤쪽부터 처리하니 감소.
        }

        if(i == 0) {    // 꼭대기를 찾았는데 맨 위면 리턴
            return false;
        }

        // STEP 2
        int j = N - 1;

        while(input[i - 1] >= input[j]) {   // 꼭대기를 찾았으면 다시 뒤쪽부터 찾는다. 인접한 두개가 아님
            --j;                            // i - 1 : 교환위치, j : 교환위치보다 큰 수인지 비교, 뒤쪽부터 처리하니 감소.
        }

        // STEP 3
        swap(i - 1, j);                 // 스왑

        // STEP 4
        int k = N - 1;                      // 꼭대기부터 맨 뒤의 자리를 바꿔야함

        while(i < k) {                      // i는 올라가고 k는 내려가면서 자리 스왑
            swap(i++, k--);
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
