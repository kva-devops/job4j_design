package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "Correct input: java -jar duplicatesFinder.jar your_directory_for_scan"
            );
        }
        Files.walkFileTree(Path.of(args[0]), new DuplicatesVisitor());
    }
}
