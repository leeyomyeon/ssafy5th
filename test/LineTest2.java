import java.util.*;
import java.util.regex.Pattern;

public class LineTest2 {
    public static void main(String[] args) {
        String[] inpStr = {"AaTa+!12-3", "aaaaZZZZ)", "CaCbCgCdC888834A", "UUUUU", "ZzZz9Z824"};
        for(String s : inpStr) {
            System.out.println(Arrays.toString(solution(s)));
        }
    }
    public static int[] solution(String inp_str) {
        ArrayList<Integer> list = new ArrayList<>();

        int num2 = 0;
        if(inp_str.length() < 8 || inp_str.length() > 15) {
            list.add(1);
        }

        boolean match0 = Pattern.matches(".*[A-Za-z0-9~!@#[$]%\\^&[*]].*", inp_str);

        if(!match0) {
            list.add(2);
        }

        boolean match1 = Pattern.matches(".*[A-Z].*", inp_str); // 대문자 있을시
        boolean match2 = Pattern.matches(".*[a-z].*", inp_str); // 소문자 있을시
        boolean match3 = Pattern.matches(".*[0-9].*", inp_str); // 숫자 있을시
        boolean match4 = Pattern.matches(".*~!@#[$]%\\^&[*].*", inp_str); // 특수문자 있을시

        if(match1) {
            num2++;
        }
        if(match2) {
            num2++;
        }
        if(match3) {
            num2++;
        }
        if(match4) {
            num2++;
        }
        if(num2 < 3) {
            list.add(3);
        }

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(inp_str);
        for(int i = 0; i < sb.length(); i++) {
            set.add(sb.substring(i, i+1));
        }

        Iterator<String> iter = set.iterator();

        Loop2:
        while (iter.hasNext()) {
            String compare = iter.next();
            for(int i = 0; i < inp_str.length() - 4; i++) {
                boolean cond1 = compare.equals(sb.substring(i, i + 1));
                boolean cond2 = compare.equals(sb.substring(i + 1, i + 2));
                boolean cond3 = compare.equals(sb.substring(i + 2, i + 3));
                boolean cond4 = compare.equals(sb.substring(i + 3, i + 4));
                if(cond1 && cond2 && cond3 && cond4) {
                    list.add(4);
                    break Loop2;
                }
            }
        }

        iter = set.iterator();
        Loop1:
        while (iter.hasNext()) {
            String compare = iter.next();
            int num5 = 0;
            for(int i = 0; i < inp_str.length(); i++) {
                if(compare.equals(sb.substring(i, i+1))) {
                    num5++;
                }
                if(num5 >= 5) {
                    list.add(5);
                    break Loop1;
                }
            }
        }
        if(list.size() == 0) {
            list.add(0);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
