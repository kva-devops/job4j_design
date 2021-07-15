package ru.job4j.store.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenWarehouseFoodOnly() {
        List<Food> suppl = new ArrayList<>(
                List.of(
                        new Milk(
                                "Milk1",
                                LocalDate.of(2021, 12, 23),
                                LocalDate.of(2021, 7, 14),
                                50.0, 25.0)
                )
        );
        ControlQuality controlQuality = new ControlQuality(
                new Warehouse(), new Shop(), new Trash()
        );
        controlQuality.supplyFoods(suppl);
        controlQuality.checkFoods();
        assertThat(Warehouse.warehouseList.get(0).getName(), is("Milk1"));
    }

    @Test
    public void whenShopFoodOnly() {
        List<Food> suppl = new ArrayList<>(
                List.of(
                        new Milk(
                                "Milk2",
                                LocalDate.of(2021, 8, 23),
                                LocalDate.of(2021, 6, 10),
                                50.0, 25.0)
                )
        );
        ControlQuality controlQuality = new ControlQuality(
                new Warehouse(), new Shop(), new Trash()
        );
        controlQuality.supplyFoods(suppl);
        controlQuality.checkFoods();
        assertThat(Shop.shopList.get(0).getName(), is("Milk2"));
        Shop.shopList.clear();
    }

    @Test
    public void whenTrashFoodOnly() {
        List<Food> suppl = new ArrayList<>(
                List.of(
                        new Meat("Meat2",
                                LocalDate.of(2021, 7, 14),
                                LocalDate.of(2021, 6, 13),
                                500, 250)
                )
        );
        ControlQuality controlQuality = new ControlQuality(
                new Warehouse(), new Shop(), new Trash()
        );
        controlQuality.supplyFoods(suppl);
        controlQuality.checkFoods();
        assertThat(Trash.trashList.get(0).getName(), is("Meat2"));
    }

    @Test
    public void whenShopPriceChangeToDiscount() {
        List<Food> suppl = new ArrayList<>(
                List.of(
                        new Meat("Meat1",
                                LocalDate.of(2021, 7, 17),
                                LocalDate.of(2021, 6, 13),
                                500, 250)
                )
        );
        ControlQuality controlQuality = new ControlQuality(
                new Warehouse(), new Shop(), new Trash()
        );
        controlQuality.supplyFoods(suppl);
        controlQuality.checkFoods();
        double result = Shop.shopList.get(0).getPrice();
        double expected = Shop.shopList.get(0).getDiscount();
        System.out.println(controlQuality.shop.printList());
        assertThat(result, is(expected));
    }
}