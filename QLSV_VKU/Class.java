package QLSV_VKU;

import QLSV_VKU.Student;

import java.util.ArrayList;
import java.util.List;

class Class {
    int classId;
    String description;
    List<Student> students = new ArrayList<>();

    public Class(int classId, String description) {
        this.classId = classId;
        this.description = description;
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Đã thêm sinh viên vào lớp " + description);
    }

    public void displayStudents() {
        System.out.println("Danh sách sinh viên trong lớp " + description + ":");
        for (Student student : students) {
            System.out.println("ID: " + student.id + ", Tên: " + student.name + ", Tuổi: " + student.age + ", Email: " + student.email + ", GPA: " + student.gpa);
        }
    }
}
