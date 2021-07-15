package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash {
    static List<Food> trashList = new ArrayList<>();

    public void printList() {
        System.out.println("Trash: " + trashList.toString());
    }
}
