import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1251 {
    public static class Island implements Comparable<Island> {
        int idx;
        long cost;
        public Island(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Island o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    public static int n;
    public static double E;
    public static List<Integer> xList;
    public static List<Integer> yList;
    public static boolean[] selected;
    public static long[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());

            selected = new boolean[n];
            StringTokenizer stX = new StringTokenizer(br.readLine());
            StringTokenizer stY = new StringTokenizer(br.readLine());

            xList = new ArrayList<>();
            yList = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                xList.add(Integer.parseInt(stX.nextToken()));
                yList.add(Integer.parseInt(stY.nextToken()));
            }

            E = Double.parseDouble(br.readLine());

            // 인접행렬
            arr = new long[n][n];

            // 모든 두 점 사이의 거리 계산
            for(int i = 0; i < n; i++) {
                long x1 = xList.get(i);
                long y1 = yList.get(i);

                for(int j = i + 1; j < n; j++) {
                    long x2 = xList.get(j);
                    long y2 = yList.get(j);

                    // 두 점 사이의 거리 계산해서 인접행렬에 저장
                    // (x2 - x1)^2 + (y2 - y1)^2
                    arr[i][j] = arr[j][i] = (long) (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
                }
            }

            double cost = Prim(0) * E;
            int min = Integer.MAX_VALUE;

            System.out.println("#"+tc+" "+Math.round(cost));
        }
    }
    public static double Prim(int start) {
        //to do something

        return 1.0;
    }
}

