package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    public static int sizeArray = 5;

    @Test
    public void whenAddIntElementAndRemoveIt() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.add(30);
        arrayInt.remove(1);
        Assert.assertThat(arrayInt.get(1), is(30));
    }

    @Test
    public void whenAddTwoIntElementAndRemoveOneElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.remove(0);
        Assert.assertThat(arrayInt.get(0), is(20));
    }

    @Test
    public void whenSetElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.set(0, 30);
        Assert.assertThat(arrayInt.get(0), is(30));
    }

    @Test
    public void whenIteratorMethodReturnNextElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.add(30);
        arrayInt.add(40);
        Iterator<Integer> it = arrayInt.iterator();
        Assert.assertThat(it.next(), is(10));
        Assert.assertThat(it.next(), is(20));
        Assert.assertThat(it.next(), is(30));
        Assert.assertThat(it.next(), is(40));
        Assert.assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAllElementIsNullIteratorReturnFalse() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        Iterator<Integer> it = arrayInt.iterator();
        Assert.assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorNoSuchElementException() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        Iterator<Integer> it = arrayInt.iterator();
        it.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBound() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.remove(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundFromGet() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundFromSet() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.set(4, 30);
    }
}