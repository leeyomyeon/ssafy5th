package study.swexpertacademy;

import java.util.Scanner;

public class Prob1940 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();

            int speed = 0;
            int dis = 0;
            for(int i = 0; i < n; i++) {
                int command = scanner.nextInt();
                switch (command) {
                    case 1: // 가속
                        int pSpeed = scanner.nextInt();
                        speed += pSpeed;
                        break;
                    case 2: // 감속
                        int mSpeed = scanner.nextInt();
                        if(speed <= mSpeed) {
                            speed = 0;
                            break;
                        }
                        speed -= mSpeed;
                        break;
                }
                dis += speed;
            }

            System.out.println("#" + tc + " " + dis);
        }
    }
}
