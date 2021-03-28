package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int [][] adjMatrix = new int [N][N];
        boolean [] visited = new boolean[N];
        int[] minEdge = new int [N];    // 신장트리에 연결된 정점에서 자신으로의 최소간선비용

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0;
        minEdge[0] = 0; // 0을 시작 정점으로 처리하기 위해 0으로 세팅

        for (int c = 0; c < N; c++) {

            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            // 신장 트리에 연결되지 않은 정점 중 minEdge 비율이 최소인 정점
            for (int i = 0; i < N; i++) {
                if(!visited[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            result += min;
            visited[minVertex] = true;

            for (int i = 0; i < N; i++) {
                if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }

        System.out.println(result);
    }
}