package ru.job4j.store.lsp;

public interface Discount {
    boolean discountCheck(Food food);

    void setDiscountPrice(Food food);
}
