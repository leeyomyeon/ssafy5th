package baekjoon.b0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek16235 {
    public static int N, M, K;
    public static int[][] A;
    public static int[][] arr;
    public static PriorityQueue<Tree> treeList;
    public static Queue<Tree> aliveTree;
    public static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;        // 나무의 나이

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        public int compareTo(Tree o) {
            return age - o.age;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 땅의 크기
        M = Integer.parseInt(st.nextToken());   // 나무의 개수
        K = Integer.parseInt(st.nextToken());   // 지나가는 햇수

        A = new int[N][N];
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(arr[i], 5);
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        treeList = new PriorityQueue<>();
        aliveTree = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            treeList.add(new Tree(R - 1, C - 1, age));
        }

        System.out.println(TreeTech());
    }

    public static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int TreeTech() {
        int year = 1;
        while (year <= K) {
            // 봄
            Queue<Tree> deadTree = new LinkedList<>();
            while(!treeList.isEmpty()) {
                Tree t = treeList.poll();
                if(arr[t.r][t.c] - t.age < 0) {         // 양분이 부족하면 먹지 못하고 즉시 죽는다.
                    deadTree.add(t);
                    continue;
                }
                arr[t.r][t.c] -= t.age; // 자신의 나이만큼 양분을 먹고
                t.age++;
                aliveTree.offer(t);
            }

            // 여름
            while(!deadTree.isEmpty()) {
                Tree tree = deadTree.poll();
                arr[tree.r][tree.c] += tree.age / 2;
            }

            // 가을
            while(!aliveTree.isEmpty()) {
                Tree t = aliveTree.poll();
                if(t.age % 5 == 0) {
                    for(int d = 0; d < 8; d++) {
                        int nr = t.r + dr[d];
                        int nc = t.c + dc[d];
                        if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
                            treeList.offer(new Tree(nr, nc, 1));
                        }
                    }
                }
                treeList.offer(t);
            }

            // 겨울
            getIngrediant();
            year++;
        }
        return treeList.size();
    }

    public static void getIngrediant() {    // 겨울 되면 양분
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] += A[i][j];
            }
        }
    }
}
