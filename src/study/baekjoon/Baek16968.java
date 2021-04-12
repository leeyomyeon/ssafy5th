package study.baekjoon;

import java.util.Scanner;

public class Baek16968 {
    static int number = 10;
    static int alphabet = 26;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.next().split("");

        // c = 문자, d = 숫자
        int res = 1;

        for(int i = 0; i < str.length; i++) {
            if(i == 0) {
                if (str[i].equals("c")) {
                    res *= alphabet;
                } else {
                    res *= number;
                }
            } else {
                if(str[i - 1].equals("c") && str[i].equals("c")) {  // 두 값이 c이면
                    res *= (alphabet - 1);
                } else if(str[i - 1].equals("d") && str[i].equals("d")) {   // 두 값이 d이면
                    res *= (number - 1);
                } else {
                    if(str[i].equals("c")) {
                        res *= alphabet;
                    } else {
                        res *= number;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
