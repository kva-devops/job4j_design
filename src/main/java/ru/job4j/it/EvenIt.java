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
        for (int i = index; i < numbers.length; i++) {
            if (isEven(numbers[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int j = index; j < numbers.length; j++) {
            if (isEven(numbers[j])) {
                index++;
                return numbers[j];
            }
            index++;
        }
        return 0;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
