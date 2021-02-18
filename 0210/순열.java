import java.util.Arrays;

public class 순열 {
    static int[] arr = {1, 3, 5};
    static int[] result = new int[3];
    static boolean[] check = new boolean[3];
    public static void main(String[] args) {
        perm1(0);
        System.out.println("----------");
        perm2(0);
    }
    static void perm2(int idx) {    // 중복 없는 순열
        if(idx == 3) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(!check[i]) {
                result[idx] = arr[i];
                check[i] = true;
                perm2(idx + 1);
                check[i] = false;
            }
        }
    }
    static void perm1(int idx) { // 중복순열
        if(idx == 3) {
            System.out.println(Arrays.toString(result));
            return;
        }
        //원소의 개수만큼 n갈래로 감
        for(int i = 0; i < 3; i++) {
            result[idx] = arr[i];
            perm1(idx + 1);
        }
    }
}
