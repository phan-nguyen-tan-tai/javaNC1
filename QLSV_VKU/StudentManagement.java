package QLSV_VKU;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager1 manager = new StudentManager1();

        while (true) {
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm lớp học");
            System.out.println("3. Thêm sinh viên vào lớp học");
            System.out.println("4. Hiển thị danh sách sinh viên trong lớp");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    System.out.print("Nhập GPA: ");
                    double gpa = scanner.nextDouble();
                    manager.addStudent(name, age, gpa);
                    break;
                case 2:
                    System.out.print("Nhập mô tả lớp: ");
                    String description = scanner.nextLine();
                    manager.addClass(description);
                    break;
                case 3:
                    System.out.print("Nhập ID sinh viên: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Nhập ID lớp học: ");
                    int classId = scanner.nextInt();
                    manager.enrollStudentToClass(studentId, classId);
                    break;
                case 4:
                    System.out.print("Nhập ID lớp học: ");
                    int classToShow = scanner.nextInt();
                    manager.displayClassStudents(classToShow);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
