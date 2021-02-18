package com.ssafy.exhaustive;

import java.util.Arrays;

public class A2_TransposeMatrixTest {
    private static int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    private static void transport() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    private static void print() {
        for(int[] is : arr) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static void main(String[] args) {
        print();
        transport();
        print();
    }
}
