public class LottoGame {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        int k = 0;

        while (k != 6) {
            int num = (int) (Math.random() * 45) + 1;
            lotto[k] = num;
            k++;

            for (int i = 0; i < k-1; i++) {
                if (lotto[i] == num) {
                    k--;
                    break;
                }
            }
        }

        for(int j : lotto) {
            System.out.print(j + " ");
        }
    }
}
