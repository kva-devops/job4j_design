package ru.job4j.store.lsp;

import java.time.LocalDate;
import java.time.Period;

public class Food {
    String name;
    LocalDate expiryDate;
    LocalDate createDate;
    double price;
    double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public int productShelfLife() {
        LocalDate createDate = this.getCreateDate();
        LocalDate expiredDate = this.getExpiryDate();
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

    @Override
    public String toString() {
        return "Food{"
               + "name='" + name + '\''
               + ", expiryDate=" + expiryDate
               + ", createDate=" + createDate
               + ", price=" + price
               + ", discount=" + discount
               + '}';
    }
}

class Milk extends Food {

    public Milk(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}

class Meat extends Food {

    public Meat(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}


