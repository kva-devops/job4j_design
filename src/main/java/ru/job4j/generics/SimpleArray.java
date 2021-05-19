package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int indexArray = 0;

    final private T[] array;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        array[indexArray++] = model;
    }

    public void set(int index, T model) {
        checkIndex(index);
        if (index != -1) {
            array[index] = model;
        }
    }

    public void remove(int index) {
        checkIndex(index);
        if (index != -1) {
            array[index] = null;
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            if (array[array.length - 1] != null) {
                array[array.length - 1] = null;
            }
            indexArray--;
        }
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, indexArray);
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + ", array=" + Arrays.toString(array)
                + '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int indexIterator = 0;

            @Override
            public boolean hasNext() {
                return indexArray > indexIterator;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[indexIterator++];
            }
        };
    }
}
