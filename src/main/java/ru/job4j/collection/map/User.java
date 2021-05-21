package ru.job4j.collection.map;

import java.util.*;

public class User {
    private final String name;
    private int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Billy", 3, new GregorianCalendar(1980, 1, 23));
        User user2 = new User("Billy", 3, new GregorianCalendar(1980, 1, 23));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}