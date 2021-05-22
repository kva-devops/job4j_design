package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleMapTest {

    @Test
    public void whenPutTwoElemAndGet() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        base.put(1, "A");
        base.put(2, "B");
        Assert.assertThat(base.get(1), is("A"));
    }

    @Test
    public void whenPutMoreElemAndExpand() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        base.put(1, "A");
        base.put(2, "B");
        base.put(3, "C");
        base.put(4, "D");
        base.put(5, "E");
        base.put(6, "F");
        base.put(7, "G");
        base.put(8, "H");
        Assert.assertFalse(base.put(9, "I"));
        base.put(9, "I");
        Assert.assertThat(base.get(9), is("I"));
    }

    @Test
    public void whenEmptyGet() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        Assert.assertThat(base.get(1), nullValue());
    }

    @Test
    public void whenNoHasKeyGet() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        base.put(1, "Billy");
        Assert.assertThat(base.get(2), nullValue());
    }

    @Test
    public void whenRemoveOneNode() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        base.put(1, "A");
        base.put(2, "B");
        Assert.assertThat(base.remove(1), is(true));
        Assert.assertThat(base.get(2), is("B"));
        Assert.assertThat(base.get(1), nullValue());
    }

    @Test
    public void whenRemoveEmptyMapOrNotExistingKey() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        Assert.assertFalse(base.remove(1));
        base.put(1, "A");
        Assert.assertFalse(base.remove(2));
    }

    @Test
    public void whenIterator() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        base.put(1, "A");
        base.put(2, "B");
        Iterator<Integer> it = base.iterator();
        Assert.assertTrue(it.hasNext());
        Assert.assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorNoSuchElementException() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        Iterator<Integer> it = base.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorConcurrentModificationException() {
        SimpleMap<Integer, String> base = new SimpleMap<>();
        base.put(1, "A");
        base.put(2, "B");
        Iterator<Integer> it = base.iterator();
        it.next();
        base.put(3, "C");
        it.next();
    }
}