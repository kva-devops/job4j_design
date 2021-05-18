package ru.job4j.collection;

import java.util.Iterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        Iterator<T> itIn = in.iterator();
        while (itIn.hasNext()) {
            out.push(itIn.next());
            in.pop();
        }
        T rsl = out.pop();
        Iterator<T> itOut = out.iterator();
        while (itOut.hasNext()) {
            in.push(itOut.next());
            out.pop();
        }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
    }
}
