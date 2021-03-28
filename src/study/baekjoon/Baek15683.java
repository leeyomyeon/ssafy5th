package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15683 {
    static int[][] cctv = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] arr;
    static int m;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        arr = new int[m][n];


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 5) {
                    observe(i, j, arr[i][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] >= 1 && arr[i][j] <= 4) {
                    observe(i, j, arr[i][j]);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static int count;
    public static void observe(int p, int q, int cctvNum) {
        int max = 0;
        int idx = 0;
        if(cctvNum == 1) {
            for(int i = 0; i < 4; i++) {
                count = 0;
                maxCount(p, q, i);
                if(max < count) {
                    max = count;
                    idx = i;
                }
            }
            dfs(p, q, idx);
        } else if(cctvNum == 2) {
            for(int i = 0; i < 2; i++) {
                count = 0;
                maxCount(p, q, i);
                maxCount(p, q, i+2);
                if(max < count) {
                    max = count;
                    idx = i;
                }
            }
            dfs(p, q, idx);
            dfs(p, q, idx+2);
        } else if(cctvNum == 3) {
            for(int i = 0; i < 4; i++) {
                count = 0;
                maxCount(p, q, i);
                maxCount(p, q, (i+1)%4);
                if(max < count) {
                    max = count;
                    idx = i;
                }
            }
            dfs(p, q, idx);
            dfs(p, q, (idx+1)%4);
        } else if(cctvNum == 4) {
            for(int i = 0; i < 4; i++) {
                count = 0;
                maxCount(p, q, i);
                maxCount(p, q, (i+1)%4);
                maxCount(p, q, (i+2)%4);
                if(max < count) {
                    max = count;
                    idx = i;
                }
            }
            dfs(p, q, idx);
            dfs(p, q, (idx+1)%4);
            dfs(p, q, (idx+2)%4);
        } else if(cctvNum == 5) {
            for(int i = 0; i < 4; i++) {
                dfs(p, q, i);
            }
        }
    }

    public static void maxCount(int p, int q, int index) {
        if(p < 0 || q < 0 || p >= m || q >= n || arr[p][q] == 6) {
            return;
        } else {
            if(arr[p][q] == 0) {
                count++;
            }
            maxCount(p + cctv[index][0], q + cctv[index][1], index);
        }
    }

    public static void dfs(int p, int q, int index) {
        if(p < 0 || q < 0 || p >= m || q >= n || arr[p][q] == 6) {
            return;
        } else {
            if(arr[p][q] == 0) {
                arr[p][q] = 7;
            }
            dfs(p + cctv[index][0], q + cctv[index][1], index);
        }
    }
}

