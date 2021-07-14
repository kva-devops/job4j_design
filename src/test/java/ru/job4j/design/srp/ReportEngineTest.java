package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToDevelopers() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineDevelopers(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><body><table>")
                .append("<tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td>")
                .append("<tr><td>")
                .append(worker.getName()).append("</td><td>")
                .append(worker.getHired()).append("</td><td>")
                .append(worker.getFired()).append("</td><td>")
                .append(worker.getSalary()).append("</td></tr>")
                .append("</table></body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToAccountsDepart() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineAccountsDepart(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 70).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToHR() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportEngineHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportXml() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee(
                "Ivan",
                new GregorianCalendar(2017, 1, 25),
                new GregorianCalendar(2017, 5, 25),
                100);
        store.add(worker);
        Report engine = new ReportEngineXml(store);
        assertThat(engine.generate(em -> true), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<employee name=\"Ivan\" hired=\"2017-02-25T00:00:00+04:00\" fired=\"2017-06-25T00:00:00+04:00\" salary=\"100.0\"/>\n"));
    }

    @Test
    public void whenReportJson() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee(
                "Ivan",
                new GregorianCalendar(2017, 1, 25),
                new GregorianCalendar(2017, 5, 25),
                100);
        store.add(worker);
        Report engine = new ReportEngineJson(store);
        String expect = "[\n  {\n    "
                + "\"name\": \"Ivan\",\n    "
                + "\"hired\": {\n      "
                + "\"year\": 2017,\n      "
                + "\"month\": 1,\n      "
                + "\"dayOfMonth\": 25,\n      "
                + "\"hourOfDay\": 0,\n      "
                + "\"minute\": 0,\n     "
                + " \"second\": 0\n    },\n    "
                + "\"fired\": {\n      "
                + "\"year\": 2017,\n      "
                + "\"month\": 5,\n      "
                + "\"dayOfMonth\": 25,\n      "
                + "\"hourOfDay\": 0,\n      "
                + "\"minute\": 0,\n      "
                + "\"second\": 0\n    },\n    "
                + "\"salary\": 100.0\n  }\n]";
        assertThat(engine.generate(em -> true), is(expect));
    }
}