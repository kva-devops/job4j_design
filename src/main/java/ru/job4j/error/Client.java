package ru.job4j.error;

public class Client {
    String name;
    int passport;
    Automobile automobile;
}

class Automobile {
    String model;
    int yearOfBuild;
    int serialNumber;
}

// возникнут сложности, если у клиента вместо автомобиля окажется мотоцикл,
// поэтому логичнее создать интерфейс Transport. Таким образом реализация будет
// зависить от абстракции