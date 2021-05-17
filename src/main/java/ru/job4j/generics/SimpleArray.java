package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterator<T> {

    private int indexArray = 0;
    private int indexIterator = 0;
    final private T[] array;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        array[indexArray++] = model;
    }

    public void set(int index, T model) {
        int checkedIndex = checkIndex(index);
        if (checkedIndex != -1) {
            array[checkedIndex] = model;
        }
    }

    public void remove(int index) {
        int checkedIndex = checkIndex(index);
        if (checkedIndex != -1) {
            array[checkedIndex] = null;
            System.arraycopy(array, checkedIndex + 1, array, checkedIndex, array.length - checkedIndex - 1);
            if (array[array.length - 1] != null) {
                array[array.length - 1] = null;
            }
            indexArray--;
        }
    }

    public T get(int index) {
        int checkedIndex = checkIndex(index);
        if (checkedIndex != -1) {
            return array[checkedIndex];
        }
        return null;
    }

    private int checkIndex(int index) {
        if (array[Objects.checkIndex(index, array.length)] != null) {
            return index;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + ", array=" + Arrays.toString(array)
                + '}';
    }

    @Override
    public boolean hasNext() {
        while (array.length > indexIterator && array[indexIterator] == null) {
            indexIterator++;
        }
        return array.length > indexIterator &&  array[indexIterator] != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[indexIterator++];
    }
}
