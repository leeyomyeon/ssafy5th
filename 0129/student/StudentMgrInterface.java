import java.util.ArrayList;

public interface StudentMgrInterface {
    void addStudent(Student s);

    void deleteStudent(int studentNum);

    ArrayList<Student> getMajorList(String majorName);

    Student getStudent(int studentNum);

    ArrayList<Student> getStudentList();

    ArrayList<Student> getStudentList(String studentName);

    ArrayList<Student> getStudentList(int score, boolean cond);

    void updateScore(Student s, int score, int subject);

    ArrayList<Student> getStudentGradeList(int grade);

    String lottoEvent();

    void save();

    void load();
}
