package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;


@XmlRootElement
class Decor {
    @XmlElementWrapper(name = "list-employee", nillable = true)
    public List<Employee> employeeList = new ArrayList<>();
}

public class Employee {

    @XmlAttribute(name = "name")
    private String name;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlAttribute(name = "hired")
    private Calendar hired;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlAttribute(name = "fired")
    private Calendar fired;

    @XmlAttribute(name = "salary")
    private double salary;

    public Employee() { }

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public Calendar getHired() {
        return hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public double getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(hired, employee.hired) && Objects.equals(fired, employee.fired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired, fired, salary);
    }
}
