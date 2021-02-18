package com.ssafy.exhaustive;

import java.util.Scanner;

public class C2_NextPermutationTest {
    static int N, R;
    static int[] input;
    static int[] P;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        R = scanner.nextInt();

        P = new int[N];         // N 크기의 flag 배열
        input = new int[N];

        for(int i = 0; i < N; i++) {
            input[i] = scanner.nextInt();
        }

        int cnt = 0;
        while(++cnt <= R) {
            P[N - cnt] = 1;
        }

        do {
            for(int i = 0; i < N; i++) {
                if(P[i] == 1) {
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
        }while(np(P));
    }

    // 1의 위치는 그 자리에 있는 수를 뽑았다.
    // 0011 1010 1001 1100

    public static boolean np(int[] arr) {
        // STEP 1
        int i = N - 1;  // 꼭대기

        while(i > 0 && arr[i - 1] >= arr[i]) {  // 인접한 것 비교
            --i;                                    // 뒤쪽부터 처리하니 감소.
        }

        if(i == 0) {    // 꼭대기를 찾았는데 맨 위면 리턴
            return false;
        }

        // STEP 2
        int j = N - 1;

        while(arr[i - 1] >= arr[j]) {   // 꼭대기를 찾았으면 다시 뒤쪽부터 찾는다. 인접한 두개가 아님
            --j;                            // i - 1 : 교환위치, j : 교환위치보다 큰 수인지 비교, 뒤쪽부터 처리하니 감소.
        }

        // STEP 3
        swap(arr, i - 1, j);                 // 스왑

        // STEP 4
        int k = N - 1;                      // 꼭대기부터 맨 뒤의 자리를 바꿔야함

        while(i < k) {                      // i는 올라가고 k는 내려가면서 자리 스왑
            swap(arr, i++, k--);
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
