package ru.job4j.error;

import java.util.List;

public class AnimalShelter {

    List<Dog> listAnimal;

    private void addDog(Dog dog) {
        listAnimal.add(dog);
    }

    private void pickUp(Dog dog) {
        listAnimal.remove(dog);
    }

    private static class Dog {
        String name;
        int age;
    }
}

// проблемы возникнут, если приют решит помимо собак принимать еще и кошек
