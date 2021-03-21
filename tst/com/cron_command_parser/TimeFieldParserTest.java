package com.cron_command_parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeFieldParserTest {

    @Test
    void parse_correctlyParsesWildcard() {
        List<Integer> result = new TimeFieldParser(1, 5).parse("*");
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    @Test
    void parse_correctlyParsesPeriodicInterval() {
        List<Integer> result = new TimeFieldParser(0, 19).parse("*/5");
        assertEquals(Arrays.asList(0, 5, 10, 15), result);
    }

    @Test
    void parse_correctlyParsesPeriodicInterval_IncludingTheEdge() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("*/5");
        assertEquals(Arrays.asList(0, 5, 10, 15, 20), result);
    }

    @Test
    void parse_correctlyParsesPeriodicInterval_WhenOnlyOneTimePointFits() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("*/21");
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void parse_correctlyParsesExactNumber() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("2");
        assertEquals(Arrays.asList(2), result);
    }

    @Test
    void parse_correctlyParsesListOfNumbers() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("2,5,7");
        assertEquals(Arrays.asList(2, 5, 7), result);
    }

    @Test
    void parse_correctlyParsesInterval() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("5-10");
        assertEquals(Arrays.asList(5,6,7,8,9,10), result);
    }

    @Test
    void parse_correctlyParsesListOfIntervals() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("5-10,12-15");
        assertEquals(Arrays.asList(5,6,7,8,9,10,12,13,14,15), result);
    }

    @Test
    void parse_correctlyParsesListOfIntervalsWithListOfNumbers() {
        List<Integer> result = new TimeFieldParser(0, 20).parse("5-10,12,15");
        assertEquals(Arrays.asList(5,6,7,8,9,10,12,15), result);
    }
}