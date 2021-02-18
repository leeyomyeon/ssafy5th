package haksaSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static StudentManager instance;
    public static StudentManager getInstance() {
        if(instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }
    List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public String addStudent(Student student) {
        try {
            studentList.add(student);
            return "학생정보 저장 성공";
        } catch (Exception e) {
            return "학번이 중복됩니다.";
        }
    }

    public String removeStudent(int studentNumber) {
        for(int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getStudentNumber() == studentNumber) {
                studentList.remove(i);
                return "학생정보 삭제 완료";
            }
        }

        return "해당 학번으로 검색된 학생이 없습니다.";
    }

    public Student[] getList() {
        return null;
    }

    public Student searchStudentNumber(int studentNumber) {
        return null;
    }

    public Student[] sumScoreDescList() {
        return null;
    }
}
