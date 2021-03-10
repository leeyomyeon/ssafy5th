package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek20055 {
    public static LinkedList<Integer> belt; // 내구도
    public static LinkedList<Boolean> isOK; // 로봇이 있는가?
    public static int n;
    public static int k;
    public static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        count = 0;
        belt = new LinkedList<>();
        isOK = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n*2; i++) {
            belt.add(Integer.parseInt(st.nextToken()));
            isOK.add(false);
        }
        int count = 1;
        while(true) {
            rotate();
            move();
            putRobot();

            if(check() >= k) {
                System.out.println(count);
                break;
            }
            count++;
        }
    }

    public static void rotate() {  // 시계방향 회전
        belt.addFirst(belt.pollLast());
        isOK.addFirst(isOK.pollLast());

        isOK.set(n - 1, false);
    }

    public static void move() {
        for(int i = n - 2; i >= 0; i--) {
            if((!isOK.get(i + 1)) && (belt.get(i + 1) > 0) && isOK.get(i)) {
                isOK.set(i, false);
                isOK.set(i + 1, true);
                int p = belt.get(i + 1) - 1;
                belt.set(i + 1, p);
            }
            isOK.set(n - 1, false);
        }
    }

    public static void putRobot() {
        if(!isOK.get(0) && belt.get(0) > 0) {
            isOK.set(0, true);
            int p = belt.get(0) - 1;
            belt.set(0, p);
        }
    }

    public static int check() {
        int cnt = 0;
        for(int i = 0; i < 2 * n; i++) {
            if(belt.get(i) == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
