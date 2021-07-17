package ru.job4j.error;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

    int id;

    Map<Integer, Client> clientDatabase = new HashMap<>();

    boolean addClient(Integer id, Client client) {
        if (clientDatabase.containsValue(client)) {
            return false;
        } else {
            clientDatabase.put(id, client);
            return true;
        }
    }
}

// нарушение в хранении базы данных напрямую в классе, т.о. происходит жесткая привязка
// к текущей реализации. При необходимости изменить структуру для хранения данных придется
// переписывать весь класс
