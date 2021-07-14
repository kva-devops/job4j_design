package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineXml implements Report {
    private Store store;

    public ReportEngineXml() { }

    public ReportEngineXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            for (Employee elem : store.findBy(filter)) {
                marshaller.marshal(elem, writer);
            }
            xml = writer.getBuffer().toString();
        } catch (Exception e) {

        }
        return xml;
    }

    public static void main(String[] args) throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Petr", now, now, 100);
        store.add(worker);
        store.add(worker1);
        Report engine = new ReportEngineXml(store);
        System.out.println(engine.generate(em -> true));
    }
}
