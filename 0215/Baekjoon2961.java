import java.util.Scanner;

public class Baekjoon2961 {
    public static class ingredient {
        int sweet;
        int bitter;

        ingredient(int bitter, int sweet) {
            super();
            this.bitter = bitter;
            this.sweet = sweet;
        }
    }

    public static ingredient[] ingredients;
    public static boolean[] selected;
    public static int n;
    public static int sumSweet;
    public static int sumBitter;
    public static int result;
    public static int min;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        ingredients = new ingredient[n];
        selected = new boolean[n];

        for(int i = 0; i < n; i++) {
            ingredients[i] = new ingredient(scanner.nextInt(), scanner.nextInt());
        }

        min = 987654321;

        mix(0);
        System.out.println(min);
    }

    public static void mix(int index) {
        if(index == n) {
            sumSweet = 0;
            sumBitter = 1;
            result = 0;

            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    sumBitter *= ingredients[i].bitter;
                    sumSweet += ingredients[i].sweet;
                }
            }

            if(sumSweet == 0) {
                return;
            }

            result = Math.abs(sumBitter - sumSweet);

            if(result < min) {
                min = result;
            }
            return;
        }

        selected[index] = true;
        mix(index + 1);

        selected[index] = false;
        mix(index + 1);
    }
}
