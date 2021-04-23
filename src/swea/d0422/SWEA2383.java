package swea.d0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA2383 {
    public static int N;
    public static int[][] arr;
    public static LinkedList<Point> list;
    public static Stair stair1, stair2;
    public static PriorityQueue<Point> pqStair1;
    public static PriorityQueue<Point> pqStair2;
    public static class Point implements Comparable<Point> {
        int r;
        int c;
        int d;      // 계단과의 거리
        public Point(int r, int c, int d) {  // 사람용 생성자
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            return d - o.d;
        }
    }
    public static class Stair {
        int r;
        int c;
        int depth;

        public Stair(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        stair1 = null;
        stair2 = null;

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N * N; i++) {
                if(i % N == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                arr[i / N][i % N] = Integer.parseInt(st.nextToken());
                if(arr[i / N][i % N] == 1) {
                    list.add(new Point(i / N, i % N, 0));
                } else if (arr[i / N][i % N] >= 2) {
                    // 계단 위치 저장
                    if(stair1 == null && stair2 == null) {
                        stair1 = new Stair(i / N, i % N, arr[i / N][i % N]);
                    } else {
                        stair2 = new Stair(i / N, i % N, arr[i / N][i % N]);
                    }
                }
            }
            pqStair1 = new PriorityQueue<>();
            pqStair2 = new PriorityQueue<>();
            findStair();
        }
    }

    public static void findStair() {
        // 현재 사람들의 위치를 기준으로 어느 계단에 가까운지 확인
        for(int i = 0; i < list.size(); i++) {
            int dir1 = Math.abs(list.get(i).r - stair1.r) + Math.abs(list.get(i).c - stair1.c);
            int dir2 = Math.abs(list.get(i).r - stair2.r) + Math.abs(list.get(i).c - stair2.c);

            if(dir1 < dir2) {           // 계단 1이 더 가까우면
                list.get(i).d = dir1;
                pqStair1.offer(list.get(i));
            } else if (dir2 < dir1) {   // 계단 2가 더 가까우면
                list.get(i).d = dir2;
                pqStair2.offer(list.get(i));
            } else {                    // 거리가 같을 때
                if(stair1.depth < stair2.depth) {   // 1번 계단이 짧으면 1번 큐에 넣음
                    list.get(i).d = dir1;
                    pqStair1.offer(list.get(i));
                } else {                            // 2번 계단이 짧으면 2번 큐에 넣음
                    list.get(i).d = dir2;
                    pqStair2.offer(list.get(i));
                }
            }
        }

        // 다 찾으면 출발
        int time = 0;
        while (!pqStair1.isEmpty() && !pqStair2.isEmpty()) {
            Point current1 = pqStair1.poll();   // 1번 계단으로 거리가 가장 가까운 사람부터 출발
            Point current2 = pqStair2.poll();   // 1번 계단으로 거리가 가장 가까운 사람부터 출발


        }
    }
}
