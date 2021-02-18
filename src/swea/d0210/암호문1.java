package swea.d0210;

import java.util.ArrayList;
import java.util.Scanner;

public class 암호문1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = scanner.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();

            for(int i = 0; i < n; i++) {    // 암호문의 길이
                int t = scanner.nextInt();
                arr.add(t);
            }

            int m = scanner.nextInt(); // 명령어의 개수

            for(int i = 0; i < m; i++) {
                scanner.next();     // l 문자를 건너뛰기 위함
                int x = scanner.nextInt();  // x의 위치에
                int y = scanner.nextInt();  // 다음 y개 숫자 삽입.

                for(int j = 0; j < y; j++) {
                    int s = scanner.nextInt();
                    arr.add(x + j, s);
                }
            }

            System.out.print("#" + tc + " ");
            for(int i = 0; i < 10; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }

    }
}
