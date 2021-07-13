package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineDevelopers implements Report {
    private Store store;

    public ReportEngineDevelopers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><body><table>")
                .append("<tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>")
                    .append(employee.getName()).append("</td><td>")
                    .append(employee.getHired()).append("</td><td>")
                    .append(employee.getFired()).append("</td><td>")
                    .append(employee.getSalary()).append("</td></tr>");
        }
        text.append("</table></body></html>");
        return text.toString();
    }
}
