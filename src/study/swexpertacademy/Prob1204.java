package study.swexpertacademy;
import java.util.Scanner;

public class Prob1204 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {

            int tCase = scanner.nextInt();
            int[] arr = new int[101];

            for(int i = 0; i < 1000; i++) {
                int score = scanner.nextInt();

                arr[score]++;
            }

            int num = 0;
            int answer = 0;

            for(int i = 0; i < 100; i++) {
                if(num <= arr[i] && answer < i) {
                    num = arr[i];
                    answer = i;
                }
            }

            System.out.println("#" + tCase + " " + answer);
        }
    }
}
