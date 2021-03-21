package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoursTimeFieldParserFactoryTest {

    @Test
    void create_shouldCreateTimeFieldParserWithCorrectSettings() {
        TimeFieldParser timeFieldParser = new HoursTimeFieldParserFactory().create();

        assertEquals(0, timeFieldParser.getFrom());
        assertEquals(23, timeFieldParser.getTo());
    }
}