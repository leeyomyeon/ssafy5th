import java.util.ArrayList;
import java.util.Scanner;

public class AlgoTest {
    // 문자열 비교를 위한 배열, 인덱스 값과 문자열 값이 일치
    public static String[] engNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static class English implements Comparable<English>{
        String str1;	// 십의자리수 문자열 저장
        int num1;		// 십의자리수 숫자 저장
        String str2;	// 일의자리수 문자열 저장
        int num2;		// 일의자리수 숫자 저장
        English(String str1, String str2, int num1, int num2) {
            this.str1 = str1;
            this.str2 = str2;
            this.num1 = num1;
            this.num2 = num2;
        }

        public int compareTo(English o) {
            if (this.str1.compareTo(o.str1) >= 1) {	// 십의 자리 문자열 비교
                return 1;
            } else if (this.str1.compareTo(o.str1) == 0 && this.str2.compareTo(o.str2) >= 1) {
                return 0;	// 십의 자리 문자열이 같으면 일의 자리 문자열을 비교
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();				// 시작 숫자
        int N = scanner.nextInt();				// 끝 숫자
        ArrayList<English> list = new ArrayList<>();	// 객체를 담을 리스트

        for(int i = M; i <= N; i++) {			// 시작 수 부터 끝 수 까지
            int ten = i / 10;					// 십의 자리 숫자
            int one = i % 10;					// 일의 자리 숫자
            StringBuilder sbt = new StringBuilder("");	// 십의 자리 숫자 문자열 변환
            StringBuilder sbo = new StringBuilder("");	// 일의 자리 숫자 문자열 변환
            if(ten >= 1) {
                sbt.append(engNum[ten]);		// 십의 자리 숫자가 있으면 배열에서 가져옴
            } else {
                sbt.append("");					// 없으면 공백
            }
            sbo.append(engNum[one]);			// 일의 자리 가져옴
            list.add(new English(sbt.toString(), sbo.toString(), ten, one));
        }

        list.sort(null);	// compareTo에서 지정한 대로 비교해서 정렬함

        for(int i = 1; i <= list.size(); i++) {
            int o = list.get(i - 1).num1;	// 객체의 10의자리 수 가져옴
            int p = list.get(i - 1).num2;	// 객체의 1의자리 수 가져옴
            int answer = o * 10 + p;		// 그리고 계산
            System.out.print(answer + " ");	// 출력
            if(i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
