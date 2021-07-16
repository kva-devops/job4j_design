package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    List<Food> shopList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return food.productShelfLife() < 75 && food.productShelfLife() > 0;
    }

    @Override
    public void add(Food food) {
        this.getStore().add(food);
    }

    @Override
    public List<Food> getStore() {
        return shopList;
    }

    public boolean discountCheck(Food food) {
        if (food.productShelfLife() < 25 && food.productShelfLife() > 0) {
            return food.getDiscount() != food.getPrice();
        }
        return false;
    }

    public void setDiscountPrice(Food food) {
        food.setPrice(food.getDiscount());
    }
}
