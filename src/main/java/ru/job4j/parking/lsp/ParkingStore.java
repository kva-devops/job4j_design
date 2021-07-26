package ru.job4j.parking.lsp;

public interface ParkingStore {

    void addTransport(Transport transport);

    Transport getTransport(int carNumber);

    void setAutomobilePlace(int automobilePlace);

    void setTrackPlace(int trackPlace);

    int getFreeAutomobilePlace();

    int getFreeTrackPlace();

    void addCountTrack();

    void addCountAutomobile();

    void addTrackOnAutomobilePlace(int sizeTrack);
}
