package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class UserStoreTest {

    @Test
    public void testAdd() {
        UserStore store = new UserStore();
        store.add(new User("first"));
        store.add(new User("second"));
        store.add(new User("third"));
        Assert.assertThat(store.findById("first").getId(), is("first"));
        Assert.assertThat(store.findById("second").getId(), is("second"));
        Assert.assertThat(store.findById("third").getId(), is("third"));
    }

    @Test
    public void testReplace() {
        UserStore store = new UserStore();
        store.add(new User("first"));
        store.add(new User("second"));
        store.add(new User("third"));
        User expectUser = new User("new user");
        store.replace("second", expectUser);
        Assert.assertThat(store.findById("new user"), is(expectUser));
    }

    @Test
    public void testDelete() {
        UserStore store = new UserStore();
        store.add(new User("first"));
        store.add(new User("second"));
        store.add(new User("third"));
        store.delete("first");
        Assert.assertThat(store.findById("first"), nullValue());
    }

    @Test
    public void testFindById() {
        UserStore store = new UserStore();
        User first = new User("first");
        store.add(first);
        store.add(new User("second"));
        store.add(new User("third"));
        Assert.assertThat(store.findById("first"), is(first));
    }
}