package QLSV_VKU;

import java.util.ArrayList;
import java.util.List;

class StudentManager1 {
    private final List<Student> students = new ArrayList<>();
    private final List<Class> classes = new ArrayList<>();
    private int studentCounter = 1;
    private int classCounter = 1;

    public void addStudent(String name, int age, double gpa) {
        students.add(new Student(studentCounter++, name, age, gpa));
        System.out.println("Thêm sinh viên thành công!");
    }

    public void addClass(String description) {
        classes.add(new Class(classCounter++, description));
        System.out.println("Thêm lớp thành công!");
    }

    public void enrollStudentToClass(int studentId, int classId) {
        Student student = students.stream().filter(s -> s.id == studentId).findFirst().orElse(null);
        Class clazz = classes.stream().filter(c -> c.classId == classId).findFirst().orElse(null);

        if (student != null && clazz != null) {
            clazz.addStudent(student);
        } else {
            System.out.println("Không tìm thấy sinh viên hoặc lớp học!");
        }
    }

    public void displayClassStudents(int classId) {
        Class clazz = classes.stream().filter(c -> c.classId == classId).findFirst().orElse(null);
        if (clazz != null) {
            clazz.displayStudents();
        } else {
            System.out.println("Không tìm thấy lớp học!");
        }
    }
}