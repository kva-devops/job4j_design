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
            mem.set(mem.indexOf(findById(id)), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) != null) {
            mem.remove(findById(id));
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
}
