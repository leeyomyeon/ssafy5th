package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12865 {
    static int N, K;
    static Stuff[] list;
    static int[][] bag;
    static class Stuff {
        int weight;
        int value;

        public Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bag = new int[N + 1][K + 1];
        list = new Stuff[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                if(list[i].weight <= j) {
                    bag[i][j] = Math.max(bag[i - 1][j - list[i].weight] + list[i].value, bag[i - 1][j]);
                } else {
                    bag[i][j] = bag[i - 1][j];
                }
            }
        }

        System.out.println(bag[N][K]);
    }
}
