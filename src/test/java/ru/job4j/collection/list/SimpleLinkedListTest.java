package ru.job4j.collection.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    @Test
    public void whenAddAndGetInteger() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddAndGetString() {
        List<String> list = new SimpleLinkedList<>();
        list.add("Hello");
        list.add("world");
        assertThat(list.get(0), is("Hello"));
        assertThat(list.get(1), is("world"));
    }

    @Test
    public void whenAddAndExpandArray() {
        List<String> list = new SimpleLinkedList<>();
        list.add("Hello");
        list.add("world");
        list.add("another world");
        assertThat(list.get(0), is("Hello"));
        assertThat(list.get(1), is("world"));
        assertThat(list.get(2), is("another world"));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.get(2);
    }

    @Test
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext(), is(true));
        assertThat(first.next(), is(1));
        assertThat(first.hasNext(), is(true));
        assertThat(first.next(), is(2));
        assertThat(first.hasNext(), is(false));
        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext(), is(true));
        assertThat(second.next(), is(1));
        assertThat(second.hasNext(), is(true));
        assertThat(second.next(), is(2));
        assertThat(second.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElementException() {
        List<Integer> list = new SimpleLinkedList<>();
        Iterator<Integer> first = list.iterator();
        first.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationException() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        Iterator<Integer> first = list.iterator();
        list.add(2);
        first.next();
    }
}