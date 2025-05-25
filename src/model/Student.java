package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable {
    private int studentID;
    private String studentName;
    private BirthPlace studentCountryside;
    private Date studentDateOfBirth;
    private boolean studentGender;
    private double subjectScore1, subjectScore2, subjectScore3;

    public Student() {
    }

    public Student(int studentID, String studentName, BirthPlace studentCountryside,
                   Date studentDateOfBirth, boolean studentGender, double subjectScore1,
                   double subjectScore2, double subjectScore3) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentCountryside = studentCountryside;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentGender = studentGender;
        this.subjectScore1 = subjectScore1;
        this.subjectScore2 = subjectScore2;
        this.subjectScore3 = subjectScore3;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public BirthPlace getStudentCountryside() {
        return studentCountryside;
    }

    public void setStudentCountryside(BirthPlace studentCountryside) {
        this.studentCountryside = studentCountryside;
    }

    public Date getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(Date studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public boolean isStudentGender() {
        return studentGender;
    }

    public void setStudentGender(boolean studentGender) {
        this.studentGender = studentGender;
    }

    public double getSubjectScore1() {
        return subjectScore1;
    }

    public void setSubjectScore1(double subjectScore1) {
        this.subjectScore1 = subjectScore1;
    }

    public double getSubjectScore2() {
        return subjectScore2;
    }

    public void setSubjectScore2(double subjectScore2) {
        this.subjectScore2 = subjectScore2;
    }

    public double getSubjectScore3() {
        return subjectScore3;
    }

    public void setSubjectScore3(double subjectScore3) {
        this.subjectScore3 = subjectScore3;
    }

    @Override
    public String toString() {
        return "Student[" +
                "studentID=" + studentID +
                ", studentName=" + studentName +
                ", studentCountryside=" + studentCountryside +
                ", studentDateOfBirth=" + studentDateOfBirth +
                ", studentGender=" + studentGender +
                ", subjectScore1=" + subjectScore1 +
                ", subjectScore2=" + subjectScore2 +
                ", subjectScore3=" + subjectScore3 +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID && studentGender == student.studentGender
                && Double.compare(student.subjectScore1, subjectScore1) == 0
                && Double.compare(student.subjectScore2, subjectScore2) == 0
                && Double.compare(student.subjectScore3, subjectScore3) == 0
                && Objects.equals(studentName, student.studentName)
                && Objects.equals(studentCountryside, student.studentCountryside)
                && Objects.equals(studentDateOfBirth, student.studentDateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentName, studentCountryside,
                studentDateOfBirth, studentGender, subjectScore1, subjectScore2, subjectScore3);
    }
}
