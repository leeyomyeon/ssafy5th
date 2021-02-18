package swea.d0210;

import java.util.ArrayList;
import java.util.Scanner;

public class swea민석이의과제 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = scanner.nextInt();  // 수강생 수
            int k = scanner.nextInt();  // 과제 낸 사람 수

            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                arr.add(i);
            }
            //과제를 제출한 사람의 번호 K개가 주어짐
            for(int i = 0; i < k; i++) {
                int num = scanner.nextInt();
                arr.remove((Object) num);
            }

            System.out.print("#" + tc + " ");
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
