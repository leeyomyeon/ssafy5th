package com.ssafy;

public class 부분집합 {
    private static int[] arr = {1, 2, 3 ,4};
    private static boolean[] isSelected;

    public static void main(String[] args) {
        isSelected = new boolean[arr.length];

        powerSet(0);
    }

    private static void powerSet(int idx) {
        if(idx == arr.length) {
            for(int i = 0; i < arr.length; i++) {
                if(isSelected[i]) {
                    System.out.print(arr[i] + " ");
                } else {
                    System.out.print("∅ ");
                }
            }
            System.out.println();
            return;
        }

        isSelected[idx] = true;
        powerSet(idx + 1);

        isSelected[idx] = false;
        powerSet(idx + 1);
    }
}
