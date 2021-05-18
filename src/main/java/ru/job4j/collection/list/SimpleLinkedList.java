package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private int containerLength = 2;

    private int changeCount = 0;

    private int elementCount = 0;

    Node<E> first;

    Node<E> last;

    private Object[] container = new Object[containerLength];

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        if (elementCount >= containerLength) {
            container = expandArray(container);
        }
        container[elementCount++] = newNode;
        changeCount++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return ((Node<E>) container[index]).getItem();
    }

    private Object[] expandArray(Object[] source) {
        containerLength *= 2;
        Object[] buffContainer = new Object[containerLength];
        System.arraycopy(source, 0, buffContainer, 0, source.length);
        return buffContainer;
    }

    private void checkIndex(int index) {
        int indexAfter = Objects.checkIndex(index, containerLength);
        if (elementCount == 0 || indexAfter > elementCount - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            final int expectedModCount = changeCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < elementCount && container[index] != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != changeCount) {
                    throw new ConcurrentModificationException();
                }
                return ((Node<E>) container[index++]).getItem();
            }
        };
    }


}
