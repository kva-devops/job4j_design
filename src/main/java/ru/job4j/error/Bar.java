package ru.job4j.error;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    List<Beer> menu = new ArrayList<>(
            List.of(new Beer("Lager", 100), new Beer("Stout", 140))
    );

    private static class Beer {
        String name;
        int price;

        public Beer(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        private void pourGlass() {
            System.out.println("Pouring a glass of beer");
        }
    }

    private int choiceBeer(String name) {
        for (Beer elem : menu) {
            if (elem.getName().equals(name)) {
                return elem.getPrice();
            } else {
                System.out.println("Please choice sort of beer...");
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Bar bar = new Bar();
        System.out.println(bar.choiceBeer("Stout"));
    }
}

// сложно будет добавлять в меню другие виды напитков и блюд
