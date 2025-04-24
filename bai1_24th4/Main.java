package bai1_24th4;

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

        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getScore));

        topStudent.ifPresent(s ->
                System.out.println("Học sinh điểm cao nhất: " + s.getName() + " - " + s.getScore())
        );
    }
}

