package com.ssafy.sort;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Student> pQueue = new PriorityQueue<Student>();

        pQueue.add(new Student(4, 20));
        pQueue.add(new Student(3, 50));
        pQueue.add(new Student(1, 60));

        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
    }
}
