package study.swexpertacademy;

import java.util.Scanner;

public class Prob1213 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            int tc = scanner.nextInt();
            scanner.nextLine();
            String split = scanner.nextLine();
            String line = scanner.nextLine();

            String[] str = line.split(split);

            int answer = str.length - 1;

            int start = line.length() - split.length();
            int end = line.length();

            if(line.substring(start, end).equals(split)) {
                answer++;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
