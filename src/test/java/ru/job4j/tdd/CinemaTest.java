package ru.job4j.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Ciname3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session sessionInit = new Session3D();
        cinema.add(sessionInit);
        assertThat(sessionInit, is(cinema.find(session -> true).get(0)));
    }

    @Test(expected = Exception.class)
    public void buyNotCorrectDate() {
        Account account = new Account3D();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 13, 30, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Test(expected = Exception.class)
    public void buyOnePlaceError() {
        Account account1 = new Account3D();
        Account account2 = new Account3D();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 30, 23, 00);
        Ticket ticket1 = cinema.buy(account1, 1, 1, date);
        Ticket ticket2 = cinema.buy(account2, 1, 1, date);
    }

    @Test(expected = Exception.class)
    public void buyErrorPlace() {
        Account account = new Account3D();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 30, 23, 00);
        Ticket ticket = cinema.buy(account, 111, 222, date);
    }

}