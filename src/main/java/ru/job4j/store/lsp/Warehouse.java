package ru.job4j.store.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements SortingFoods {

    static List<Food> warehouseList = new ArrayList<>();

    @Override
    public void sortFoods() {
        List<Food> forRemoveList = new ArrayList<>();
        int valueFresh;
        for (Food elem : Warehouse.warehouseList) {
            valueFresh = elem.productShelfLife();
            if (valueFresh < 75 && valueFresh > 25) {
                Shop.shopList.add(elem);
                forRemoveList.add(elem);
            } else if (valueFresh <= 25 && valueFresh > 0) {
                elem.setPrice(elem.getDiscount());
                Shop.shopList.add(elem);
                forRemoveList.add(elem);
            } else if (valueFresh <= 0) {
                Trash.trashList.add(elem);
                forRemoveList.add(elem);
            }

        }
        Warehouse.warehouseList.removeAll(forRemoveList);
    }

    public void printList() {
        System.out.println("Warehouse: " + warehouseList.toString());
    }
}
