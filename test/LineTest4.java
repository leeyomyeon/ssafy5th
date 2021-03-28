import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LineTest4 {
    public static void main(String[] args) {
        String program = "line";
        String[] flag_rules = {"-s STRINGS", "-n NUMBERS", "-e NULL"};
        String[] commands = {"line -n 100 102 -s hi -e", "line -n id pwd -n 100"};
        System.out.println(Arrays.toString(solution(program,flag_rules,commands)));
        program = "trip";
        flag_rules = new String[]{"-days NUMBERS", "-dest STRING"};
        commands = new String[]{"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"};
        System.out.println(Arrays.toString(solution(program,flag_rules,commands)));
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
            if (!str[0].equals(program)) {
                list.add(false);
                continue;
            }

            int idx = 1;

            Loop1:
            while(idx < str.length) {   // line -n 100 102 -s hi -e", "line -n id pwd -n 100
                if(str[idx].contains("-")) {    // 명령어이고
                    if (map.get(str[idx]).equals("NULL")) {  // 단독 명령어인경우
                        idx++;
                        continue;
                    }
                    int num = 1;    // 명령어가 적용된 갯수
                    while(!str[idx + num].contains("-")) {    // 다음 명령어가 나올 때 까지 반복
                        if (map.get(str[idx]).equals("NUMBER")) { // 명령어가 숫자만 사용되는 경우
                            if(!str[idx+num].matches(".*[0-9].*") || num >= 2) { // 한개만 사용되야함
                                list.add(false);
                                isOK = false;
                                break Loop1;
                            }
                        } else if (map.get(str[idx]).equals("NUMBERS")) { // 명령어가 숫자들인경우
                            if(!str[idx+num].matches(".*[0-9].*")) {
                                list.add(false);
                                isOK = false;
                                break Loop1;
                            }
                        } else if(map.get(str[idx]).equals("STRINGS")) { // 명령어가 문자열들인경우
                            if(!str[idx+num].matches(".*[A-Za-z].*")) {   // 인데 문자열이 아닌경우
                                list.add(false);
                                isOK = false;
                                break Loop1;
                            }
                        } else if (map.get(str[idx]).equals("STRING")) { // 명령어가 문자열만 사용되는 경우
                            if(!str[idx+num].matches(".*[A-Za-z].*") || num >= 2) {   // 인데 문자열이 아닌경우
                                list.add(false);
                                isOK = false;
                                break Loop1;
                            }
                        }
                        num++;
                        if(idx+num >= str.length) {
                            break Loop1;
                        }
                    }
                    idx += num;
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
