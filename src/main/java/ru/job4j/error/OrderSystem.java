package ru.job4j.error;

public interface OrderSystem {
    void choiceTypePizza();
    void choiceSizePizza();
    void choiceToppingForPizza();
    void choiceAddressForDelivery();
    void enterPhoneNumber();
    void enterName();
}

// система для работы пиццерии. Изначально рассчитана для доставки пиццы. Однако, если данный интерфейс
// будет использовать пиццерия, которая занимается доставкой, то при работе нужно будет мириться
// с лишними методами