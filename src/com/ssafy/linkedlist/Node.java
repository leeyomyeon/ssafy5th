package com.ssafy.linkedlist;

public class Node {
    public String data;
    public Node link;

    public Node(String data) {
        super();
        this.data = data;
    }
    public Node(String data, Node link) {
        super();
        this.link = link;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", link=" + link +
                '}';
    }
}
