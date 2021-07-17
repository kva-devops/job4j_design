package ru.job4j.store.lsp;

import java.util.List;

public class ControlQuality implements ReSorting {

    Warehouse warehouse;
    Shop shop;
    Trash trash;
    BufferStore bufferStore;

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash, BufferStore bufferStore) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
        this.bufferStore = bufferStore;
    }

    public void supplyFoods(List<Food> foodList) {
        this.warehouse.warehouseList.addAll(foodList);
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

