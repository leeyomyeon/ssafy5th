package baekjoon.b0210;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {
    private static int[] arr;
    private static boolean[] isSelected;
    private static int[] selected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arr = new int[9];
        selected = new int[7];
        isSelected = new boolean[9];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        powerSet(0);
    }

    private static void powerSet(int idx) {
        if(idx == arr.length) {
            int count = 0;
            for(int i = 0; i < isSelected.length; i++) {
                if(isSelected[i]) {
                    count++;
                }
            }
            if(count == 7) {
                int j = 0;
                int sum = 0;
                for(int i = 0; i < arr.length; i++) {
                    if(isSelected[i]) {
                        sum += arr[i];
                        selected[j] = arr[i];
                        j++;
                    }
                }

                if(sum == 100) {
                    Arrays.sort(selected);

                    for(int i = 0; i < selected.length; i++) {
                        System.out.println(selected[i]);
                    }
                    System.exit(0);
                }
            }
            return;
        }

        isSelected[idx] = true;
        powerSet(idx + 1);

        isSelected[idx] = false;
        powerSet(idx + 1);
    }
}
