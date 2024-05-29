package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class TASK3Test {

    @Test
    public void testGenerateRandomStringList() {
        int count = 10;
        List<String> list = TASK3.generateRandomStringList(count);
        assertEquals(count, list.size());
    }

    @Test
    public void testCountDistinctItems() {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        int expectedDistinctCount = 4; // apple, banana, orange, grape
        int distinctCount = TASK3.countDistinctItems(list);
        assertEquals(expectedDistinctCount, distinctCount);
    }
}
