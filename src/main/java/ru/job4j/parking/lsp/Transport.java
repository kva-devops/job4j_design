package ru.job4j.parking.lsp;

public abstract class Transport {

    protected String name;

    protected int carNumber;

    protected int size;

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
