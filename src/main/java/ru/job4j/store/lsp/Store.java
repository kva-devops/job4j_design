package ru.job4j.store.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface Store {

    boolean accept(Food food);

    void add(Food food);

    List<Food> getStore();

    default int getPercent(Food food) {
        LocalDate createDate = food.getCreateDate();
        LocalDate expiredDate = food.getExpiryDate();
        LocalDate today = LocalDate.now();
        Period productLife = Period.between(createDate, expiredDate);
        Period lostProductLife = Period.between(today, expiredDate);
        int productAllLifeInDays =
                productLife.getDays()
                        + productLife.getMonths() * 30
                        + productLife.getYears() * 365;
        int productLostLifeInDays =
                lostProductLife.getDays()
                        + lostProductLife.getMonths() * 30
                        + lostProductLife.getYears() * 365;
        return productLostLifeInDays * 100 / productAllLifeInDays;
    }

    default boolean discountCheck(Food food) {
        if (getPercent(food) < 25 && getPercent(food) > 0) {
            return food.getDiscount() != food.getPrice();
        }
        return false;
    }

    default void setDiscountPrice(Food food) {
        food.setPrice(food.getDiscount());
    }
}
