package com.statestreet.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisibilityCheckerTest {

    @Test
    void testDivisibilityNormalNumbers() {
        assertEquals("1", DivisibilityChecker.getDivisibilityOutput(1));
        assertEquals("2", DivisibilityChecker.getDivisibilityOutput(2));
    }

    @Test
    void testDivisibilityByThree() {
        assertEquals("A", DivisibilityChecker.getDivisibilityOutput(3));
        assertEquals("A", DivisibilityChecker.getDivisibilityOutput(6));
    }

    @Test
    void testDivisibilityByFive() {
        assertEquals("B", DivisibilityChecker.getDivisibilityOutput(5));
        assertEquals("B", DivisibilityChecker.getDivisibilityOutput(10));
    }

    @Test
    void testDivisibilityByThreeAndFive() {
        assertEquals("C", DivisibilityChecker.getDivisibilityOutput(15));
        assertEquals("C", DivisibilityChecker.getDivisibilityOutput(30));
    }
}
