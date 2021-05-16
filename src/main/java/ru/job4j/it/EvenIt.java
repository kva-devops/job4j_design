package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int index = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while (numbers[index] % 2 != 0) {
            if (index < numbers.length - 1) {
                index++;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
