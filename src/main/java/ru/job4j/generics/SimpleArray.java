package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int indexArray = 0;
    final private int count;
    final private T[] array;

    public SimpleArray(int count, T[] array) {
        this.count = count;
        this.array = array;
    }

    public void add(T model) {
        array[indexArray++] = model;
    }

    public void set(int index, T model) {
        int checkedIndex = checkIndex(index);
        array[checkedIndex] = model;
    }

    public void remove(int index) {
        int checkedIndex = checkIndex(index);
        array[checkedIndex] = null;
        System.arraycopy(array, checkedIndex + 1, array, checkedIndex, array.length - checkedIndex - 1);
        if (array[array.length - 1] != null) {
            array[array.length - 1] = null;
        }
        indexArray--;
    }

    public T get(int index) {
        int checkedIndex = checkIndex(index);
        return array[checkedIndex];
    }

    private int checkIndex(int index) {
        return Objects.checkIndex(index, array.length);
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(array).iterator();
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "count=" + count
                + ", array=" + Arrays.toString(array)
                + '}';
    }
}
