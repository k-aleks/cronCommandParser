package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthsTimeFieldParserFactoryTest {

    @Test
    void create_shouldCreateTimeFieldParserWithCorrectSettings() {
        TimeFieldParser timeFieldParser = new MonthsTimeFieldParserFactory().create();

        assertEquals(1, timeFieldParser.getFrom());
        assertEquals(12, timeFieldParser.getTo());
    }
}