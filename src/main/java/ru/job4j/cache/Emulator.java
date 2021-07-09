package ru.job4j.cache;

public class Emulator extends DirFileCache {

    public Emulator(String dir) {
        super(dir);
    }

    public static void main(String[] args) {
        String dir = "cacheDir";
        String file1 = "Address.txt";
        String file2 = "Names.txt";
        Emulator start = new Emulator(dir);
        System.out.println(start.get(file1));
        System.out.println(start.get(file2));
        System.out.println(start.get(file1));
    }
}
