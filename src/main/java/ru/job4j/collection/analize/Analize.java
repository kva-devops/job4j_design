package ru.job4j.collection.analize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        return new Info(
                checkAdded(previous, current),
                checkChanged(previous, current),
                checkDeleted(previous, current)
        );
    }

    private int checkDeleted(List<User> previous, List<User> current) {
        int prevSizeBefore = previous.size();
        List<User> buff = new ArrayList<>(previous);
        buff.retainAll(current);
        return prevSizeBefore - buff.size();

    }

    private int checkChanged(List<User> previous, List<User> current) {
        int counterChange = 0;
        for (User elemPrev : previous) {
            for (User elemCurr : current) {
                if (elemPrev.getId() == elemCurr.getId() && !elemPrev.getName().equals(elemCurr.getName())) {
                    counterChange++;
                }
            }
        }
        return counterChange;
    }

    private int checkAdded(List<User> previous, List<User> current) {
        List<User> buff = new ArrayList<>(previous);
        buff.retainAll(current);
        return current.size() - buff.size();
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}
