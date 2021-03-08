package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek14891 {
    static ArrayList<LinkedList<Integer>> gear;
    static int[] rotationGear;
    static int k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gear = new ArrayList<>();

        gear.add(new LinkedList<>());
        for(int i = 1; i <= 4; i++) {
            String str = br.readLine();
            gear.add(new LinkedList<>());
            for(int j = 0; j < 8; j++) {
                gear.get(i).add(str.charAt(j) - '0');
            }
        }
        gear.add(new LinkedList<>());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++) {
            rotationGear = new int[6];
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            rotationGear[index] = direction;
            leftRotation(index, direction);
            rightRotation(index, direction);
            rotate();
        }

        int sum = 0;
        for(int i = 1; i <= 4; i++) {
            int k = gear.get(i).get(0) << (i-1);
            sum += k;
        }
        System.out.println(sum);
    }

    public static void leftRotation(int idx, int dir) {
        if(idx == 1) {
            return;
        }

        if(!gear.get(idx).get(6).equals(gear.get(idx - 1).get(2))) {  // 왼쪽 회전 가능?
            rotationGear[idx - 1] = dir * -1;
            leftRotation(idx - 1, dir * -1);
        } else {
            rotationGear[idx-1] = 0;
            return;
        }

    }
    public static void rightRotation(int idx, int dir) {
        if(idx == 4) {
            return;
        }
        if(!gear.get(idx).get(2).equals(gear.get(idx + 1).get(6))) {    // 오른쪽 회전 가능?
            rotationGear[idx + 1] = dir * -1;
            rightRotation(idx + 1, dir * -1);
        } else {
            rotationGear[idx + 1] = 0;
            return;
        }
    }

    public static void rotate() {
        for(int i = 1; i <= 4; i++) {
            if(rotationGear[i] == -1) { // 반시계일때
                int k = gear.get(i).pollFirst();
                gear.get(i).addLast(k);
            } else if (rotationGear[i] == 1) {  // 시계일때
                int k = gear.get(i).pollLast();
                gear.get(i).addFirst(k);
            }
        }
    }

}
