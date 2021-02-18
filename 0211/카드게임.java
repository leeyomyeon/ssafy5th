import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 카드게임 {
    static ArrayList<Integer> a;    // 규영이
    static ArrayList<Integer> b;    // 인영이
    static int[] result;
    static boolean[] check = new boolean[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            // 모든 경우의수
            int allPlayScore = 362880;
            a = new ArrayList<>();
            b = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));

            result = new int[9];

            for(int i = 0; i < 9; i++) {
                int t = scanner.nextInt();
                if(b.remove((Object) t)) {
                    a.add(t);
                }
            }

            count = 0;

            permutation(0);
            System.out.println("#" + tc + " " + count + " " + (allPlayScore - count));
        }
    }

    static int aScore;
    static int bScore;
    static int count;

    public static void permutation(int index) {
        if(index == 9) {
            aScore = 0;
            bScore = 0;
            for(int i = 0; i < 9; i++) {
                int sum = a.get(i) + result[i];
                if(a.get(i) > result[i]) {
                    aScore += sum;
                } else {
                    bScore += sum;
                }
            }
            if(aScore > bScore) {
                count++;
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!check[i]) {
                result[index] = b.get(i);   // 인영이
                check[i] = true;
                permutation(index + 1);
                check[i] = false;
            }
        }
    }

}
