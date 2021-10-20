package study.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {
    public static int N, C;
    public static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());   // 암호문 길이
        C = Integer.parseInt(st.nextToken());   // 입력된 문자열의 수
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        // N개를 뽑아야됨
        combination(0, 0, 0, 0, "");
    }

    // 최소 한개의 모음과 두개의 자음이 들어가야 한다.
    public static void combination(int cnt, int idx,int 자음, int 모음, String str) {
        if(cnt == N) {
            if(자음 >= 2 && 모음 >= 1) {
                System.out.println(str);
            }
            return;
        }
        if(idx == C) {
            return;
        }
        boolean check = (arr[idx] == 'a' || arr[idx] == 'e' || arr[idx] == 'i' || arr[idx] == 'o' || arr[idx] == 'u');

        if(check) {
            combination(cnt + 1, idx + 1,자음, 모음 + 1, str + arr[idx]);
        } else {
            combination(cnt + 1, idx + 1, 자음 + 1, 모음, str + arr[idx]);
        }

        combination(cnt, idx + 1, 자음, 모음, str);
    }
}
/*
4 6
a t c i s w
*/
/* a c i t s w
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
 */