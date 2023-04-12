package com.example.thebest_youdo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RateCalculatorTest {

    @Test
    void testCalc() {
        assertEquals(7.75f, RateCalculator.calc(1, 10.0f, 3L).floatValue());
        assertEquals(5.5f, RateCalculator.calc(1, 10.0f, 1L).floatValue());
        assertEquals(8.25f, RateCalculator.calc(3, 10.0f, 3L).floatValue());
        assertEquals(7.5f, RateCalculator.calc(0, 10.0f, 3L).floatValue());
        assertEquals(1.0f, RateCalculator.calc(1, 10.0f, 0L).floatValue());
    }
}

