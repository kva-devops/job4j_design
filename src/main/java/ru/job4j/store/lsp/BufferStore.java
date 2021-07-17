package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class BufferStore implements Store {

    List<Food> bufferStoreList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return true;
    }

    @Override
    public void add(Food food) {
        this.getStore().add(food);
    }

    @Override
    public List<Food> getStore() {
        return bufferStoreList;
    }
}
