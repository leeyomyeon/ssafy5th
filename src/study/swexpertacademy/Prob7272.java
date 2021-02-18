package study.swexpertacademy;

import java.util.Scanner;

public class Prob7272 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            String[] s1 = scanner.next().split("");
            String[] s2 = scanner.next().split("");

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for(int i = 0; i < s1.length; i++) {
                if(s1[i].equals("A") || s1[i].equals("D") || s1[i].equals("O") || s1[i].equals("P") || s1[i].equals("Q") || s1[i].equals("R")) {
                    sb1.append("A");
                } else if (s1[i].equals("B")) {
                    sb1.append("B");
                } else {
                    sb1.append("Z");
                }
            }

            for(int i = 0; i < s2.length; i++) {
                if(s2[i].equals("A") || s2[i].equals("D") || s2[i].equals("O") || s2[i].equals("P") || s2[i].equals("Q") || s2[i].equals("R")) {
                    sb2.append("A");
                } else if (s2[i].equals("B")) {
                    sb2.append("B");
                } else {
                    sb2.append("Z");
                }
            }

            if(sb1.toString().equals(sb2.toString())) {
                System.out.println("#" + tc + " SAME");
            } else {
                System.out.println("#" + tc + " DIFF");
            }
        }
    }
}
