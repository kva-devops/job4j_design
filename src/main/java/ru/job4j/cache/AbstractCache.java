package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        SoftReference<V> buff = cache.get(key);
        if (buff == null) {
            System.out.println("Cache is empty");
            return load(key);
        }
        System.out.println("This entry from cache");
        return buff.get() != null ? buff.get() : load(key);
    }

    protected abstract V load(K key);
}
