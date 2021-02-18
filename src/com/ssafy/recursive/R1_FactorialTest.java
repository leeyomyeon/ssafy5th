package com.ssafy.recursive;

public class R1_FactorialTest {
    static int var = 1;
    private static int factorial(int n) {
        int result = 1;

        for(int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    private static void factorial2(int n) {
        if(n == 0) { return; }
        var *= n;
        factorial2(n - 1);
    }

    private static int factorial3(int n) {
        if(n==1) { return 1; }
        return n * factorial3(n - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
        factorial2(n);
        System.out.println(var);
        System.out.println(factorial3(n));
    }
}
