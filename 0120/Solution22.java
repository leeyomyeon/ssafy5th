import java.util.Scanner;

public class Solution22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();
            int num = scanner.nextInt();

            int[][] arr = new int[num][3];
            int answer = 0;

            for(int j = 0; j < num; j++) {
                arr[j][0] = scanner.nextInt();
                arr[j][1] = scanner.nextInt();
                arr[j][2] = scanner.nextInt();
            }
            scanner.nextLine();

            for(int k = 0; k < num; k++) {
                 for(int i = 3; i >= 1; i--){
                    switch(arr[k][2]) {
                        case 1 :                        // 방향이 1일때 행 감소
                            if(arr[k][0] - i < 0) {
                                arr[k][2] = 0;
                            } else {
                                arr[k][0] -= i;
                            }
                            break;
                        case 2 :                        // 방향이 2일때 행 증가
                            if(arr[k][0] + i >= n) {
                                arr[k][2] = 0;
                            } else {
                                arr[k][0] += i;
                            }
                            break;
                        case 3 :                        // 방향이 3일때 열 감소
                            if(arr[k][1] - i < 0) {
                                arr[k][2] = 0;
                            } else {
                                arr[k][1] -= i;
                            }
                            break;
                        case 4 :                        // 방향이 4일때 열 증가
                            if(arr[k][1] + i >= n) {
                                arr[k][2] = 0;
                            } else {
                                arr[k][1] += i;
                            }
                            break;
                    }

                    for(int j = 0; j < num; j++) {
                        if(j == k) {
                            continue;
                        } else {
                            if(arr[k][0] == arr[j][0] && arr[k][1] == arr[j][1] && arr[j][2] != 0) {
                                arr[k][2] = 0;
                            }
                        }
                    }
                }
            }

            int count = 0;

            for(int i = 0; i < num; i++) {
                if(arr[i][2] != 0) {
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
