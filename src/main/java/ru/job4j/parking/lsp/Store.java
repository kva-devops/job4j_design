package ru.job4j.parking.lsp;

import java.util.List;

public class Store {

    int automobileFreePlace;

    int trackFreePlace;

    List<Transport> places;

    public Store(int automobileFreePlace, int trackFreePlace, List<Transport> places) {
        this.automobileFreePlace = automobileFreePlace;
        this.trackFreePlace = trackFreePlace;
        this.places = places;
    }
}
