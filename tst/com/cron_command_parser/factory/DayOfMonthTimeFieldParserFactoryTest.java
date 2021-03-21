package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfMonthTimeFieldParserFactoryTest {

    @Test
    void create_shouldCreateTimeFieldParserWithCorrectSettings() {
        TimeFieldParser timeFieldParser = new DayOfMonthTimeFieldParserFactory().create();

        assertEquals(1, timeFieldParser.getFrom());
        assertEquals(31, timeFieldParser.getTo());
    }
}