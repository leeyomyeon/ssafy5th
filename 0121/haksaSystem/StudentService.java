package haksaSystem;

import java.util.Scanner;

public class StudentService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = StudentManager.getInstance();

        int sel;

        do {
            System.out.println("----------------------------------------");
            System.out.println("1. 학생 정보 추가");
            System.out.println("2. 학생 정보 삭제");
            System.out.println("3. 모든 학생 보기");
            System.out.println("4. 학번으로 조회");
            System.out.println("5. 총점으로 내림차순 조회");
            System.out.println("0. 종료");
            System.out.println("----------------------------------------");
            System.out.print("원하시는 서비스를 선택해주세요 : ");
            sel = sc.nextInt();

            if (sel == 1) {
                //학생 추가
                System.out.println("------------  1. 학생 정보 추가  -------------");

                System.out.print("학번 : ");
                int studentNumber = sc.nextInt();

                System.out.print("이름 : ");
                String name = sc.next();

                System.out.print("학년 : ");
                int grade = sc.nextInt();

                System.out.print("영어과목 점수: ");
                int english = sc.nextInt();

                System.out.print("수학과목 점수 : ");
                int math = sc.nextInt();

                System.out.print("국어과목 점수 : ");
                int nationalLanguage = sc.nextInt();

                Student student = new Student(studentNumber, name, grade, english, math, nationalLanguage);
                String message = studentManager.addStudent(student);
                System.out.println(message);

            } else if (sel == 2) {
                //학번 입력받아 학생 삭제
                System.out.println("------------  2. 학생 정보 삭제  ------------");
                System.out.print("학번 : ");
                int studentNumber = sc.nextInt();

                String delName = studentManager.removeStudent(studentNumber);

                if(delName.equals("")) {
                    System.out.println("학번으로 조회한 학생이 존재하지 않습니다.");
                } else {
                    System.out.println("학번이 "+studentNumber+"인 "+delName+"학생이 database 에서 삭제되었습니다.");
                }

            } else if (sel == 3) {
                // 학생 정보 모두 출력
                System.out.println("------------  3. 모든 학생 출력  -------------");
                String ui = "학번\t\t\t이름\t\t학년\t영어\t수학\t국어\t총점";
                System.out.println("------------------------------------------");
                System.out.println(ui);

                for(Student m : studentManager.getList()) {
                    System.out.println(m);
                }
                System.out.println("------------------------------------------");

            } else if (sel == 4) {
                // 학번 입력받아 학생정보 조회
                System.out.println("------------  4. 특정 학생 조회  -------------");
                System.out.print("학번 : ");

                int studentNumber = sc.nextInt();
                if(studentManager.searchStudentNumber(studentNumber) == null) {
                    System.out.println("해당 학번에 대한 학생 정보가 없습니다.");
                } else {
                    System.out.println("------------------------------------------");
                    String ui = "학번\t\t\t이름\t\t학년\t영어\t수학\t국어\t총점";
                    System.out.println(ui);

                    System.out.println(studentManager.searchStudentNumber(studentNumber));
                    System.out.println("------------------------------------------");
                }

            } else if (sel == 5) {
                int a = 1;
                System.out.println("--------------  5. 총점 내림차순 조회  ---------------");
                String ui = "등수\t학번\t\t\t이름\t\t학년\t영어\t수학\t국어\t총점";
                System.out.println("-------------------------------------------------");
                System.out.println(ui);

                Student[] m = studentManager.sumScoreDescList();

                for(int i = 0; i < m.length; i++) {
                    System.out.println(a+"등\t"+m[i]);
                    a++;
                }
                System.out.println("--------------------   ***   --------------------");
                if(m.length == 1) {
                    System.out.println("1등 학생인 "+m[0].getName()+"에게는 전액장학금이 주어집니다.");
                }
                else if(m.length >= 2) {
                    System.out.println("1등 학생인 "+m[0].getName()+"에게는 전액장학금이 주어집니다.");
                    System.out.println("2등 학생인 "+m[1].getName()+"에게는 반액장학금이 주어집니다.");
                    System.out.println("3등 이하는 장학금이 없습니다.. 더욱 노력하세요.");
                } else {
                    System.out.println("학생 정보가 없습니다.");
                }
                System.out.println("--------------------   ***   --------------------");
            }
        } while (sel != 0);
        sc.close();
    }
}
