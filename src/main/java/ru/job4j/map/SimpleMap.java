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
        if (count / capacity >= LOAD_FACTOR) {
            expand();
            return false;
        }
        MapEntry<K, V> buff = new MapEntry(key, value);
        table[indexFor(hash(key.hashCode()))] = buff;
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
            int index = indexFor(hash(node.key.hashCode()));
            buff[index] = node;
        }
        table = Arrays.copyOf(table, capacity);
        table = buff;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && count != 0 && table[index].key == key) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (count != 0 && index <= count && table[index].key == key) {
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
            int itIndex = 1;

            @Override
            public boolean hasNext() {
                return itIndex < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != fixModCount) {
                    throw new ConcurrentModificationException();
                }
                return table[itIndex++].key;
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
