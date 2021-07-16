package ru.job4j.store.lsp;

import java.util.List;

public interface Store {

    boolean accept(Food food);

    void add(Food food);

    List<Food> getStore();
}
