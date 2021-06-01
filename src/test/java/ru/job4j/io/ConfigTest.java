package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Vladimir Kutyavin"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentAndSpace() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Vladimir Kutyavin"));
        assertThat(config.value("status"), is(Matchers.nullValue()));
        assertThat(config.value("checked"), is("yes"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithError1() throws IllegalArgumentException {
        String path = "./data/pair_with_error.properties";
        Config config = new Config(path);
        config.load();
    }
}