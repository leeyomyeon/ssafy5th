import java.util.Scanner;

public class Prob5215 {

    public static class ingredient{
        int score;
        int cal;

        ingredient(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }
    static int n;
    static int maxCal;
    static ingredient[] ingredients;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = scanner.nextInt();
            maxCal = scanner.nextInt();

            boolean[] selected = new boolean[n];
            ingredients = new ingredient[n];
            maxScore = 0;

            for(int i = 0; i < n; i++) {
                ingredients[i] = new ingredient(scanner.nextInt(), scanner.nextInt());
            }

            hamburgerDiet(1 << n);

            System.out.println("#" + tc + " " + maxScore);
        }
    }

    static int sumCal;
    static int sumScore;
    static int maxScore;

    private static void hamburgerDiet(int caseCount) {
        for(int flag = 0; flag < caseCount; flag++) {
            sumScore = 0;
            sumCal = 0;
            for(int j = 0; j < n; j++) {
                if((flag & 1 << j) != 0) {
                    sumScore += ingredients[j].score;
                    sumCal += ingredients[j].cal;
                }
                if(sumCal > maxCal) {
                    break;
                }
            }
            if(sumCal <= maxCal && sumScore >= maxScore) {
                maxScore = sumScore;
            }
        }
    }
}

/*
import java.util.Scanner;

public class Solution {
    static int N, L, ans, Max;
    static int taste[], cal[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();

            taste = new int [N];
            cal = new int [N];
            Max = 0;
            for(int i = 0; i < N; i++) {
                taste[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            pick(0, 0, 0);
            System.out.println("#" + tc + " " + Max);
        }
    }

    static void pick(int idx, int sumTaste, int sumCal) {
        if(sumCal > L) return;
        if(idx == N) {
            if(sumTaste > Max) Max = sumTaste;
            return;
        }


            pick(idx + 1, sumTaste + taste[idx], sumCal + cal[idx]);
            pick(idx + 1, sumTaste, sumCal);
        }
    }


 */