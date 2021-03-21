package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;

public class MonthsTimeFieldParserFactory {
    public TimeFieldParser create() {
        return new TimeFieldParser(1, 12);
    }
}
