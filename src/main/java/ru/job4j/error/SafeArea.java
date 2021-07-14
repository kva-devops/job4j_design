package ru.job4j.error;

import java.util.ArrayList;
import java.util.List;

public class SafeArea {
    public static List<Worker> workerList;
    public static int passwordMain;

    public SafeArea(List<Worker> workerList, int passwordMain) {
        SafeArea.workerList = workerList;
        SafeArea.passwordMain = passwordMain;
    }

    public void addWorker(Worker worker) {
        if (worker.checkPassword()) {
            workerList.add(worker);
        }
    }

    public static void main(String[] args) {
        SafeArea safe = new SafeArea(new ArrayList<>(), 12345678);
        Worker worker1 = new Worker("Ivan", 12345678);
        Worker worker2 = new Worker("Petr", 1234);
        Worker worker3 = new Manager("Olga", 7777);
        safe.addWorker(worker1);
        safe.addWorker(worker2);
        safe.addWorker(worker3);
        for (Worker elem : workerList) {
            System.out.println(elem.name);
        }

    }
}

class Worker {
    String name;
    int password;

    public Worker(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public int getPassword() {
        return password;
    }

    public boolean checkPassword() {
        if (!SafeArea.workerList.contains(this)) {
            return this.getPassword() == SafeArea.passwordMain;
        }
        return false;
    }
}

class Manager extends Worker {

    public Manager(String name, int password) {
        super(name, password);
    }

    @Override
    public boolean checkPassword() {
        return !SafeArea.workerList.contains(this);
    }
}

// Проблема в нарушение инвариантности, т.к. в наследнике (Manager) не соблюдены условия базового класса (Worker),
// а именно упрощена (изменена/забыта/пропущена) процедура проверки пароля при добавлении работника в базу.