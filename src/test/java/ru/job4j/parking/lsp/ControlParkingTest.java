package ru.job4j.parking.lsp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ControlParkingTest {

    @Test
    public void whenParkAutomobileOnly() {
        int automobilePlaceAmount = 1;
        int trackPlaceAmount = 0;
        String name = "automobile";
        int carNumber = 123;
        ControlParking parking = new Control(automobilePlaceAmount, trackPlaceAmount);
        Transport automobile = new Automobile(name, carNumber);
        parking.park(automobile);
        assertThat(parking.getParkingList().getTransport(carNumber), is(automobile));
    }

    @Test
    public void whenParkTrackOnly() {
        int automobilePlaceAmount = 0;
        int trackPlaceAmount = 1;
        String name = "track";
        int carNumber = 456;
        ControlParking parking = new Control(automobilePlaceAmount, trackPlaceAmount);
        Transport track = new Track(name, carNumber, 2);
        parking.park(track);
        assertThat(parking.getParkingList().getTransport(carNumber), is(track));
    }

    @Test
    public void whenParkTrackAndAutomobile() {
        int automobilePlaceAmount = 1;
        int trackPlaceAmount = 1;
        ControlParking parking = new Control(automobilePlaceAmount, trackPlaceAmount);
        Transport track = new Track("track", 111, 2);
        Transport automobile = new Automobile("automobile", 888);
        parking.park(track);
        parking.park(automobile);
        assertThat(parking.getParkingList().getTransport(111), is(track));
        assertThat(parking.getParkingList().getTransport(888), is(automobile));
    }


    @Test
    public void whenHasNotPlaceForAutomobile() {
        int automobilePlaceAmount = 0;
        int trackPlaceAmount = 1;
        String name = "automobile";
        int carNumber = 123;
        ControlParking parking = new Control(automobilePlaceAmount, trackPlaceAmount);
        Transport automobile = new Automobile(name, carNumber);
        assertThat(parking.park(automobile), is(false));
    }

    @Test
    public void whenHasNotPlaceForTrack() {
        int automobilePlaceAmount = 2;
        int trackPlaceAmount = 0;
        String name = "track";
        int carNumber = 123;
        ControlParking parking = new Control(automobilePlaceAmount, trackPlaceAmount);
        Transport track = new Track(name, carNumber, 2);
        parking.park(track);
        assertThat(parking.getParkingList().getTransport(carNumber), is(track));
    }
}