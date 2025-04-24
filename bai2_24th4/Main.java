package bai2_24th4;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("An", 8.5),
                new Student("Bình", 9.0),
                new Student("Chi", 9.5),
                new Student("Dung", 8.0)
        );

        double avgScore = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0); // nếu danh sách rỗng thì trả về 0.0

        System.out.println("Điểm trung bình của cả lớp: " + avgScore);
    }
}

class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
