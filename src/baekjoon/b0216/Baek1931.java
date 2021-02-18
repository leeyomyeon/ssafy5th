package baekjoon.b0216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baek1931 {
    public static class meet implements Comparable<meet> {
        int startTime;
        int endTime;

        meet(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(meet o) {
            if(endTime - o.endTime == 0) {
                return startTime - o.startTime;
            }
            return endTime - o.endTime;
        }
    }

    public static meet[] meets;
    static ArrayList<meet> selectMeet;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        meets = new meet[n];


        for(int i = 0; i < n; i++) {
            meets[i] = new meet(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(meets);

        int count = 0;
        int max = 0;

        selectMeet = new ArrayList<>();
        selectMeet.add(new meet(0, 0));

        for (meet meet : meets) {
            if (selectMeet.get(selectMeet.size() - 1).endTime <= meet.startTime) {
                selectMeet.add(meet);
            }

            count = selectMeet.size() - 1;

            if (count > max) {
                max = count;
            }
        }

        System.out.println(max);
    }


}
