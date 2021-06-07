package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String sex;

    public Person() {

    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
