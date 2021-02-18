package student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("                    SSAFY 학생정보 시스템입니다.");
        System.out.println("                        OOO님 환영합니다.");
        StudentMgr mgr = StudentMgr.getInstance();

        mgr.load();
        
        int sel = 0;

        do {
        	try {
        		System.out.println("-*-*-*-*-*-*-*-*- 메뉴 선택 -*-*-*-*-*-*-*-*-");
                System.out.println("\t\t\t 0. 종료하기");
                System.out.println("\t\t\t 1. 학생 정보 추가하기");
                System.out.println("\t\t\t 2. 학생 정보 삭제하기");
                System.out.println("\t\t\t 3. 모든 학생 정보 조회하기");
                System.out.println("\t\t\t 4. 학과별 학생 정보 조회하기");
                System.out.println("\t\t\t 5. 학번 또는 이름으로 조회하기");
                System.out.println("\t\t\t 6. 성적 정정하기");
                System.out.println("\t\t\t 7. 조건별 조회하기(평균성적 이상, 이하)");
                System.out.println("\t\t\t 8. 학년별로 조회하기");
                System.out.println("\t\t\t 9. 랜덤 1명 당첨 이벤트");
                System.out.println("\t\t\t10. 학생 정보 외부 파일로 저장하기");
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                sel = sc.nextInt();
        	}
           
            catch(InputMismatchException e) {
            	sc.next();
            }
            if (sel == 1) {
                //학생 추가
            	try {
            		
            	
                System.out.println("------------  1. 학생 정보 추가  -------------");

                System.out.print("학번 : ");
                int studentNum = sc.nextInt();

                System.out.print("이름 : ");
                String studentName = sc.next();

                System.out.print("학년 : ");
                int grade = sc.nextInt();

                System.out.print("전공선택 : 컴퓨터공학(1), 정보통신공학(2) = ");
                int select = sc.nextInt();
                if(select == 1) {
                	String majorName = "컴퓨터공학";
                	System.out.print("알고리즘 점수: ");
                    int algorithm = sc.nextInt();
                    System.out.print("운영체제 점수: ");
                    int os = sc.nextInt();
                    System.out.print("객체지향 점수: ");
                    int oop = sc.nextInt();
                    int avg = (algorithm + os + oop) / 3;
                    mgr.addStudent(new CS(studentNum, studentName, grade, majorName, avg, algorithm,
                			os, oop));
                }
                else if(select == 2) {
                	String majorName = "정보통신공학";
                
                	System.out.print("컴퓨터비전 점수: ");
                    int computerVision = sc.nextInt();
                    System.out.print("디지털신호처리 점수: ");
                    int DSP = sc.nextInt();
                    System.out.print("통신이론 점수: ");
                    int commTheory = sc.nextInt();
                    int avg = (computerVision + DSP + commTheory) / 3;
                    mgr.addStudent(new ICE(studentNum, studentName, grade, majorName, avg, computerVision,
                			DSP, commTheory));
                  
                    
                }
                else {
                	System.out.println("전공을 잘못 입력하셨습니다.");
                }
            	}
            	catch(DuplicateException e){
					System.out.println("중복된 학번이 존재합니다!!");
				}
            	catch(InputMismatchException e) {
					System.out.println("오류.");
					sc.next();
				}

            } else if (sel == 2) {
                //학번 입력받아 학생 삭제
                System.out.println("------------  2. 학생 정보 삭제  ------------");
                System.out.print("학번 : ");
                int studentNum = sc.nextInt();
                try {
                	mgr.deleteStudent(studentNum);
                	System.out.println("학번이 "+studentNum+"인 " + "학생이 database 에서 삭제되었습니다.");
                }
                catch(NotFoundException e) {
                	System.out.println("지우고자하는 정보가 존재하지 않습니다.");
                }

                

            } else if (sel == 3) {
                // 학생 정보 모두 출력
                System.out.println("------------  3. 모든 학생 출력  -------------");
               
                System.out.println("------------------------------------------");
             

                for(Student s : mgr.getStudentList())
					System.out.println(s);
                System.out.println("------------------------------------------");

            } else if (sel == 4) {
                // 학번 입력받아 학생정보 조회
                System.out.println("------------  4.학과별 학생 조회  -------------");
                System.out.print("전공 : ");

                String majorName = sc.next();
                if(mgr.getMajorList(majorName) == null) {
                	System.out.println("해당 학과 학생이 존재하지 않습니다.");
                
                }
                else {
                	for(Student s : mgr.getMajorList(majorName))
    					System.out.println(s);
                }
                	
            } else if (sel == 5) {
                System.out.println("5. 학번 또는 이름으로 조회하기 ------------------------");
                System.out.print("학번 또는 이름을 입력하세요.");
                String keyWord = sc.next();
                boolean isNumeric = isNumeric(keyWord);

                try {
                    if(isNumeric) {
                        mgr.getStudent(Integer.parseInt(keyWord));
                    } else {
                        mgr.getStudentList(keyWord);
                    }
                } catch (NotFoundException e) {

                }
            } else if (sel == 6) {
                try {
                    System.out.println("6. 성적 정정하기 ----------------------------------");
                    System.out.print("학번을 입력하세요");
                    int studentNum = sc.nextInt();

                    Student s = mgr.getStudent(studentNum);

                    System.out.println(s.getStudentName()+" 학생에 대한 과목 점수를 수정합니다.");
                    System.out.println(s.getStudentName()+"학생은 "+s.getMajorName()+"입니다.");
                    System.out.println("변경할 과목을 입력하세요.");

                    if(s instanceof CS) {
                        System.out.print("1. 알고리즘 2. 운영체제 3. 객체지향");
                    } else if (s instanceof ICE) {
                        System.out.print("1. 컴퓨터비전 2. 디지털신호처리 3. 통신이론");
                    }

                    int subject = sc.nextInt();

                    System.out.println("변경할 점수를 입력하세요.");
                    int score = sc.nextInt();

                    mgr.updateScore(s, score, subject);
                } catch (NotFoundException e) {
                    System.out.println("검색된 학생이 없습니다.");
                }

            } else if (sel == 7) {
                try {
                    System.out.println("7. 평균점수 이상 또는 이하 조회하기 --------------------");
                    System.out.println("점수를 입력하세요");
                    int score = sc.nextInt();

                    System.out.println("이상 이하를 입력하세요");
                    String str = sc.next();
                    boolean updown;

                    if(str.equals("이상")) {
                        updown = true;
                    } else if (str.equals("이하")) {
                        updown = false;
                    } else {
                        System.out.println("잘 못 입력하셨습니다.");
                        continue;
                    }

                    ArrayList<Student> student = mgr.getStudentList(score, updown);

                    for(Student tmpStudent : student) {
                        System.out.println(tmpStudent);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("점수는 -가 될 수 없습니다.");
                    sc.nextLine();
                } catch (NotFoundException e1) {
                    System.out.println("검색된 학생이 없습니다.");
                }
            } else if (sel == 8) {
                try {
                    System.out.println("8. 학년별로 조회하기 -----------------------------------");
                    System.out.println("학년을 입력하세요");

                    int grade = sc.nextInt();

                    ArrayList<Student> student = mgr.getStudentGradeList(grade);

                    for(Student tmpStudent : student) {
                        System.out.println(tmpStudent);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("학번은 -가 될 수 없습니다.");
                } catch (NotFoundException e1) {
                    System.out.println("해당 학년에 학생이 없습니다.");
                }
            } else if (sel == 9) {
                System.out.println("9. 랜덤 학생 1명 당첨선물 증정 ------------------------------");
                System.out.println(mgr.lottoEvent());
            } else if (sel == 10) {
                mgr.save();
            }
        }while(sel != 0);
        sc.close();
    }
	public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
