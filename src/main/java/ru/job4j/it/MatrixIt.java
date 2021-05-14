package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (row < data.length && data[row].length != 0) {
            result = true;
        } else if (row + 1 < data.length && data[row + 1].length != 0) {
            result = true;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column < data[row].length) {
            return data[row][column++];
        }
        column = 0;
        if (data[row + 1].length == 0) {
            for (int i = 0; i < data.length - row; i++) {
                row++;
                if (data[row].length != 0) {
                    break;
                }
            }
        }
        return data[++row][column++];
    }
}
