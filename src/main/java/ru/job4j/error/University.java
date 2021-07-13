package ru.job4j.error;

import java.util.ArrayList;
import java.util.List;

public class University {
    String name;
    String address;
    String email;
    String phone;
    List<Group> groups;

    public University(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void printInformation() {
        System.out.println(getName());
        System.out.println(getAddress());
        System.out.println(getEmail());
        System.out.println(getPhone());
    }

    public static void main(String[] args) {
        University u1 = new University("MGU", "Moscow", "mgu@mgu.ru", "84951112223");
        Student s1 = new Student("Ivan", 'M', 234234, 1112323);
        Student s2 = new Student("Olga", 'F', 234344, 6675656);
        Group g1 = new Group("group1", 111111);
        u1.addGroup(g1);
        s2.addToGroup(g1);
        g1.addStudent(s1);
        u1.printInformation();
        s1.printInformation();
        g1.printStudents();
        System.out.println(g1.findStudent("Ivan"));
    }
}
