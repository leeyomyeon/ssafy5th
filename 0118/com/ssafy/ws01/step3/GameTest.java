package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요");
        System.out.println("1. 5판 3승");
        System.out.println("2. 3판 2승");
        System.out.println("3. 1판 1승");
        System.out.print("번호를 입력하세요. ");

        int sel = scanner.nextInt();
        int roundCount;
        int winCount = 0;
        int loseCount = 0;

        if(sel == 1) {
            roundCount = 5;
        } else if (sel == 2) {
            roundCount = 3;
        } else if (sel == 3) {
            roundCount = 1;
        } else {
            System.out.println("잘못 입력했습니다. 프로그램을 종료합니다.");
            return;
        }

        for(int i = 0; i < roundCount; i++) {
            int computer = (int)(Math.random() * 3) + 1;    // 1.가위, 2.바위, 3.보

            System.out.print("가위바위보 중 하나 입력 : ");

            String abc = scanner.next();

            switch (abc) {
                case "가위" : if(computer == 3) {
                                System.out.println("이겼습니다!!");
                                winCount++;
                            } else {
                                System.out.println("졌습니다!!");
                                loseCount++;
                            }
                            break;

                case "바위" : if(computer == 1) {
                                System.out.println("이겼습니다!!");
                                winCount++;
                            } else {
                                System.out.println("졌습니다!!");
                                loseCount++;
                            }
                            break;

                case "보" : if(computer == 2) {
                                System.out.println("이겼습니다!!");
                                winCount++;
                            } else {
                                System.out.println("졌습니다!!");
                                loseCount++;
                            }
                            break;
            }

            int winCondition = roundCount / 2;

            if(winCondition < winCount) {
                System.out.println("### 당신의 승리입니다!!!");
                break;
            } else if (winCondition < loseCount) {
                System.out.println("### 컴퓨터의 승리입니다!!!");
                break;
            }
        }

        scanner.close();
    }
}
