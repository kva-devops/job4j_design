package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private int lengthContainer = 2;

    private Object[] container = new Object[lengthContainer];

    private int elementCount = 0;

    private int changeCount = 0;

    public T get(int index) {
        checkIndex(index);
        return (T) container[index];
    }

    public void add(T model) {
        if (elementCount >= lengthContainer) {
            container = expandArray(container);
        }
        container[elementCount++] = model;
        changeCount++;
    }

    private void checkIndex(int index) {
        int indexAfter = Objects.checkIndex(index, lengthContainer);
        if (elementCount == 0 || indexAfter > elementCount - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Object[] expandArray(Object[] source) {
        lengthContainer *= 2;
        Object[] buffContainer = new Object[lengthContainer];
        System.arraycopy(source, 0, buffContainer, 0, source.length);
        return buffContainer;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            final int expectedModCount = changeCount;

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < elementCount && container[index] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != changeCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[index++];
            }
        };
    }
}
