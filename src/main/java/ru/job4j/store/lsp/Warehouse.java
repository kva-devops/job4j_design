package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    List<Food> warehouseList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return getPercent(food) >= 75;
    }

    @Override
    public void add(Food food) {
        this.getStore().add(food);
    }

    @Override
    public List<Food> getStore() {
        return warehouseList;
    }
}
