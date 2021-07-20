package ru.job4j.store.lsp;

import java.util.List;

public class ControlQuality implements ReSorting {

    List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void supplyFoods(List<Food> foodList) {
        this.storeList.get(0).getStore().addAll(foodList);
    }

    public void distribute(Food food) {
        if (this.storeList.get(0).accept(food)) {
            this.storeList.get(0).add(food);
        } else if (this.storeList.get(1).accept(food)) {
            Shop shopBuff = (Shop) this.storeList.get(1);
            if (shopBuff.discountCheck(food)) {
                shopBuff.setDiscountPrice(food);
            }
            this.storeList.get(1).add(food);
        } else if (this.storeList.get(2).accept(food)) {
            this.storeList.get(2).add(food);
        }
    }

    @Override
    public List<Food> compactAllFoodToOneList() {
        this.storeList.get(3).getStore().addAll(this.storeList.get(0).getStore());
        this.storeList.get(3).getStore().addAll(this.storeList.get(1).getStore());
        this.storeList.get(3).getStore().addAll(this.storeList.get(2).getStore());
        clearAllStores();
        return this.storeList.get(3).getStore();
    }

    @Override
    public void clearAllStores() {
        this.storeList.get(0).getStore().clear();
        this.storeList.get(1).getStore().clear();
        this.storeList.get(2).getStore().clear();
    }

    @Override
    public void reSort() {
        List<Food> storeList = compactAllFoodToOneList();
        for (Food elem : storeList) {
            if (this.storeList.get(0).accept(elem)) {
                this.storeList.get(0).add(elem);
            } else if (this.storeList.get(1).accept(elem)) {
                Shop shopBuff = (Shop) this.storeList.get(1);
                if (shopBuff.discountCheck(elem)) {
                    shopBuff.setDiscountPrice(elem);
                }
                this.storeList.get(1).add(elem);
            } else if (this.storeList.get(2).accept(elem)) {
                this.storeList.get(2).add(elem);
            }
        }
    }
}