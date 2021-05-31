package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines()
                    .filter(s -> s.indexOf(" 404 ", s.length() - 9) != -1)
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
