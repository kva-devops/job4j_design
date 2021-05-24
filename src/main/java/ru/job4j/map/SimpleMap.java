package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if ((float) count / (float) capacity >= LOAD_FACTOR) {
            expand();
        }
        MapEntry<K, V> buff = new MapEntry(key, value);
        int checkIndex = indexFor(hash(key.hashCode()));
        if (table[checkIndex] != null) {
            return false;
        }
        table[checkIndex] = buff;
        count++;
        modCount++;
        return true;

    }

    private int hash(int hashCode) {
        return hashCode % capacity;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] buff = new MapEntry[capacity];
        for (MapEntry node : table) {
            if (node != null) {
                int index = indexFor(hash(node.key.hashCode()));
                buff[index] = node;
            }
        }
        table = buff;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && count != 0 && table[index].key.equals(key)) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (count != 0 && index <= count && table[index].key.equals(key)) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            int fixModCount = modCount;
            int returnElement = 0;
            int indexIt = 0;

            @Override
            public boolean hasNext() {
                while (count != 0 && returnElement <= count) {
                    if (table[indexIt++] != null) {
                        returnElement++;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != fixModCount) {
                    throw new ConcurrentModificationException();
                }
                return table[indexIt].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

