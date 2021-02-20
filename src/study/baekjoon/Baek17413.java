package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17413 {
    public static void main(String[] args) throws Exception {
        Queue<StringBuilder> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "\n");

        StringBuilder sb = new StringBuilder(st.nextToken());
        StringBuilder sb3 = new StringBuilder();
        int k = -1;
        int j = -1;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '<') {
                j = i;
            } else if (sb.charAt(i) == '>') {
                k = i;
            }
            if (j != -1 && k != -1) {
                queue.add(sb3);
                sb3 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sb.substring(j, k + 1));
                sb2.reverse();
                queue.add(sb2);
                j = -1;
                k = -1;
            } else if (j == -1 && k == -1) {
                sb3.append(sb.charAt(i));
            } else if (sb.charAt(i) == ' ') {
                queue.add(sb3);
                sb3 = new StringBuilder();
            }
        }

        queue.add(sb3);
        sb3 = new StringBuilder();
        while(!queue.isEmpty()) {
            if(queue.peek().equals("")) {
                queue.poll();
                continue;
            }
            if(queue.peek().indexOf("<") < 0) {
                String[] str = queue.poll().toString().split(" ");
                for(int i = 0; i < str.length; i++) {
                    StringBuilder tsb = new StringBuilder(str[i]);
                    sb3.append(tsb.reverse()).append(" ");
                }
                sb3.deleteCharAt(sb3.length()-1);
            } else {
                sb3.append(queue.poll().reverse());
            }
        }
        System.out.println(sb3.toString());
    }
}
