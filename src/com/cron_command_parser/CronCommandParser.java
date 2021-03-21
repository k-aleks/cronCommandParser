package com.cron_command_parser;

import java.util.List;

public class CronCommandParser {
    private TimeFieldParser minutesParser;
    private TimeFieldParser hoursParser;
    private TimeFieldParser dayOfMonthParser;
    private TimeFieldParser monthsParser;
    private TimeFieldParser daysOfWeekParser;

    public CronCommandParser(final TimeFieldParser minutesParser,
                             final TimeFieldParser hoursParser,
                             final TimeFieldParser dayOfMonthParser,
                             final TimeFieldParser monthsParser,
                             final TimeFieldParser daysOfWeekParser) {
        this.minutesParser = minutesParser;
        this.hoursParser = hoursParser;
        this.dayOfMonthParser = dayOfMonthParser;
        this.monthsParser = monthsParser;
        this.daysOfWeekParser = daysOfWeekParser;
    }

    public CronCommand parse(final String input) {
        String[] parts = input.split(" ", 6);
        List<Integer> minutes = minutesParser.parse(parts[0]);
        List<Integer> hours = hoursParser.parse(parts[1]);
        List<Integer> daysOfMonth = dayOfMonthParser.parse(parts[2]);
        List<Integer> months = monthsParser.parse(parts[3]);
        List<Integer> daysOfWeek = daysOfWeekParser.parse(parts[4]);
        String command = parts[5];

        return new CronCommand(minutes, hours, daysOfMonth, months, daysOfWeek, command);
    }

    public TimeFieldParser getMinutesParser() {
        return minutesParser;
    }

    public TimeFieldParser getHoursParser() {
        return hoursParser;
    }

    public TimeFieldParser getDayOfMonthParser() {
        return dayOfMonthParser;
    }

    public TimeFieldParser getMonthsParser() {
        return monthsParser;
    }

    public TimeFieldParser getDaysOfWeekParser() {
        return daysOfWeekParser;
    }
}

