package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysOfWeekTimeFieldParserFactoryTest {

    @Test
    void create_shouldCreateTimeFieldParserWithCorrectSettings() {
        TimeFieldParser timeFieldParser = new DaysOfWeekTimeFieldParserFactory().create();

        assertEquals(1, timeFieldParser.getFrom());
        assertEquals(7, timeFieldParser.getTo());
    }
}