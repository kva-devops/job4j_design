package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (equals(it.next(), value)) {
                return false;
            }
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (equals(it.next(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    public static boolean equals(Object a, Object b) {
        return a == b;
    }
}
