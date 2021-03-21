package com.cron_command_parser.factory;

import com.cron_command_parser.CronCommandParser;

public class CronCommandParserFactory {
    private final MinutesTimeFieldParserFactory minutesTimeFieldParserFactory;
    private final HoursTimeFieldParserFactory hoursTimeFieldParserFactory;
    private final DayOfMonthTimeFieldParserFactory dayOfMonthTimeFieldParserFactory;
    private final MonthsTimeFieldParserFactory monthsTimeFieldParserFactory;
    private final DaysOfWeekTimeFieldParserFactory daysOfWeekTimeFieldParserFactory;

    public CronCommandParserFactory() {
        this(
                new MinutesTimeFieldParserFactory(),
                new HoursTimeFieldParserFactory(),
                new DayOfMonthTimeFieldParserFactory(),
                new MonthsTimeFieldParserFactory(),
                new DaysOfWeekTimeFieldParserFactory());
    }

    public CronCommandParserFactory(final MinutesTimeFieldParserFactory minutesTimeFieldParserFactory,
                                    final HoursTimeFieldParserFactory hoursTimeFieldParserFactory,
                                    final DayOfMonthTimeFieldParserFactory dayOfMonthTimeFieldParserFactory,
                                    final MonthsTimeFieldParserFactory monthsTimeFieldParserFactory,
                                    final DaysOfWeekTimeFieldParserFactory daysOfWeekTimeFieldParserFactory) {
        this.minutesTimeFieldParserFactory = minutesTimeFieldParserFactory;
        this.hoursTimeFieldParserFactory = hoursTimeFieldParserFactory;
        this.dayOfMonthTimeFieldParserFactory = dayOfMonthTimeFieldParserFactory;
        this.monthsTimeFieldParserFactory = monthsTimeFieldParserFactory;
        this.daysOfWeekTimeFieldParserFactory = daysOfWeekTimeFieldParserFactory;
    }

    public CronCommandParser create() {
        return new CronCommandParser(
                minutesTimeFieldParserFactory.create(),
                hoursTimeFieldParserFactory.create(),
                dayOfMonthTimeFieldParserFactory.create(),
                monthsTimeFieldParserFactory.create(),
                daysOfWeekTimeFieldParserFactory.create());
    }
}

