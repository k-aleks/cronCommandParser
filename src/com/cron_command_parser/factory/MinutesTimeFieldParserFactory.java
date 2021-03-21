package com.cron_command_parser.factory;

import com.cron_command_parser.TimeFieldParser;

public class MinutesTimeFieldParserFactory {
    public TimeFieldParser create() {
        return new TimeFieldParser(0, 59);
    }
}
