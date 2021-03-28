import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LineTest3 {
    public static void main(String[] args) {
        String program = "line";
        String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
        String[] commands = {"line -n 100 -s hi -e", "lien -s Bye"};
        String[] com = {"line -s 123 -n HI", "line fun"};
        System.out.println(Arrays.toString(solution(program,flag_rules,commands)));
        System.out.println(Arrays.toString(solution(program,flag_rules,com)));
    }
    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        ArrayList<Boolean> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < flag_rules.length; i++) {
            String[] f = flag_rules[i].split(" ");
            map.put(f[0], f[1]);
        }

        for(String c : commands) {
            String str[] = c.split(" ");

            boolean isOK = true;
            if(!str[0].equals(program)) {
                list.add(false);
                continue;
            }

            int idx = 1;
            while(idx < str.length) {
                if(str[idx].equals("-s")) {
                    if(!str[idx+1].matches(".*[A-Za-z].*")) {
                        list.add(false);
                        isOK = false;
                        break;
                    }
                    idx += 2;
                } else if (str[idx].equals("-n")) {
                    if(!str[idx+1].matches(".*[0-9].*")) {
                        list.add(false);
                        isOK = false;
                        break;
                    }
                    idx += 2;
                } else if (str[idx].equals("-e")) {
                    idx += 1;
                } else {
                    isOK = false;
                    list.add(false);
                    break;
                }
            }
            if(isOK) {
                list.add(true);
            }
        }
        boolean[] answer = new boolean[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
