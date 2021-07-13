package ru.job4j.error;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    int number;
    List<Student> students;

    public Group(String name, int number) {
        this.name = name;
        this.number = number;
        this.students = new ArrayList<>();
    }

    public void printStudents() {
        for (Student elem : students) {
            System.out.println(elem);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(String name) {
        for (Student elem : students) {
            if (elem.getName().equals(name)) {
                return elem;
            }
        }
        return null;
    }
}
