package ru.job4j.collection;

import java.util.Iterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        Iterator<T> itIn = in.iterator();
        Iterator<T> itOut = out.iterator();
        if (!itOut.hasNext()) {
            while (itIn.hasNext()) {
                out.push(itIn.next());
                in.pop();
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
