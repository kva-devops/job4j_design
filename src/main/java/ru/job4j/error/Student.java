package ru.job4j.error;

public class Student {
    String name;
    char gender;
    int certification;
    int passport;

    public Student(String name, char gender, int certification, int passport) {
        this.name = name;
        this.gender = gender;
        this.certification = certification;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getCertification() {
        return certification;
    }

    public int getPassport() {
        return passport;
    }

    public void printInformation() {
        System.out.println(this.getName());
        System.out.println(this.getGender());
        System.out.println(this.getCertification());
        System.out.println(this.getPassport());
    }

    public void addToGroup(Group group) {
        group.addStudent(this);
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", gender=" + gender
                + ", certification=" + certification
                + ", passport=" + passport
                + '}';
    }
}
