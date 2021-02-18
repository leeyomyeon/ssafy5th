package com.ssafy.subset;

import java.util.Stack;

public class S3_StackAPITest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("최지우");
        stack.push("고소영");
        stack.push("전지현");

        System.out.println(stack.isEmpty()+"//"+stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty()+"//"+stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty()+"//"+stack.size());
        System.out.println(stack.pop());
    }
}
