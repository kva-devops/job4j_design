package ru.job4j.parking.lsp;

import java.util.ArrayList;
import java.util.List;

public class ParkingList implements ParkingStore {

    int automobilePlace;

    int trackPlace;

    int trackOnAutomobileParkingSumSize = 0;

    int countTrack = 0;

    int countAutomobile = 0;

    List<Transport> transportList = new ArrayList<>();

    public ParkingList() {
    }

    public void addTransport(Transport transport) {
        transportList.add(transport);
    }

    public int getFreeAutomobilePlace() {
        return automobilePlace - trackOnAutomobileParkingSumSize;
    }

    public int getFreeTrackPlace() {
        return trackPlace - countTrack;
    }

    public void addCountTrack() {
        this.countTrack++;
    }

    public void addCountAutomobile() {
        this.countAutomobile++;
    }

    public void addTrackOnAutomobilePlace(int sizeTrack) {
        this.trackOnAutomobileParkingSumSize += sizeTrack;
    }

    public void setAutomobilePlace(int automobilePlace) {
        this.automobilePlace = automobilePlace;
    }

    public void setTrackPlace(int trackPlace) {
        this.trackPlace = trackPlace;
    }

    public Transport getTransport(int carNumber) {
        for (Transport transport : transportList) {
            if (transport.getCarNumber() == carNumber) {
                return transport;
            }
        }
        return null;
    }
}
