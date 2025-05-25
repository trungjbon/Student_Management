package model;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementModel {
    private List<Student> studentList;
    private String fileName;

    public StudentManagementModel() {
        this.studentList = new ArrayList<>();
        this.fileName = "";
    }

    public StudentManagementModel(List<Student> studentList) {
        this.studentList = studentList;
        this.fileName = "";
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    public void insert(Student student) {
        this.studentList.add(student);
    }

    public void delete(Student student) {
        this.studentList.remove(student);
    }

    public void edit(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID() == student.getStudentID()) {
                studentList.set(i, student);
                break;
            }
        }
    }

    public boolean existID(Student student) {
        for (Student students : studentList) {
            if (students.getStudentID() == student.getStudentID()) {
                return true;
            }
        }
        return false;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
