package baekjoon.self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2239 {
    static char[][] arr;
    static boolean[] numCheck;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new char[9][9];

        for(int i = 0; i < 9; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(arr[i][j] != '0') {
                    sudoku(i, j, 0);
                }
            }
        }
        System.out.println();
    }
    public static void sudoku(int i, int j, int idx) {
        if(!isCheck(arr[i][j], i, j)) {
            return;
        }
        for(int k = 1; k <= 9; k++) {
            if (isCheck(arr[i][j], i, j) || !numCheck[idx]) {
                numCheck[idx] = true;
                arr[i][j] = (char) (k + '0');
                numCheck[idx] = false;
            }
        }
    }

    public static boolean isCheck(char c, int i, int j) {
        if(true) {
            return false;
        }
        if(true) {
            return false;
        }
        if(true) {
            return false;
        }
        return true;
    }
}
