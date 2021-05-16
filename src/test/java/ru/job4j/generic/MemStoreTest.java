package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class MemStoreTest {

    @Test
    public void testAdd() {
        MemStore<User> store = new MemStore<>();
        store.add(new User("first"));
        store.add(new User("second"));
        store.add(new User("third"));
        Assert.assertThat(
                Objects.requireNonNull(store.findById("first")).getId(),
                is("first"));
        Assert.assertThat(
                Objects.requireNonNull(store.findById("second")).getId(),
                is("second"));
        Assert.assertThat(
                Objects.requireNonNull(store.findById("third")).getId(),
                is("third"));
    }

    @Test
    public void testReplace() {
        MemStore<User> store = new MemStore<>();
        store.add(new User("first"));
        store.add(new User("second"));
        store.add(new User("third"));
        User expectUser = new User("new user");
        store.replace("second", expectUser);
        Assert.assertThat(store.findById("new user"), is(expectUser));
    }

    @Test
    public void testDelete() {
        MemStore<User> store = new MemStore<>();
        store.add(new User("first"));
        store.add(new User("second"));
        store.add(new User("third"));
        store.delete("second");
        Assert.assertThat(store.findById("second"), nullValue());

    }

    @Test
    public void testFindById() {
        MemStore<User> store = new MemStore<>();
        User first = new User("first");
        store.add(first);
        store.add(new User("second"));
        store.add(new User("third"));
        Assert.assertThat(store.findById("first"), is(first));
    }
}