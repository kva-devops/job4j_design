package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int changeCount = 0;

    private int elementCount = 0;

    Node<E> first;

    Node<E> last;

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
        elementCount++;
        changeCount++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> rsl = first;
        Node<E> buff = rsl.next;
        int counter = 0;
        while (counter != index) {
            rsl = buff;
            buff = rsl.next;
            counter++;
        }
        return rsl.getItem();
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, elementCount);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            final int expectedModCount = changeCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < elementCount;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != changeCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> rsl = first;
                Node<E> buff = rsl.next;
                if (index == 0) {
                    index++;
                    return rsl.getItem();
                }
                while (index != elementCount) {
                    rsl = buff;
                    buff = rsl.next;
                    index++;
                }
                return rsl.getItem();
            }
        };
    }
}
