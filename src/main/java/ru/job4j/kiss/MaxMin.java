package ru.job4j.kiss;

import java.util.*;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, (t1, t2) -> comparator.compare(t1, t2) <= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, (t1, t2) -> comparator.compare(t1, t2) > 0);

    }

    public <T> T findValue(List<T> value, BiPredicate<T, T> predicate) {
        T findValue = value.get(0);
        for (T elem : value) {
            if (predicate.test(findValue, elem)) {
                findValue = elem;
            }
        }
        return findValue;
    }
    public static void main(String[] args) {
        List<String> someList = new ArrayList<>(List.of("ccc", "bbb", "aaa"));
        Comparator<String> comparator = Comparator.naturalOrder();
        MaxMin obj = new MaxMin();
        String resultMax = obj.max(someList, comparator);
        System.out.println(resultMax);
        String resultMin = obj.min(someList, comparator);
        System.out.println(resultMin);
    }
}