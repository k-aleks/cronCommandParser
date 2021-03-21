package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinutesTimeFieldParserFactoryTest {

    @Test
    void create_shouldCreateTimeFieldParserWithCorrectSettings() {
        TimeFieldParser timeFieldParser = new MinutesTimeFieldParserFactory().create();

        assertEquals(0, timeFieldParser.getFrom());
        assertEquals(59, timeFieldParser.getTo());
    }
}