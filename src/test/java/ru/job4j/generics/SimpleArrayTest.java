package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleArrayTest {
    public static int sizeArray = 5;

    @Test
    public void whenAddStringElementAndRemove() {
        SimpleArray<String> arrayStr = new SimpleArray<>(sizeArray, new String[sizeArray]);
        arrayStr.add("Hello");
        Assert.assertThat(arrayStr.get(0), is("Hello"));
        arrayStr.remove(0);
        Assert.assertThat(arrayStr.get(0), nullValue());
    }

    @Test
    public void whenAddIntElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        Assert.assertThat(arrayInt.get(0), is(10));
    }

    @Test
    public void whenAddOneIntElementAndRemoveOneElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.remove(0);
        Assert.assertThat(arrayInt.get(0), nullValue());
    }

    @Test
    public void whenAddTwoIntElementAndRemoveOneElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.remove(0);
        Assert.assertThat(arrayInt.get(0), is(20));
    }

    @Test
    public void whenSetElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.set(0, 30);
        Assert.assertThat(arrayInt.get(0), is(30));
    }

    @Test
    public void whenRemoveElementFromMiddle() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.add(30);
        arrayInt.add(40);
        arrayInt.add(50);
        arrayInt.remove(2);
        Assert.assertThat(arrayInt.get(2), is(40));
        Assert.assertThat(arrayInt.get(4), nullValue());
    }

    @Test
    public void whenIteratorMethodReturnNextElement() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        Iterator<Integer> it = arrayInt.iterator();
        int expected = 0;
        if (it.hasNext()) {
            expected = it.next();
        }
        Assert.assertThat(expected, is(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBound() {
        SimpleArray<Integer> arrayInt = new SimpleArray<>(sizeArray, new Integer[sizeArray]);
        arrayInt.add(10);
        arrayInt.add(20);
        arrayInt.remove(100);
    }
}