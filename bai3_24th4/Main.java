package bai3_24th4;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("An", 40),
                new Student("Bình", 55),
                new Student("Chi", 70),
                new Student("Dung", 45)
        );

        Map<String, List<Student>> result = students.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() >= 50 ? "Pass" : "Fail"));

        // In kết quả
        result.forEach((status, list) -> {
            System.out.println(status + ":");
            list.forEach(s -> System.out.println("  " + s.getName() + " - " + s.getScore()));
        });
    }
}

class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
