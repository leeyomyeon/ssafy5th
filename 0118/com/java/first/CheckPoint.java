package com.java.first;

import java.util.Scanner;

public class CheckPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int weight = scanner.nextInt();

        int bmi = weight + 100 - height;

        System.out.println("비만수치는 "+bmi+"입니다.");

        if(bmi > 0) {
            System.out.println("당신은 비만이군요.");
        } else {
            System.out.println("당신은 정상 몸무게군요.");
        }

        scanner.close();
    }
}
