package swea.d0210;

import java.util.Scanner;

public class 설탕배달 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		int answer = 987654321;
		
		for(int a = 0; a <= num / 5; a++) {
			for(int b = 0; b <= num / 3; b++) {
				if((5 * a) + (3 * b) == num && answer > (a + b)) {
					answer = a + b;
				} 
			}
		}
		if (answer == 987654321) {
			answer = -1;
		}
		System.out.println(answer);
	}
}
