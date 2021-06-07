package ru.job4j.serialization;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private Person self;
    private List<Person> child;
    private Person wifeOrHusband;
    private String position;
    private int salary;
    private boolean collegeDegree;

    public Worker(Person self, List<Person> child, Person wifeOrHusband,
                  String position, int salary, boolean collegeDegree) {
        this.self = self;
        this.child = child;
        this.wifeOrHusband = wifeOrHusband;
        this.position = position;
        this.salary = salary;
        this.collegeDegree = collegeDegree;
    }

    public static void main(String[] args) {
        Person wSelf = new Person(
                "James Bond",
                40,
                "male"
        );
        Person wWife = new Person(
                "Jane Seymour",
                35,
                "female"
        );
        Person son1 = new Person(
                "Bill",
                10,
                "male"
        );
        Person son2 = new Person(
                "John",
                15,
                "male"
        );
        List<Person> wChild = new ArrayList<>();
        wChild.add(son1);
        wChild.add(son2);
        Worker wFirst = new Worker(
                 wSelf, wChild, wWife,
                "software developer", 100000,
                true);
    }

    @Override
    public String toString() {
        return "Worker{"
                + "self=" + self
                + ", child=" + child
                + ", wifeOrHusband=" + wifeOrHusband
                + ", position='" + position + '\''
                + ", salary=" + salary
                + ", collegeDegree=" + collegeDegree
                + '}';
    }
}
