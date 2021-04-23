package swea.d0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA9760 {
    static int[][] card;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            card = new int[5][2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 5; i++) {
                String str = st.nextToken();
                for(int j = 0; j < 2; j++) {
                    char c = str.charAt(j);
                    if(c == 'A') {
                        card[i][j] = 1;
                    } else if (c == 'T') {
                        card[i][j] = 10;
                    } else if (c == 'J') {
                        card[i][j] = 11;
                    } else if (c == 'Q') {
                        card[i][j] = 12;
                    } else if (c == 'K') {
                        card[i][j] = 13;
                    } else {
                        card[i][j] = c - '0';
                    }
                }
            }
            Arrays.sort(card, Comparator.comparingInt(o -> o[1]));
            System.out.println("#" + tc + " " + poker());
        }
    }

    public static String poker() {
        if(straightFlush()) {
            return "1. StraightFlush";
        } else if (fourOfaKind()) {
            return "2. Four of a Kind";
        } else if (fullHouse()) {
            return "3. Full House";
        } else if (flush()) {
            return "4. Flush";
        } else if (straight()) {
            return "5. Straight";
        } else if (threeOfaKind()) {
            return "6. Three of a kind";
        } else if (twoPair()) {
            return "7. Two Pair";
        } else if (onePair()) {
            return "8. One Pair";
        } else {
            return "9. High card";
        }
    }

    private static boolean straightFlush() {
        for(int i = 0; i < 4; i++) {
            if(card[i][0] != card[i + 1][0]) {
                return false;
            }
        }
        for(int i = 0; i < 4; i++) {
            if (card[0][i] + 1 != card[0][i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean fourOfaKind() {
        return true;
    }

    private static boolean fullHouse() {
        return true;
    }
    private static boolean flush() {
        return true;
    }
    private static boolean straight() {
        return true;
    }
    private static boolean threeOfaKind() {
        return true;
    }
    private static boolean twoPair() {
        return true;
    }
    private static boolean onePair() {
        return true;
    }
}
