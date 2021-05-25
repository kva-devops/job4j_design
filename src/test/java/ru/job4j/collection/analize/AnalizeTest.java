package ru.job4j.collection.analize;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class AnalizeTest {

    @Test
    public void whenTestAdded() {
        Analize.User one = new Analize.User(1, "A");
        Analize.User two = new Analize.User(2, "B");
        Analize.User three = new Analize.User(3, "C");
        Analize.User add = new Analize.User(4, "Add");
        List<Analize.User> prev = new ArrayList<>();
        prev.add(one);
        prev.add(two);
        prev.add(three);
        List<Analize.User> curr = new ArrayList<>();
        curr.add(one);
        curr.add(two);
        curr.add(three);
        curr.add(add);
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(prev, curr);
        Analize.Info expected = new Analize.Info(1, 0, 0);
        Assert.assertThat(result.added, is(expected.added));
    }

    @Test
    public void whenTestChanged() {
        Analize.User one = new Analize.User(1, "A");
        Analize.User two = new Analize.User(2, "B");
        Analize.User three = new Analize.User(3, "C");
        Analize.User changed = new Analize.User(3, "Changed");
        List<Analize.User> prev = new ArrayList<>();
        prev.add(one);
        prev.add(two);
        prev.add(three);
        List<Analize.User> curr = new ArrayList<>();
        curr.add(one);
        curr.add(two);
        curr.add(changed);
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(prev, curr);
        Analize.Info expected = new Analize.Info(0, 1, 0);
        Assert.assertThat(result.changed, is(expected.changed));
        Assert.assertThat(result.added, is(expected.added));
    }

    @Test
    public void whenTestDeleted() {
        Analize.User one = new Analize.User(1, "A");
        Analize.User two = new Analize.User(2, "B");
        Analize.User three = new Analize.User(3, "C");
        Analize.User delete = new Analize.User(5, "Delete");
        List<Analize.User> prev = new ArrayList<>();
        prev.add(one);
        prev.add(two);
        prev.add(three);
        prev.add(delete);
        List<Analize.User> curr = new ArrayList<>();
        curr.add(one);
        curr.add(two);
        curr.add(three);
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(prev, curr);
        Analize.Info expected = new Analize.Info(0, 0, 1);
        Assert.assertThat(result.deleted, is(expected.deleted));
    }

    @Test
    public void whenTestMultiActionAddAndChange() {
        Analize.User one = new Analize.User(1, "A");
        Analize.User two = new Analize.User(2, "B");
        Analize.User three = new Analize.User(3, "C");
        Analize.User delete = new Analize.User(5, "Delete");
        Analize.User threeChange = new Analize.User(3, "Change");
        Analize.User add = new Analize.User(4, "Add");
        List<Analize.User> prev = new ArrayList<>();
        prev.add(one);
        prev.add(two);
        prev.add(three);
        prev.add(delete);
        List<Analize.User> curr = new ArrayList<>();
        curr.add(one);
        curr.add(two);
        curr.add(threeChange);
        curr.add(add);
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(prev, curr);
        Analize.Info expected = new Analize.Info(1, 1, 1);
        Assert.assertThat(result.added, is(expected.added));
        Assert.assertThat(result.changed, is(expected.changed));
        Assert.assertThat(result.deleted, is(expected.deleted));
    }

    @Test
    public void whenTestMultiAction2AddAnd1DeleteAnd3Change() {
        Analize.User one = new Analize.User(1, "A");
        Analize.User two = new Analize.User(2, "B");
        Analize.User three = new Analize.User(3, "C");
        Analize.User four = new Analize.User(4, "D");
        Analize.User five = new Analize.User(5, "E");
        Analize.User six = new Analize.User(6, "F");
        Analize.User twoChange = new Analize.User(2, "B change");
        Analize.User threeChange = new Analize.User(3, "C change");
        Analize.User fourChange = new Analize.User(4, "D change");
        List<Analize.User> prev = new ArrayList<>();
        prev.add(one);
        prev.add(two);
        prev.add(three);
        prev.add(four);
        List<Analize.User> curr = new ArrayList<>();
        curr.add(twoChange);
        curr.add(threeChange);
        curr.add(fourChange);
        curr.add(five);
        curr.add(six);
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(prev, curr);
        Analize.Info expected = new Analize.Info(2, 3, 1);
        Assert.assertThat(result.added, is(expected.added));
        Assert.assertThat(result.changed, is(expected.changed));
        Assert.assertThat(result.deleted, is(expected.deleted));
    }

    @Test
    public void whenTestNotChanges() {
        Analize.User one = new Analize.User(1, "A");
        Analize.User two = new Analize.User(2, "B");
        Analize.User three = new Analize.User(3, "C");
        List<Analize.User> prev = new ArrayList<>();
        prev.add(one);
        prev.add(two);
        prev.add(three);
        List<Analize.User> curr = new ArrayList<>();
        curr.add(one);
        curr.add(two);
        curr.add(three);
        Analize analizeTest = new Analize();
        Analize.Info result = analizeTest.diff(prev, curr);
        Analize.Info expected = new Analize.Info(0, 0, 0);
        Assert.assertThat(result.added, is(expected.added));
        Assert.assertThat(result.changed, is(expected.changed));
        Assert.assertThat(result.deleted, is(expected.deleted));
    }
}