package ru.job4j.io.search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Searching {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Right format: java -jar ScriptName -d=directory -n=filename -t=typeSearch -o=result");
        }
        ArgsName argN = ArgsName.of(args);
        if (argN.getLength() != 4) {
            throw new IllegalArgumentException("Right format: java -jar ScriptName -d=directory -n=filename -t=typeSearch -o=result");
        }
        Path start = Paths.get(argN.get("d"));
        String typeSearch = argN.get("t");
        String nameFileSearch = argN.get("n");
        String nameSaveLog = argN.get("o");
        List<Path> buff = new ArrayList<>();
        if (typeSearch.equals("name")) {
            buff = search(start, path -> path.toFile().getName().equals(nameFileSearch));
        } else if (typeSearch.equals("mask")) {
            buff = search(start, path -> path.toFile().getName().contains(nameFileSearch));
        } else if (typeSearch.equals("regex")) {
            buff = search(start, path -> path.toFile().getName().matches(nameFileSearch));
        }
        try (PrintWriter pr = new PrintWriter(new BufferedOutputStream(new FileOutputStream(nameSaveLog)))) {
            for (Path elem : buff) {
                pr.write(elem.toString());
                pr.println();
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(nameSaveLog))) {
            br.lines().forEach(System.out::println);
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFile searcher = new SearchFile(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}