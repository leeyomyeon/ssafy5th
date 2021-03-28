package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek15683_1 {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int n;
    public static int m;
    static int[][] cctv = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        arr = new int[m][n];
        visited = new boolean[m][n];
        ArrayList<int[]> list;
        list = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >= 1 && arr[i][j] <= 5) {
                    int[] tmp = {i, j};
                    list.add(tmp);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(i, j, arr[i][j]);
            }
        }
    }

    public static void dfs(int p, int q, int num) {

    }

}
