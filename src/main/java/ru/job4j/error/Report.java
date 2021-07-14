package ru.job4j.error;

public class Report {
    public void printGroupReport(Group group) {
        System.out.println(group.toString());
    }

    public void printStudentReport(Student student) {
        System.out.println(student.toString());
    }

    public void printUniversityReport(University university) {
        System.out.println(university.toString());
    }

    public Student findStudent(String name) {
        return null;
    }

    public void addToGroup(Student student, Group group) {
    }
}
