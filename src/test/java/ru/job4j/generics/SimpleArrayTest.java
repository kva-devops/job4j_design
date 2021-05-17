package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertThat(arrayInt.next(), is(10));
        Assert.assertThat(arrayInt.next(), is(20));
        Assert.assertThat(arrayInt.next(), is(30));
        Assert.assertThat(arrayInt.next(), is(40));
        Assert.assertThat(arrayInt.hasNext(), is(false));
    }

    @Test
    public void whenAllElementIsNullIteratorReturnFalse() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(new Integer[sizeArray]);
        Assert.assertThat(arrayInt.hasNext(), is(false));
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