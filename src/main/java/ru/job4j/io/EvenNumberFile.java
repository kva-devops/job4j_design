package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] buffStr = text.toString().trim().split(System.lineSeparator());
            for (String s : buffStr) {
                if (Integer.parseInt(s) % 2 == 0) {
                    System.out.println(s + " true");
                } else {
                    System.out.println(s + " false");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
