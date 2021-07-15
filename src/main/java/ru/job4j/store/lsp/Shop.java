package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements SortingFoods {

    static List<Food> shopList = new ArrayList<>();

    @Override
    public void sortFoods() {
        List<Food> forRemoveList = new ArrayList<>();
        int valueFresh;
        for (Food elem : Shop.shopList) {
            valueFresh = elem.productShelfLife();
            if (valueFresh <= 25 && valueFresh > 0) {
                if (elem.getPrice() != elem.getDiscount()) {
                    elem.setPrice(elem.getDiscount());
                }
            } else if (valueFresh <= 0) {
                Trash.trashList.add(elem);
                forRemoveList.add(elem);
            }
        }
        Shop.shopList.removeAll(forRemoveList);
    }

    public String printList() {
        return "Shop: " + shopList.toString();
    }
}
