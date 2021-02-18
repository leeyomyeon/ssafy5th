import java.util.Scanner;
import java.util.Stack;

public class 계산기2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int n = scanner.nextInt();
            String str = scanner.next();

            String[] s = isPostfix(str).split("");
            Stack<String> number = new Stack<>();

            for(int i = 0; i < s.length; i++) {
                if(isNumber(s[i])) {
                    number.push(s[i]);
                } else {
                    if(s[i].equals("*")) {
                        int a = Integer.parseInt(number.pop());
                        int b = Integer.parseInt(number.pop());
                        number.push(Integer.toString(a * b));
                    } else if(s[i].equals("+")) {
                        int a = Integer.parseInt(number.pop());
                        int b = Integer.parseInt(number.pop());
                        number.push(Integer.toString(a + b));
                    }
                }

            }

            System.out.println("#" + tc + " " + number.elementAt(0));
        }
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static String isPostfix(String str) {
        StringBuilder sb = new StringBuilder();

        Stack<String> opr = new Stack<>();
        String[] s = str.split("");

        // 3 + 4 + 5 * 6 + 7 -> 34+56*+7+
        for(int i = 0; i < s.length; i++) {
            if(isNumber(s[i])) {
                sb.append(s[i]);
            } else {
                if (!s[i].equals("*")) {
                    while (!opr.isEmpty()) {
                        sb.append(opr.pop());
                    }
                }
                opr.push(s[i]);
            }
        }

        while(!opr.isEmpty()) {
            sb.append(opr.pop());
        }

        return sb.toString();
    }
}
