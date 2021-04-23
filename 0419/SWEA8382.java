import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8382 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int a = Math.abs(x2 - x1) + Math.abs(y2 - y1);
            int c = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            if(a % 2 == 0) {
                System.out.println("#" + tc + " " + (c * 2));
            } else {
                System.out.println("#" + tc + " " + ((c * 2) - 1));
            }
        }
    }
}
