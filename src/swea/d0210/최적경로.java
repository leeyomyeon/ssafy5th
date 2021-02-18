package swea.d0210;

import java.util.Scanner;

public class 최적경로 {
    static int[][] arr;
    static int[][] selectArr;
    static boolean[] selected;
    static int comX, comY, homeX, homeY, n, sum;
    static int min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = scanner.nextInt();      // 고객 수
            arr = new int[n][2];            // 고객 집 저장
            selectArr = new int[n][2];
            min = Integer.MAX_VALUE;
            selected = new boolean[n];

            comX = scanner.nextInt();   // 회사 좌표
            comY = scanner.nextInt();

            homeX = scanner.nextInt();  // 집 좌표
            homeY = scanner.nextInt();

            for(int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }

            init(0);

            System.out.println("#" + tc + " " + min);

        }
    }

    // |x1-x2| + |y1-y2| 두 점 사이의 거리
    public static void init(int idx) {
        if(idx == n) {
            sum = 0;
            int k = selectArr.length;
            for (int i = 0; i < k; i++) {
                if(i == 0) {
                    sum += Math.abs(comX - selectArr[i][0]) + Math.abs(comY - selectArr[i][1]);
                } else {
                    sum += Math.abs(selectArr[i][0] - selectArr[i - 1][0]) + Math.abs(selectArr[i][1] - selectArr[i - 1][1]);
                }
            }
            sum += (Math.abs(homeX - selectArr[k - 1][0]) + Math.abs(homeY - selectArr[k - 1][1]));

            if(sum < min) {
                min = sum;
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!selected[i]) {
                selectArr[idx][0] = arr[i][0];  // 골라진넘 x좌표 저장
                selectArr[idx][1] = arr[i][1];  // 골라진넘 y좌표 저장

                selected[i] = true;
                init(idx + 1);
                selected[i] = false;
            }
        }
    }
}
