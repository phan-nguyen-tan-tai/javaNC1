package QLSV_VKU;

class Student {
    int id;
    String name;
    int age;
    String email;
    double gpa;

    public Student(int id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = generateEmail(name);
        this.gpa = gpa;
    }

    private String generateEmail(String name) {
        return name.replaceAll(" ", "").toLowerCase() + "@vku.udn.vn";
    }
}

