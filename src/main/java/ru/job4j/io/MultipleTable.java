package ru.job4j.io;

import java.io.FileOutputStream;

public class MultipleTable {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            String buffStr;
            for (int i = 1; i < 10; i++) {
                buffStr = i + " * 9 = " + i * 9 + System.lineSeparator();
                out.write(buffStr.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
