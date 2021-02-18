package haksaSystem;

import java.util.Objects;

public class Student {
    private int studentNumber;
    private String name;
    private int grade;
    private int english;
    private int math;
    private int nationalLanguage;
    private int sumScore;

    public Student() {

    }

    public Student(int studentNumber, String name, int grade, int english, int math, int nationalLanguage) {
    }

    public String toString() {
        return studentNumber+"\t"+name+"\t"+grade+"\t"+english+"\t"+math+"\t"+nationalLanguage+"\t"+sumScore;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getNationalLanguage() {
        return nationalLanguage;
    }

    public void setNationalLanguage(int nationalLanguage) {
        this.nationalLanguage = nationalLanguage;
    }

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber && grade == student.grade && english == student.english && math == student.math && nationalLanguage == student.nationalLanguage && sumScore == student.sumScore && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, name, grade, english, math, nationalLanguage, sumScore);
    }
}
