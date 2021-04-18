import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2564 {
    public static class Shop {
        int direction;      // 1 북 2 남 3 서 4 동 방향
        int distance;       // 거리

        public Shop(int direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }
    public static Shop[] shops;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 세로 길이
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        // N개의 상점 만들기
        int N = Integer.parseInt(br.readLine());
        shops = new Shop[N];

        int len = (width + height) * 2; // 사각형을 하나의 직선으로 봄

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            if(dir == 1) {
                dis = width - dis;
            } else if(dir == 2) {
                dis += width + height;
            } else if (dir == 3) {
                dis += width;
            } else if (dir == 4) {
                dis = len - dis;
            }
            shops[i] = new Shop(dir, dis);
        }

        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());
        if(dir == 1) {
            dis = width - dis;
        } else if(dir == 2) {
            dis += width + height;
        } else if (dir == 3) {
            dis += width;
        } else if (dir == 4) {
            dis = len - dis;
        }
        Shop user = new Shop(dir, dis);

        int sum = 0;

        for(int i = 0; i < N; i++) {    // 상점 순회
            int a = Math.abs(user.distance - shops[i].distance);
            int b;
            if(user.distance <= shops[i].distance) {
                b = Math.abs(len - shops[i].distance + user.distance);
            } else {
                b = Math.abs(len - user.distance + shops[i].distance);
            }
            sum += Math.min(a, b);
        }

        System.out.println(sum);
    }
}
/*
2 2
4
1 1
2 1
3 1
4 1
1 1
 */