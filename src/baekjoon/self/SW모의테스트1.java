package baekjoon.self;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
#1 6 4
#2 3 7
#3 11 5
#4 17 12
#5 30 26
#6 55 49
#7 115 141
#8 239 238
#9 283 286
#10 272 296
 */
public class SW모의테스트1 { // 블럭 하강
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        FileInputStream fs = new FileInputStream("/Users/iyomyeon/Downloads/swtext.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for(int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            위에서아래로();
            왼쪽에서오른쪽으로();
            // 다 되면 맨아래 맨오른쪽 갯수셈

            // 맨 아래
            int ans1 = 0;
            int ans2 = 0;
            for(int i =0; i < N; i++) {
                if(arr[N - 1][i] == 1) {
                    ans1++;
                }
                if(arr[i][N - 1] == 1) {
                    ans2++;
                }
            }
            System.out.println("#" + tc + " " + ans1 + " " + ans2);
        }
    }

    public static void 위에서아래로() {
        for(int j = 0; j < N; j++) {    // 맨 위 가로행 검사
            if(arr[0][j] == 0 || arr[1][j] == 1) {  // 시작칸에 블록이 없거나 시작칸 다음칸에 블록이 있으면 해당 열 건너뜀
                continue;
            } // 아니면 해당 열 검사함

            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            arr[0][j] = 0;
            // 다 내려가면 쌓기위해 첫번째 블록을 스택에 넣고 해당 칸을 비워둠
            double weight = 1.9;    // 한칸 내려가있다고 가정하고 1.9를 곱해줌
            int c = 1;              // 그리고 현재 위치를 기억해둠
            // 그리고 다음칸부터 1이 어디에 있는지 찾음
            while(true) {
                if(c == N - 1) {
                    // 바닥에 닿으면 바닥 칸부터
                    int size = stack.size();
                    for(int k = 0; k < size; k++) {
                        arr[c - k][j] = stack.pop();
                    }
                    break;
                }
                if(arr[c + 1][j] == 1) {    // 다음칸에 1이 있으면
                    int cnt = 1;
                    for (int i = c + 1; i < N - 1; i++) {   // 1이 얼마나 있는지 검사함
                        if(arr[i][j] == arr[i + 1][j]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }   // 1의 개수 전부 센다
                    if(weight > cnt) { // 현재 무게가 블록의 무게보다 크면
                        weight += cnt;    // 블록의 무게만큼 더함
                        c += cnt;         // 그리고 현재 위치에서 블록 칸수 만큼 올리고
                        for(int k = 0; k < cnt; k++) {
                            arr[c - k][j] = 0;     // 블록을 0으로 만들고
                            stack.push(1);      // 블록 개수만큼 스택에 넣는다
                        }
                    } else {    // 못 내려가면
                        // 현재 위치에서부터
                        int size = stack.size();
                        for(int k = 0; k < size; k++) {
                            arr[c - k][j] = stack.pop();
                        }
                        break;
                    }
                } else { // 없으면 현재 위치를 한칸 내리고 무게를 곱함
                    weight *= 1.9;
                    c++;
                }
            }
        }
    }

    public static void 왼쪽에서오른쪽으로() {
        for(int j = 0; j < N; j++) {    // 맨 왼쪽 세로열 검사
            if(arr[j][0] == 0 || arr[j][1] == 1) {  // 시작칸에 블록이 없거나 시작칸 다음칸에 블록이 있으면 해당 열 건너뜀
                continue;
            } // 아니면 해당 열 검사함

            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            arr[j][0] = 0;
            // 다 내려가면 쌓기위해 첫번째 블록을 스택에 넣고 해당 칸을 비워둠
            double weight = 1.9;    // 한칸 내려가있다고 가정하고 1.9를 곱해줌
            int c = 1;              // 그리고 현재 위치를 기억해둠
            // 그리고 다음칸부터 1이 어디에 있는지 찾음
            while(true) {
                if(c == N - 1) {
                    // 바닥에 닿으면 바닥 칸부터
                    int size = stack.size();
                    for(int k = 0; k < size; k++) {
                        arr[j][c - k] = stack.pop();
                    }
                    break;
                }
                if(arr[j][c + 1] == 1) {    // 다음칸에 1이 있으면
                    int cnt = 1;
                    for (int i = c + 1; i < N - 1; i++) {   // 1이 얼마나 있는지 검사함
                        if(arr[j][i] == arr[j][i + 1]) {
                            cnt++;
                        } else {
                            break;
                        }
                    }   // 1의 개수 전부 센다
                    if(weight > cnt) { // 현재 무게가 블록의 무게보다 크면
                        weight += cnt;    // 블록의 무게만큼 더함
                        c += cnt;         // 그리고 현재 위치에서 블록 칸수 만큼 올리고
                        for(int k = 0; k < cnt; k++) {
                            arr[j][c - k] = 0;     // 블록을 0으로 만들고
                            stack.push(1);      // 블록 개수만큼 스택에 넣는다
                        }
                    } else {    // 못 내려가면
                        // 현재 위치에서부터
                        int size = stack.size();
                        for(int k = 0; k < size; k++) {
                            arr[j][c - k] = stack.pop();
                        }
                        break;
                    }
                } else { // 없으면 현재 위치를 한칸 내리고 무게를 곱함
                    weight *= 1.9;
                    c++;
                }
            }
        }
    }
}
