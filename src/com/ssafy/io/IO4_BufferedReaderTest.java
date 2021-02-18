package com.ssafy.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class IO4_BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++) {
            System.out.println(st.nextToken());
        }
    }
}
