package swea.d0210;

import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int a = scanner.nextInt();

            int arr[][] = new int[100][100];

            int x = 0;
            int y = 99;
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    arr[i][j] = scanner.nextInt();

                    if(arr[i][j] == 2) {
                        x = j;
                    }
                }
            }

            while(true) {
                y--;                // 위로 이동
                if(y == 0) {
                    break;
                }

                if (x - 1 >= 0 && arr[y][x - 1] == 1) { // 왼쪽에 1이 있으면
                    while (true) {
                        x--;                            // 왼쪽으로 이동
                        if (arr[y - 1][x] == 1) {   // 줄이 있으면 멈춤
                            break;
                        }
                    }
                } else if (x + 1 <= 99 && arr[y][x + 1] == 1) {  // 오른쪽에 1이 있으면
                    while (true) {
                        x++;                              // 오른쪽으로 이동
                        if (arr[y - 1][x] == 1) {   // 줄이 있으면 멈춤
                            break;
                        }
                    }
                }
            }

            System.out.println("#"+a+" "+x);
        }
    }
}
