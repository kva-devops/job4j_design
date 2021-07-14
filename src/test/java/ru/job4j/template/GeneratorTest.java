package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

//    @Test
//    public void produce() {
//        Generator generator = new GeneratorStr();
//        Map<String, String> mapKeys = new HashMap<>();
//        mapKeys.put("key1", "value1");
//        String templateStr = "This is ${key1}";
//        String expected = "This is value1";
//        String result = generator.produce(templateStr, mapKeys);
//        assertThat(result, is(expected));
//    }
//
//    @Test(expected = Exception.class)
//    public void notKeyInMap() {
//        Generator generator = new GeneratorStr();
//        Map<String, String> mapKeys = new HashMap<>();
//        mapKeys.put("key1", "value1");
//        String templateStr = "This is ${key2}";
//        generator.produce(templateStr, mapKeys);
//    }
//
//    @Test(expected = Exception.class)
//    public void moreKeyInMap() {
//        Generator generator = new GeneratorStr();
//        Map<String, String> mapKeys = new HashMap<>();
//        mapKeys.put("key1", "value1");
//        mapKeys.put("key2", "value2");
//        String templateStr = "This is ${key1}";
//        generator.produce(templateStr, mapKeys);
//    }

}