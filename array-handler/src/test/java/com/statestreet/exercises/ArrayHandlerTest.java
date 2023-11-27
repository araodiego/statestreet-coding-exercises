package com.statestreet.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTest {

    @Test
    void testBreakIntoArray() {
        assertArrayEquals(new String[]{"M", "y", " ", "t", "e", "s", "t"}, ArrayHandler.breakIntoArray("My test"));
    }

    @Test
    void testSortArray() {
        String[] inputArray = {"M", "y", " ", "t", "e", "s", "t"};
        String[] expectedArray = {" ", "M", "e", "s", "t", "t", "y"};
        assertArrayEquals(expectedArray, ArrayHandler.sortArray(inputArray));
    }

    @Test
    void testArrayToString() {
        String[] inputArray = {" ", "M", "e", "s", "t", "t", "y"};
        assertEquals(" Mestty", ArrayHandler.arrayToString(inputArray));
    }
}