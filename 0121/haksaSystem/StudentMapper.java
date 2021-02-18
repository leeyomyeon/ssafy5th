package haksaSystem;

public interface StudentMapper {
    public String addStudent(Student s);

    public String removeStudent(int studentNumber);

    public Student[] getList();

    public Student searchStudentNumber(int studentNumber);

    public Student[] sumScoreDescList();
}
