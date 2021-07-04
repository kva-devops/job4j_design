package ru.job4j.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class GCUser {

    public static void main(String[] args) {
        System.out.printf("Size of one object is %dKB%n", sizeOf(
                new User("Bill", 44)));
        System.out.printf("Size of one empty object is %dKB%n", sizeOf(
                new UserEmpty()));
        System.out.println("System starts GC by yourself, Keys set: -Xmx1m and -Xms1m");
        for (int i = 0; i < 100000; i++) {
            new User("Name" + i, i);
        }
    }
}
