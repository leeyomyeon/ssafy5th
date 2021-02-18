import java.util.Scanner;

public class 색종이 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arr = new int[100][100];
        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for(int j = x; j < x + 10; j++) {
                for(int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
