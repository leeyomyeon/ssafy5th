package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    private char[] nodes;
    private int lastIndex;
    private final int SIZE;

    public CompleteBinaryTree(int size) {
        super();
        SIZE = size;
        nodes = new char[size + 1];
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(char e) {
        if(isFull()) {
            System.out.println("포화상태입니다.");
        }
        nodes[++lastIndex] = e;
    }

    public void bfs() {
        if(isEmpty()) {
            return;
        }

        // 탐색 순서 인덱스를 관리함.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int current, size, level = 0;

        while(!queue.isEmpty()) {

            size = queue.size();
            System.out.print("Level " + level + " : ");

            while (--size >= 0) {
                current = queue.poll();
                System.out.print(nodes[current] + " ");

                if(current * 2 <= lastIndex) {
                    queue.offer(current * 2);
                }
                if(current * 2 + 1 <= lastIndex) {
                    queue.offer(current * 2 + 1);
                }
            }
            System.out.println();
            level++;
        }

    }

}
