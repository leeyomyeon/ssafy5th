package com.java.first;

public class CircleArea {
    public static void main(String[] args) {
        // 원의 넓이 = 𝜋𝓇²
        final double PI = 3.141592;
        int r = 5; // 5cm
        double area = PI * r * r;

        System.out.println("반지름이 5cm인 원의 넓이는 "+area+"cm²입니다.");
    }
}
