package study.swexpertacademy;

import java.util.Scanner;

public class Prob1209 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int tc = scanner.nextInt();
			
			int[][] arr = new int[100][100];
			
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					arr[j][k] = scanner.nextInt();
				}
			}
			
			int[][] answer = new int[2][101];
			
			for(int j = 0; j < 100; j++) {	// 가로 더하기
				for(int k = 0; k < 100; k++) {
					answer[0][j] += arr[j][k];
				}
			}
			
			for(int j = 0; j < 100; j++) { 	// 세로 더하기
				for(int k = 0; k < 100; k++) {
					answer[1][j] += arr[k][j];
				}
			}
			
			for(int j = 0; j < 100; j++) {
				answer[0][100] += arr[j][j];
			}
			
			for(int j = 0; j < 100; j++) {
				answer[1][100] += arr[j][99-j];
			}
			
			int temp = 0;
			
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 101; k++) {
					if(temp <= answer[j][k]) {
						temp = answer[j][k];
					}
				}
			}
			
			System.out.println("#" + tc + " " + temp);
		}
	}
}
