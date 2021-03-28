public class LineTest1 {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};
        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;
        for(int j = 0; j < table.length; j++) {
            String[] lan = table[j].split(" ");
            int sum = 0;

            for(int k = 1; k <lan.length; k++) {
                for(int i = 0; i < languages.length; i++) {
                    if(lan[k].equals(languages[i])) {
                        int score = preference[i] * (6 - k);
                        sum += score;
                    }
                }
            }
            if(sum > max) {
                max = sum;
                answer = lan[0];
            }
            if(sum == max && answer.compareTo(lan[0]) > 0) {
                answer = lan[0];
            }
        }
        return answer;
    }
}
