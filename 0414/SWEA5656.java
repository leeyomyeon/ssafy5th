import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int N, C, R;
    static int[][] arr;
    static int[] selected;
    static int min;
    static int[][] tmpArr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            arr = new int[R][C];
            selected = new int[N];
            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            pwr(0);     // N가지 중복순열 만들기
            System.out.println("#" + tc + " " + min);
        }
    }

    public static void pwr(int cnt) {    // 중복 순열
        if(cnt == N) { // N개 뽑히면
            // 벽돌 부시기
            tmpArr = copyArr();
            int breakCnt = breakBrick(selected);    // 몇개 깼냐?
            min = Math.min(breakCnt, min);
            return;
        }

        for(int i = 0; i < C; i++) {
            selected[cnt] = i;
            pwr(cnt + 1);
        }
    }

    static int breakBrick(int[] sel) {
        int breakCount = 0;
        for(int i = 0; i < sel.length; i++) {
            // sel 배열에 선택된 열의 순서만큼 블록을 부심
            int chk = -1;
            for(int j = 0; j < R; j++) {
                if(tmpArr[j][sel[i]] != 0) {  // 블록이 있으면(1 이상이면 부셔)
                    chk = tmpArr[j][sel[i]];
                    execute(j, sel[i]);
                    break;
                }
            }
            if(chk == 1) {
                continue;
            }
            // 부셨으면 다 내려(R은 맨 아래부터 함)
            // 맨 왼쪽 아래부터 위로 해서 맨 오른쪽까지 함

            for (int k = 0; k < C; k++) {
                LinkedList<Integer> brickList = new LinkedList<>();
                for (int j = R - 1; j >= 0; j--) {    // 열 하나 검사해서 남은 블록들만 ArrayList에 넣고
                    if (tmpArr[j][k] != 0) {
                        brickList.add(tmpArr[j][k]);
                        tmpArr[j][k] = 0;
                    }
                }
                int s = brickList.size();
                for (int j = R - 1; j >= R - s; j--) {
                    tmpArr[j][k] = brickList.removeFirst();
                }
            }
        }

        for(int i = 0; i < R; i++){        // 남은 블록의 합 구하기
            for (int j = 0; j < C; j++) {
                if (tmpArr[i][j] >= 1) {
                    breakCount++;
                }
            }
        }
        return breakCount;
    }

    static void execute(int r, int c) {
        if(r < 0 || c < 0 || r >= R || c >= C) {    // 맵 밖 벗어나면 통과
            return;
        }
        int spread = tmpArr[r][c];
        tmpArr[r][c] = 0;
        // 블록에 적힌 숫자 - 1만큼 3방향 으로 뻗어나감
        for(int i = 1; i < spread; i++) {
            execute(r - i, c);
            execute(r + i, c);
            execute(r, c + i);
            execute(r , c - i);
        }
    }

    static int[][] copyArr() {  // 배열 깊은 복사
        int[][] tmp = new int[R][C];
        for(int i = 0; i < R; i++) {
            System.arraycopy(arr[i], 0, tmp[i], 0, C);
        }
        return tmp;
    }
}
