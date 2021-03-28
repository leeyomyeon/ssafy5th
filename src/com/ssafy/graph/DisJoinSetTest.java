package com.ssafy.graph;

public class DisJoinSetTest {
    static int N;
    static int[] parents;

    static void make() {
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }
    static int findSet(int a) {
        if(parents[a] == a) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) {

    }
}
