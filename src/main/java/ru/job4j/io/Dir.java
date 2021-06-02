package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("/home/kustoff/projects/");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("Total disk size : %s Gb", file.getTotalSpace() / 1073741824));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getName() + " : " + subfile.length() / 1024 + "Kb");
        }
    }
}
