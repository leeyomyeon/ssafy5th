package study.swexpertacademy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1989 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            char[] chr = scanner.next().toCharArray();
            Set<Character> set = new HashSet<>();
            int answer = 0;

            for(char c : chr) {
                set.add(c);
            }

            if((chr.length + 1) / 2 == set.size()) {    // 회문이다.
                answer = 1;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
