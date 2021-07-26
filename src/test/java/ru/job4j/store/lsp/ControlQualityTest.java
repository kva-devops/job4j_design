package ru.job4j.store.lsp;

//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;

public class ControlQualityTest {

//    @Test
//    public void distributeMethodTesting() {
//        Food food = new Milk(
//                "Milk1",
//                LocalDate.of(2021, 12, 23),
//                LocalDate.of(2021, 7, 14),
//                50.0, 25.0);
//        List<Store> storeList = new ArrayList<>(List.of(
//                new Warehouse(), new Shop(), new Trash(), new BufferStore()
//        ));
//        ControlQuality controlQuality = new ControlQuality(
//                storeList
//        );
//        controlQuality.distribute(food);
//        assertThat(controlQuality.storeList.get(0).getStore().get(0).getName(), is("Milk1"));
//    }
//
//    @Test
//    public void whenWarehouseFoodOnly() {
//        List<Food> suppl = new ArrayList<>(
//                List.of(
//                        new Milk(
//                                "Milk1",
//                                LocalDate.of(2021, 12, 23),
//                                LocalDate.of(2021, 7, 14),
//                                50.0, 25.0)
//                )
//        );
//        List<Store> storeList = new ArrayList<>(List.of(
//                new Warehouse(), new Shop(), new Trash(), new BufferStore()
//        ));
//        ControlQuality controlQuality = new ControlQuality(
//                storeList
//        );
//        controlQuality.supplyFoods(suppl);
//        controlQuality.reSort();
//        assertThat(controlQuality.storeList.get(0).getStore().get(0).getName(), is("Milk1"));
//    }
//
//    @Test
//    public void whenTrashFoodOnly() {
//        List<Food> suppl = new ArrayList<>(
//                List.of(
//                        new Meat("Meat2",
//                                LocalDate.of(2021, 7, 14),
//                                LocalDate.of(2021, 6, 13),
//                                500, 250)
//                )
//        );
//        List<Store> storeList = new ArrayList<>(List.of(
//                new Warehouse(), new Shop(), new Trash(), new BufferStore()
//        ));
//        ControlQuality controlQuality = new ControlQuality(
//                storeList
//        );
//        controlQuality.supplyFoods(suppl);
//        controlQuality.reSort();
//        assertThat(controlQuality.storeList.get(2).getStore().get(0).getName(), is("Meat2"));
//    }
//
//    @Test
//    public void whenShopFoodOnly() {
//        List<Food> suppl = new ArrayList<>(
//                List.of(
//                        new Milk(
//                                "Milk2",
//                                LocalDate.of(2021, 8, 23),
//                                LocalDate.of(2021, 6, 10),
//                                50.0, 25.0)
//                )
//        );
//        List<Store> storeList = new ArrayList<>(List.of(
//                new Warehouse(), new Shop(), new Trash(), new BufferStore()
//        ));
//        ControlQuality controlQuality = new ControlQuality(
//                storeList
//        );
//        controlQuality.supplyFoods(suppl);
//        controlQuality.reSort();
//        assertThat(controlQuality.storeList.get(1).getStore().get(0).getName(), is("Milk2"));
//    }
//
//    @Test
//    public void whenShopPriceChangeToDiscount() {
//        List<Food> suppl = new ArrayList<>(
//                List.of(
//                        new Meat("Meat1",
//                                LocalDate.of(2021, 7, 25),
//                                LocalDate.of(2021, 6, 13),
//                                500, 250)
//                )
//        );
//        List<Store> storeList = new ArrayList<>(List.of(
//                new Warehouse(), new Shop(), new Trash(), new BufferStore()
//        ));
//        ControlQuality controlQuality = new ControlQuality(
//                storeList
//        );
//        controlQuality.supplyFoods(suppl);
//        controlQuality.reSort();
//        double result = controlQuality.storeList.get(1).getStore().get(0).getPrice();
//        double expected = controlQuality.storeList.get(1).getStore().get(0).getDiscount();
//        assertThat(result, is(expected));
//    }
}