package ru.job4j.store.lsp;

import java.util.List;

public class ControlQuality {

    Warehouse warehouse;
    Shop shop;
    Trash trash;

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void supplyFoods(List<Food> foodList) {
        Warehouse.warehouseList.addAll(foodList);
    }

    public void checkFoods() {
        this.warehouse.sortFoods();
        this.shop.sortFoods();
    }
}

