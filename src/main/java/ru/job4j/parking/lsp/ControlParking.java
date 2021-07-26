package ru.job4j.parking.lsp;

public interface ControlParking {

    boolean park(Transport transport);

    ParkingStore getParkingList();
}
