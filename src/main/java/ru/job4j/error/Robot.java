package ru.job4j.error;

public class Robot {

    String name;

    int countOfLegs;

    private void run() {
        System.out.println("Run");
    }

    private void stop() {
        System.out.println("Stop");
    }
}

// проблемы возникнуть, когда появится робот, который будет летать, а не ходить