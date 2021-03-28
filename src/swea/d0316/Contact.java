package swea.d0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            boolean[][] arr = new boolean[101][101];
            boolean[] visited = new boolean[101];

            Node[] adjList = new Node[len];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < len/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            while(!queue.isEmpty()) {
                int next = queue.poll();
                for(int j = 0; j < arr.length; j++) {
                    for(int k = arr.length; k >= 0; k--){

                    }
                    if(arr[next][j] && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                        if(j > answer) {
                            answer = j;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
