import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
    static int[][] arr = new int[10][10];
    static int[] color = {0, 5, 5, 5, 5, 5};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(0);

    }

    public static void dfs(int count) {
        int sP = -1, sQ = -1;
        Loop1:
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(arr[i][j] == 1) {
                    sP = i;
                    sQ = j;
                    break Loop1;
                }
            }
        }

        if(sP == -1 && sQ == -1) {
            answer = Math.min(answer, count);
            return;
        }
        int size = 5;
        while(size > 0) {
            boolean isOK = true;

            Loop2:
            for(int i = size; i >= 1; i--) {
                for(int j = size; j >= 1; j--) {
                    if(sP + i >= 10 || sQ + i >= 10 || arr[sP + i][sQ + j] == 0) {
                        isOK = false;
                        break Loop2;
                    }
                }
            }

            if(isOK) {
                break;
            }
            size--;
        }

        for(int i = 1; i <= size; i++) {
            if(color[i] == 0) {
                continue;
            }

            for(int j = sP; j < sP + size; j++) {
                for(int k = sQ; k < sQ + size; k++) {
                    arr[j][k] = 0;
                }
            }
            color[i]--;
            dfs(++count);

            for(int j = sP; j < sP + size; j++) {
                for(int k = sQ; k < sQ + size; k++) {
                    arr[j][k] = 1;
                }
            }
            color[i]++;
        }
    }
}
