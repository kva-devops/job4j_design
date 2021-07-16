package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    List<Food> trashList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return food.productShelfLife() <= 0;
    }

    @Override
    public void add(Food food) {
        this.getStore().add(food);
    }

    @Override
    public List<Food> getStore() {
        return trashList;
    }
}
