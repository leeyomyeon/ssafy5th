package student;

import java.io.Serializable;

public class Student implements Serializable{
    public Student(int studentNum, String studentName, int grade, String majorName, int avrScore) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.grade = grade;
		this.majorName = majorName;
		this.avrScore = avrScore;
	}

	@Override
    public String toString() {
        return "Student[" +
                "학번 =" + studentNum +
                ", 이름 ='" + studentName + '\'' +
                ", 학년 =" + grade +
                ", 전공 ='" + majorName + '\'' +
                ']';
    }

    private int studentNum;
    private String studentName;
    private int grade;
    private String majorName;
    private int avrScore;

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getAvrScore() {
        return avrScore;
    }

    public void setAvrScore(int avrScore) {
        this.avrScore = avrScore;
    }
}
