package ru.job4j.store.lsp;

import java.util.List;

public class ControlQuality implements ReSorting {

    Store warehouse;
    Store shop;
    Store trash;
    Store bufferStore;

    public ControlQuality(Store warehouse, Store shop, Store trash, Store bufferStore) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
        this.bufferStore = bufferStore;
    }

    public void supplyFoods(List<Food> foodList) {
        this.warehouse.getStore().addAll(foodList);
    }

    public void distribute(Food food) {
        if (warehouse.accept(food)) {
            this.warehouse.add(food);
        } else if (shop.accept(food)) {
            if (shop.discountCheck(food)) {
                shop.setDiscountPrice(food);
            }
            this.shop.add(food);
        } else if (trash.accept(food)) {
            this.trash.add(food);
        }
    }

    @Override
    public List<Food> compactAllFoodToOneList() {
        bufferStore.getStore().addAll(warehouse.getStore());
        bufferStore.getStore().addAll(shop.getStore());
        bufferStore.getStore().addAll(trash.getStore());
        clearAllStores();
        return bufferStore.getStore();
    }

    @Override
    public void clearAllStores() {
        warehouse.getStore().clear();
        shop.getStore().clear();
        trash.getStore().clear();
    }

    @Override
    public void reSort() {
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