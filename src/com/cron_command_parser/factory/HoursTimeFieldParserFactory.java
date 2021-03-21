package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;

public class HoursTimeFieldParserFactory {
    public TimeFieldParser create() {
        return new TimeFieldParser(0, 23);
    }
}
