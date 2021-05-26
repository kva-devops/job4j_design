package ru.job4j.collection.analize;

import java.util.*;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int addCounter = 0;
        int changeCounter = 0;
        Map<Integer, User> buffMap = new HashMap<>();
        for (User elemPrev : previous) {
            buffMap.put(elemPrev.getId(), elemPrev);
        }
        for (User elemCurr : current) {
            User buffUser = buffMap.put(elemCurr.getId(), elemCurr);
            if (buffUser == null) {
                addCounter++;
            } else {
                if (!elemCurr.getName().equals(buffUser.getName())) {
                    changeCounter++;
                }
            }
        }
        int delCounter = previous.size() + addCounter - current.size();
        return new Info(addCounter, changeCounter, delCounter);
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
