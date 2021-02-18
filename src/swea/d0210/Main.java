package swea.d0210;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String testCase = sc.next();
        int T = Integer.parseInt(testCase);
        String solve[] = new String[T];
        for(int i = 0; i < T; i++) {
            int count = 0;
            char bit = '0';
            String memory = sc.next();
            for(int j = 0; j < memory.length(); j++) {
                if((memory.charAt(j) != bit) && bit == '1') {
                    count++;
                    bit = '0';
                } else if ((memory.charAt(j) != bit) && bit == '0') {
                    count++;
                    bit = '1';
                }
            }
            solve[i] = "#"+Integer.toString(i+1)+" "+Integer.toString(count);
        }
        for(String k : solve) {
            System.out.println(k);
        }
        sc.close();
    }
}