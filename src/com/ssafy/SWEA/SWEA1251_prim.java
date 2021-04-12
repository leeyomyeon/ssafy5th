package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1251_prim {
    private static int N;
    private static long[][] adjMatrix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            adjMatrix = new long[N][N];
            int x[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            } // X 좌표

            int y[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            } // Y 좌표

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j) {
                        continue;
                    }
                    adjMatrix[j][i] = adjMatrix[i][j] = getDistance(x[i], x[j], y[i], y[j]);
                }
            }

            double E = Double.parseDouble(br.readLine());

            System.out.println("#" + tc + " " + Math.round(makeMST() * E));
        }
    }
    private static double makeMST() {
        long[] minEdge = new long[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(minEdge, Long.MAX_VALUE);

        minEdge[0] = 0;

        long result = 0;    // 최소 신장 트리 비용
        int cnt = 0;        // 정점 개수

        while (true) {  // 시간복잡도 = N제곱
            // 신장 트리에 포함되지 않은 정점 중 최소 간선비용의 정점 선택
            long min = Long.MAX_VALUE;
            int minNo = 0;

            for(int i = 0; i < N; i++) {
                if(!visited[i] && min > minEdge[i]) {
                    minNo = i;
                    min = minEdge[i];
                }
            }

            // 신장트리에 포함시킴
            visited[minNo] = true;
            result += min;

            if(++cnt == N) {
                break;
            }

            for(int i = 0; i < N; i++) {
                // 아직 방문하지 않았고
                if(!visited[i] && minEdge[i] > adjMatrix[minNo][i]) {
                    minEdge[i] = adjMatrix[minNo][i];
                }
            }
        }

        return result;
    }

    private static long getDistance(int x1, int x2, int y1, int y2) {
        return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
