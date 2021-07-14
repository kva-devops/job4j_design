package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineJson implements Report {
    private Store store;

    public ReportEngineJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(store.findBy(filter));
        return json;
    }

    public static void main(String[] args) throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        store.add(worker1);
        Report engine = new ReportEngineJson(store);
        System.out.println(engine.generate(em -> true));
    }

}
