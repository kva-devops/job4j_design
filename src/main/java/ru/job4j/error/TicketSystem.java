package ru.job4j.error;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketSystem {

    List<Ticket> ticketList = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    public void printTicketList() {
        for (Ticket ticket : ticketList) {
            System.out.println(ticket.toString());
        }
    }

    public void deleteTicket(Ticket ticket) {
        ticketList.remove(ticket);
    }
}

class Ticket {
    int id;
    Client client;
    String text;
    LocalDate date;

    @Override
    public String toString() {
        return "Ticket{"
               + "id=" + id
               + ", client=" + client
               + ", text='" + text + '\''
               + ", date=" + date
               + '}';
    }
}
// здесь несколько нарушений: хранение данных в классе и использование зависимостей одной реализации от другой.
// TicketSystem зависит от Ticket.