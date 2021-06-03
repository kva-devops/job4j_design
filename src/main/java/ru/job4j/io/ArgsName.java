package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    public Set<String> getKeys() {
        return values.keySet();
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            String[] buffArg = arg.split("=");
            if (buffArg.length < 2) {
                throw new IllegalArgumentException("key=value");
            }
            values.put(buffArg[0].substring(1), buffArg[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
