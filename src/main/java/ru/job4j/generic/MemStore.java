package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (findById(id) != null) {
            mem.set(findIndexById(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        T modelForDelete = findById(id);
        if (modelForDelete != null) {
            mem.remove(modelForDelete);
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (T object : mem) {
            if (object.getId().equals(id)) {
                return object;
            }
        }
        return null;
    }

    private int findIndexById(String id) {
        return mem.indexOf(findById(id));
    }
}
