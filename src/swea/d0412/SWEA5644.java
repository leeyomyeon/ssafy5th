package swea.d0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5644 {
    private static int M;
    private static int A;
    private static int[] moveA;
    private static int[] moveB;
    private static Battery[] batteries;
    private static int[] dx = {0, 0, 1, 0, -1};
    private static int[] dy = {0, -1, 0, 1, 0};
    private static int result;

    public static class User {
        int p;
        int q;
        public User(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
    public static class Battery {
        int x;
        int y;
        int cover;
        int perform;

        public Battery(int x, int y, int cover, int perform) {
            this.x = x;
            this.y = y;
            this.cover = cover;
            this.perform = perform;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            moveA = new int[M + 1];
            moveB = new int[M + 1];

            User userA = new User(1, 1);
            User userB = new User(10, 10);

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            batteries = new Battery[A];

            for(int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cover = Integer.parseInt(st.nextToken());
                int perform = Integer.parseInt(st.nextToken());
                batteries[i] = new Battery(x, y, cover, perform);
            }

            result = 0;

            for(int i = 0; i <= M; i++) {    // 유저 이동함
                // A 이동
                userA.p = userA.p + dx[moveA[i]];
                userA.q = userA.q + dy[moveA[i]];

                // B 이동
                userB.p = userB.p + dx[moveB[i]];
                userB.q = userB.q + dy[moveB[i]];

                // 이동했을때 현재 위치가 배터리에 닿는지?
                int max = 0;
                for(int j = 0; j < A; j++) {
                    for(int k = 0; k < A; k++) {
                        int sum = 0;
                        int disA = Math.abs(userA.p - batteries[j].x) + Math.abs(userA.q - batteries[j].y);
                        int disB = Math.abs(userB.p - batteries[k].x) + Math.abs(userB.q - batteries[k].y);
                        int maxA = 0;
                        int maxB = 0;

                        if (disA <= batteries[j].cover && maxA < batteries[j].perform) {
                            maxA = batteries[j].perform;
                        }
                        if (disB <= batteries[k].cover && maxB < batteries[k].perform) {
                            maxB = batteries[k].perform;
                        }

                        if(j != k) {
                            sum += (maxA + maxB);
                        } else {
                            sum += Math.max(maxA, maxB);
                        }

                        if(sum > max) {
                            max = sum;
                        }
                    }
                }
                result += max;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
