package ru.job4j.parking.lsp;

public class Control implements ControlParking {

    ParkingStore parkingList = new ParkingList();

    public Control(int automobilePlace, int trackPlace) {
        this.parkingList.setAutomobilePlace(automobilePlace);
        this.parkingList.setTrackPlace(trackPlace);
    }

    @Override
    public boolean park(Transport transport) {
        if (transport == null) {
            return false;
        }
        boolean result;
        int sizeTransport = transport.getSize();
        if (sizeTransport > 1) {
            if (parkingList.getFreeTrackPlace() > 0) {
                parkingList.addTransport(transport);
                parkingList.addCountTrack();
                result = true;
            } else {
                if (sizeTransport <= parkingList.getFreeAutomobilePlace()) {
                    parkingList.addTransport(transport);
                    parkingList.addTrackOnAutomobilePlace(sizeTransport);
                    parkingList.addCountTrack();
                    result = true;
                } else {
                    result = false;
                }
            }
        } else {
            if (parkingList.getFreeAutomobilePlace() >= 1) {
                parkingList.addTransport(transport);
                parkingList.addTrackOnAutomobilePlace(sizeTransport);
                parkingList.addCountAutomobile();
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public ParkingStore getParkingList() {
        return parkingList;
    }
}
