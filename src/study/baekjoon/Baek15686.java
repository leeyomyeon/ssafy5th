package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek15686 {
    static int N, M;
    static ArrayList<Point> chicken;
    static ArrayList<Point> home;
    static int size;
    static Point[] selected;
    static int res;
    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        selected = new Point[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {    // 1은 집
                    home.add(new Point(i, j));
                } else if (n == 2) { // 2는 치킨
                    chicken.add(new Point(i, j));
                }
            }
        }
        size = chicken.size();
        res = Integer.MAX_VALUE;
        // 전체 치킨집 수 중 최대 M개를 고를 경우의 수
        combination(0, 0);
        System.out.println(res);
    }

    public static void combination(int cnt, int start) {
        if(cnt == M) {
            // M개 고르면 거리 계산
            int homeSize = home.size();
            int sum = 0;
            for(int i = 0; i < homeSize; i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < M; j++) {
                    // 여기서 거리 계산
                    min = Math.min(Math.abs(home.get(i).r - selected[j].r) + Math.abs(home.get(i).c - selected[j].c), min);
                }
                sum += min;
            }
            res = Math.min(res, sum);
            return;
        }

        for(int i = start; i < size; i++) {
            selected[cnt] = chicken.get(i);
            combination(cnt + 1, i + 1);
        }
    }
}
