package ru.job4j.io;

import java.io.File;

public class Dir {
    private static final int GB = 1073741824;
    private static final int KB = 1024;

    public static void main(String[] args) {
        File file = new File("/home/kustoff/projects/");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("Total disk size : %s Gb", file.getTotalSpace() / GB));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getName() + " : " + subfile.length() / KB + "Kb");
        }
    }
}
