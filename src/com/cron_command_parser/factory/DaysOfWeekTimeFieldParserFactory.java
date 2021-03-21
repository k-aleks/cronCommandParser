package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;

public class DaysOfWeekTimeFieldParserFactory {
    public TimeFieldParser create() {
        return new TimeFieldParser(1, 7);
    }
}
