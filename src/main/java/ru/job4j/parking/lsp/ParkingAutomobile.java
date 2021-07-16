package ru.job4j.parking.lsp;

public class ParkingAutomobile implements Control {

    @Override
    public void addToStore(Transport transport) {
        System.out.println("Parking Automobile");
    }
}
