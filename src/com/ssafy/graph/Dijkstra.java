package com.ssafy.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] adj = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                adj[i][j] = scanner.nextInt();
            }
        }

        int[] D = new int[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            D[i] = 999;
        }
        D[0] = 0;
        for(int i = 0; i < N; i++) {
            int minIdx = 0;
            int min = 999;

            for(int j = 0; j < N; j++) {
                if(!visited[j] && D[j] < min) {
                    min = D[j];
                    minIdx = j;
                }
            }

            visited[minIdx] = true;

            for(int j = 0; j < N; j++) {
                if(!visited[j] && adj[minIdx][j] != 0 && D[minIdx] + adj[minIdx][j] < D[j]) {
                    D[j] = D[minIdx] + adj[minIdx][j];
                }
            }
        }

        System.out.println(Arrays.toString(D));

    }
}
