package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2804 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] strA = st.nextToken().split("");
        int n = strA.length;
        String[] strB = st.nextToken().split("");
        int m = strB.length;

        String[][] arr = new String[m][n];
        int p = 0, q = 0;

        Loop1 :
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(strA[i].equals(strB[j])) {
                    p = i;
                    q = j;
                    break Loop1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(q == i) {
                    arr[i][j] = strA[j];
                }
                else if(p == j) {
                    arr[i][j] = strB[i];
                } else {
                    arr[i][j] = ".";
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
