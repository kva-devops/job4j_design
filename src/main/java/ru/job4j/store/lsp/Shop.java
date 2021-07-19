package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    List<Food> shopList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return getPercent(food) < 75 && getPercent(food) > 0;
    }

    @Override
    public void add(Food food) {
        this.getStore().add(food);
    }

    @Override
    public List<Food> getStore() {
        return shopList;
    }
}
