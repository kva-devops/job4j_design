package ru.job4j.store.lsp;

import java.util.ArrayList;
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
        this.warehouse.warehouseList.addAll(foodList);
    }

    private List<Food> compactAllFoodToOneList() {
        List<Food> foodListCommon = new ArrayList<>();
        foodListCommon.addAll(warehouse.getStore());
        foodListCommon.addAll(shop.getStore());
        foodListCommon.addAll(trash.getStore());
        clearAllStores();
        return foodListCommon;
    }

    private void clearAllStores() {
        warehouse.getStore().clear();
        shop.getStore().clear();
        trash.getStore().clear();
    }

    public void sortFoods() {
        List<Food> storeList = compactAllFoodToOneList();
        for (Food elem : storeList) {
            if (warehouse.accept(elem)) {
                this.warehouse.add(elem);
            } else if (shop.accept(elem)) {
                if (shop.discountCheck(elem)) {
                    shop.setDiscountPrice(elem);
                }
                this.shop.add(elem);
            } else if (trash.accept(elem)) {
                this.trash.add(elem);
            }
        }
    }
}

