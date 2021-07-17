package ru.job4j.store.lsp;

import java.util.List;

public interface ReSorting {

    List<Food> compactAllFoodToOneList();

    void clearAllStores();

    void reSort();
}
