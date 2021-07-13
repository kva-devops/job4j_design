package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHR implements Report {

    private Store store;

    public ReportEngineHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> buff = store.findBy(filter);
        Comparator<Employee> comparator = (employee, t1) -> {
            if (employee.getSalary() > t1.getSalary()) {
                return 1;
            } else if (employee.getSalary() < t1.getSalary()) {
                return -1;
            }
            return 0;
        };
        buff.sort(comparator.reversed());
        for (Employee employee : buff) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
