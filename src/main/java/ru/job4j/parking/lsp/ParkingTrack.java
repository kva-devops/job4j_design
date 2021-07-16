package ru.job4j.parking.lsp;

public class ParkingTrack implements Control {

    @Override
    public void addToStore(Transport transport) {
        System.out.println("Parking Track");
    }
}
