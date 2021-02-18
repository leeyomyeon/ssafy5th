package student;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StudentMgr implements StudentMgrInterface{
    private static StudentMgr instance;
    public static StudentMgr getInstance() {
        if(instance == null) {
            instance = new StudentMgr();
        }
        return instance;
    }

    ArrayList<Student> student;

    StudentMgr() {
        student = new ArrayList<>();
        load();
    }

    public void addStudent(Student s) {
        for(Student st : student) {
            if( st.getStudentNum() == s.getStudentNum() )
                throw new DuplicateException();
        }
        student.add(s);
    }

    public void deleteStudent(int studentNum) {
        boolean flag = false;
        int idx = 0;
        for(int i = 0; i < student.size(); i++) {
            if( student.get(i).getStudentNum() == studentNum)
                flag = true;
            idx = i;
        }
        if(flag)
            student.remove(idx);
        else
            throw new NotFoundException();

    }

    public ArrayList<Student> getCSList() {
        ArrayList<Student> result = new ArrayList<>();

        for(int i = 0; i < student.size(); i++) {
            if(  student.get(i) instanceof CS  ) {
                result.add(student.get(i));
            }
        }
        return result;
    }
    public ArrayList<Student> getICEList() {
        ArrayList<Student> result = new ArrayList<>();

        for(int i = 0; i < student.size(); i++) {
            if(  student.get(i) instanceof ICE  ) {
                result.add(student.get(i));
            }
        }
        return result;
    }

    @Override
	public ArrayList<Student> getMajorList(String majorName){
		int idx = majorName.length();
		String cs = "컴퓨터공학";
		String[] cs_arr = cs.split("");		
		String ice = "정보통신공학";
		String[] ice_arr = ice.split("");
		String[] Major = majorName.split("");
		int index = 0;
		

		
		boolean flag = true;
		boolean flag_ = true;
		//cs 검색
		int clen =cs.length();
		
		boolean[] visited = new boolean[clen];
		ArrayList<Student> result = new ArrayList<Student>();
		for(int i = 0; i < cs_arr.length-1; i++) {
			for(int j = 0; j < Major.length; j++) {
				if(Major[j].equals(cs_arr[i]) && !visited[i]) {
					visited[i] = true;
					index++;
				}
					
			}
		}
		
		if(index>=2) {
	
			return getCSList();
			//return result;
		}
		else {
			//System.out.println("잘못 입력하셨습니다.");
			flag = false;
			
		}
		//ice 검색
		index = 0;
		int ilen =ice.length();
		boolean[] visited_ = new boolean[ilen];
		for(int i = 0; i < ice_arr.length-1; i++) {
			for(int j = 0; j < majorName.length(); j++) {
				if(Major[j].equals(ice_arr[i]) && !visited_[i]) {
						visited_[i] = true;
						index++;
				}
							
			}
		}
				
		if(index>=2) {
			
			return getICEList();
			//return result;
		}
		else {
			//System.out.println("잘못 입력하셨습니다.");
			flag_ = false;
		}
		if((flag_ && flag) || (!flag && !flag_)) {
			return null;
		}
		else {
			return result;
		}
		
			
		
	}

    @Override
    public Student getStudent(int studentNum) {
    	Student s = null;
		for(int i = 0; i < student.size(); i++) {
			if(student.get(i).getStudentNum() == studentNum)
				s = student.get(i);
		}
		if( s == null )
			throw new NotFoundException();
		return s;
    }

    @Override
    public ArrayList<Student> getStudentList() {
        if(student.size() == 0) {
            throw new NotFoundException();
        }

        return new ArrayList<Student>(student);
    }

    @Override
    public ArrayList<Student> getStudentList(String studentName) {
        ArrayList<Student> s = new ArrayList<>();
        for(Student tmpStudent : student) {
            if(tmpStudent.getStudentName().contains(studentName)) {
                s.add(tmpStudent);
            }
        }

        if(s.size() == 0) {
            throw new NotFoundException();
        }

        return s;
    }

    @Override
    public ArrayList<Student> getStudentList(int score, boolean cond) {
        ArrayList<Student> s = new ArrayList<>();
        if(score <= 0) {
            throw new InputMismatchException();
        }
        if(cond) { // 점수 이상
            for(Student tmpStudent : student) {
                if(tmpStudent.getAvrScore() >= score) {
                    s.add(tmpStudent);
                }
            }
        } else {    // 점수 이하
            for(Student tmpStudent : student) {
                if(tmpStudent.getAvrScore() <= score) {
                    s.add(tmpStudent);
                }
            }
        }

        if(s.size() == 0) {
            throw new NotFoundException();
        }

        return s;
    }

    @Override
    public void updateScore(Student s, int score, int subject) {
        if(s instanceof CS) {
            if(subject == 1) {
                ((CS) s).setAlgorithm(score);
            } else if (subject == 2) {
                ((CS) s).setOs(score);
            } else if (subject == 3) {
                ((CS) s).setOop(score);
            } else {
                throw new NotFoundException();
            }

            int algo = ((CS) s).getAlgorithm();
            int os = ((CS) s).getOs();
            int oop = ((CS) s).getOop();

            s.setAvrScore((algo + os + oop) / 3);
        } else {
            if(subject == 0) {
                ((ICE) s).setComputerVision(score);
            } else if (subject == 1) {
                ((ICE) s).setDSP(score);
            } else if (subject == 2) {
                ((ICE) s).setCommTheory(score);
            } else {
                throw new NotFoundException();
            }

            int cv = ((ICE) s).getComputerVision();
            int dsp = ((ICE) s).getDSP();
            int ct = ((ICE) s).getCommTheory();

            s.setAvrScore((cv + dsp + ct) / 3);
        }
    }

    @Override
    public ArrayList<Student> getStudentGradeList(int grade) {
        if(grade <= 0) {
            throw new InputMismatchException();
        }
        ArrayList<Student> s = new ArrayList<>();

        for(Student tmpStudent : student) {
            if(tmpStudent.getGrade() == grade) {
                s.add(tmpStudent);
            }
        }

        if(s.size() == 0 ) {
            throw new NotFoundException();
        }

        return s;
    }

    @Override
    public String lottoEvent() {
        int num = (int) (Math.random() * student.size());
        int n = (int) (Math.random() * 5);
        String[] arr = {"100만원", "아이패드", "노트북", "패딩", "에어팟"};
        String name = student.get(num).getStudentName();
        int studentNum = student.get(num).getStudentNum();
        return  studentNum+"("+name+")학생이 "+arr[n]+" 상품에 당첨되었습니다.";
    }
    ///Users/iyomyeon/Desktop/SSAFY/student.dat
    //C:\\Users\\dram109\\Desktop\\eclipse-jee-2018-09-win32-x86_64\\data.dat
    public void save() {
        try {
            ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream("/Users/iyomyeon/Desktop/SSAFY/student.dat"));
            oOut.writeObject(student);
            oOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            ObjectInputStream oIn = new ObjectInputStream(new FileInputStream("/Users/iyomyeon/Desktop/SSAFY/student.dat"));
            student = (ArrayList<Student>) oIn.readObject();
        } catch (FileNotFoundException e) {
            student = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
