package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "worker")
@XmlAccessorType(XmlAccessType.FIELD)
public class Worker {
    @XmlElement(name = "self")
    private Person self;

    @XmlElement(name = "wife")
    private Person wifeOrHusband;

    @XmlElementWrapper(name = "childes")
    @XmlElement(name = "child")
    private List<Person> child;

    @XmlAttribute
    private String position;
    @XmlAttribute
    private int salary;
    @XmlAttribute
    private boolean collegeDegree;

    public Worker() {

    }

    public Worker(Person self, List<Person> child, Person wifeOrHusband,
                  String position, int salary, boolean collegeDegree) {
        this.self = self;
        this.child = child;
        this.wifeOrHusband = wifeOrHusband;
        this.position = position;
        this.salary = salary;
        this.collegeDegree = collegeDegree;
    }

    public static void main(String[] args) throws JAXBException {
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

        JAXBContext context = JAXBContext.newInstance(Worker.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(wFirst, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
        }
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
