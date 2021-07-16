package ru.job4j.parking.lsp;

public class ManagePark {
    Store store;
    Control parkingAutomobile;
    Control parkingTrack;

    public ManagePark(Store store, ParkingAutomobile parkingAutomobile, ParkingTrack parkingTrack) {
        this.store = store;
        this.parkingAutomobile = parkingAutomobile;
        this.parkingTrack = parkingTrack;
    }

    public Transport addNew() {
        return null;
    }
}
