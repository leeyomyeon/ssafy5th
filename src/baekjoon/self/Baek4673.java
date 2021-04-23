package baekjoon.self;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek4673 {
    static StringTokenizer st;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        for(int i = 1; i <= 10000; i++) {
            list.add(i);
        }
        for(int i = 10000; i >= 1; i--) {
            String str = Integer.toString(i);
            int num = i;
            for(int j = 0; j < str.length(); j++) {
                num += (str.charAt(j) - '0');
            }
            list.remove((Object) num);
        }
        for(int k : list) {
            System.out.println(k);
        }
    }
}
