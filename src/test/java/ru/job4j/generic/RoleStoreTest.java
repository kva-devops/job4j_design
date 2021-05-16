package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class RoleStoreTest {

    @Test
    public void testAdd() {
        RoleStore store = new RoleStore();
        store.add(new Role("first"));
        store.add(new Role("second"));
        store.add(new Role("third"));
        Assert.assertThat(store.findById("first").getId(), is("first"));
        Assert.assertThat(store.findById("second").getId(), is("second"));
        Assert.assertThat(store.findById("third").getId(), is("third"));
    }

    @Test
    public void testReplace() {
        RoleStore store = new RoleStore();
        store.add(new Role("first"));
        store.add(new Role("second"));
        store.add(new Role("third"));
        Role expectRole = new Role("new role");
        store.replace("second", expectRole);
        Assert.assertThat(store.findById("new role"), is(expectRole));
    }

    @Test
    public void testDelete() {
        RoleStore store = new RoleStore();
        store.add(new Role("first"));
        store.add(new Role("second"));
        store.add(new Role("third"));
        store.delete("first");
        Assert.assertThat(store.findById("first"), nullValue());
    }

    @Test
    public void testFindById() {
        RoleStore store = new RoleStore();
        Role first = new Role("first");
        store.add(first);
        store.add(new Role("second"));
        store.add(new Role("third"));
        Assert.assertThat(store.findById("first"), is(first));
    }
}