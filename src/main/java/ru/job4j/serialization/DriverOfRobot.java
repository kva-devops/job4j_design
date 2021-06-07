package ru.job4j.serialization;

public class DriverOfRobot {
    final private String name;
    final private String grade;
    final private int passport;

    public DriverOfRobot(String name, String grade, int passport) {
        this.name = name;
        this.grade = grade;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "DriverOfRobot{"
                + "name='" + name + '\''
                + ", grade='" + grade + '\''
                + ", passport=" + passport
                + '}';
    }
}
