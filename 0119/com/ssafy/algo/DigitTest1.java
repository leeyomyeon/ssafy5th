package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class DigitTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] count = new int[10];

        while(true) {
            int t = scanner.nextInt();
            int k = t / 10;

            if(t == 0) {
                break;
            }

            count[k]++;
        }

        Arrays.stream(count).sorted();

        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) {
                continue;
            } else {
                System.out.println(i + " : "+ count[i]+"개");
            }
        }

        scanner.close();
    }
}
