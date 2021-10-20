package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek2607 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> compareMap;

        String[] str = new String[N];

        for(int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        char c = 'A';
        for(int i = 0; i < 26; i++) {
            map.put(c, 0);
            c++;
        }

        for(int i = 0; i < str[0].length(); i++) {
            c = str[0].charAt(i);
            map.replace(c, map.get(c) + 1);
        }

        int count = 0;

        for(int i = 1; i < N; i++) {
            compareMap = new HashMap<>();
            c = 'A';
            for(int k = 0; k < 26; k++) {
                compareMap.put(c, 0);
                c++;
            }

            for(int j = 0; j < str[i].length(); j++) {
                c = str[i].charAt(j);
                compareMap.replace(c, compareMap.get(c) + 1);
            }
            // 여기서 비교
            int p, q, diff = 0;
            int lenA = 0, lenB = 0;
            for(char cc = 'A'; cc <= 'Z'; cc++) {
                lenA += (p = map.get(cc));
                lenB += (q = compareMap.get(cc));
                diff += Math.abs(p - q);
            }
            if(diff <= 2 && Math.abs(lenA - lenB) <= 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
