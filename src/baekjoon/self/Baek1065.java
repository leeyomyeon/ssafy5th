package baekjoon.self;

import java.util.Scanner;

public class Baek1065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str.length() <= 2) {
            System.out.println(str);
            return;
        }
        int answer = 99;
        for(int i = 100; i <= Integer.parseInt(str); i++) {
            String s = Integer.toString(i);
            int k = (s.charAt(0) - '0') - (s.charAt(1) - '0');
            boolean isok = true;
            for (int j = 1; j < s.length() - 1; j++) {
                if(s.charAt(j) - s.charAt(j + 1) != k) {
                    isok =false;
                    break;
                }
            }
            if(isok) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
