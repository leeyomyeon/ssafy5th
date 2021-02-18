package study.swexpertacademy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1288 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int answer = 0;

            int n = scanner.nextInt();

            int a = 1;
            Set<String> set = new HashSet<>();
            while (true) {
                String[] num = Integer.toString(n * a).split("");
                for(int i = 0; i < num.length;i++) {
                    set.add(num[i]);
                }
                if(set.size() == 10) {
                    answer = n * a;
                    break;
                }
                a++;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
