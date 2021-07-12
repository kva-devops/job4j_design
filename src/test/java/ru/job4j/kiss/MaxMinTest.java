package ru.job4j.kiss;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void testMax() {
        List<String> someList = new ArrayList<>(
                List.of("1", "3", "2")
        );
        Comparator<String> comparator = Comparator.naturalOrder();
        MaxMin obj = new MaxMin();
        String expected = "3";
        String result = obj.max(someList, comparator);
        assertThat(result, is(expected));
    }

    @Test
    public void testMin() {
        List<String> someList = new ArrayList<>(
                List.of("2", "1", "3")
        );
        Comparator<String> comparator = Comparator.naturalOrder();
        MaxMin obj = new MaxMin();
        String expected = "1";
        String result = obj.min(someList, comparator);
        assertThat(result, is(expected));
    }
}