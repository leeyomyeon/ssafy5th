package com.ssafy.recursive;

public class R2_ArrayTest {
    static int[] arr = {10, 20, 30};

    private static void printArray1(int i) {
        if(i == arr.length) {
            System.out.println();
            return;
        }

        System.out.print(arr[i] + "\t");
        printArray1(i + 1);
    }

    static int[][] arr2 = {{10, 20, 30}, {40, 50, 60}};

    private static void printRowArray(int i) {
        if(i == arr2.length) {
            System.out.println();
            return;
        }
        for(int j = 0; j < arr2[i].length; j++) {
            System.out.print(arr2[i][j] + "\t");
        }
        System.out.println();

        printRowArray(i + 1);
    }

    // print Element array 사용
    // n개 중 k개를 뽑는 조합의 경우의 수를 재귀롤 작성
    public static void main(String[] args) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        printArray1(0);
        printRowArray(0);
    }
}
