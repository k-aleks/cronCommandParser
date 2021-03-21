package com.cron_command_parser.factory;

import com.cron_command_parser.CronCommandParser;
import com.cron_command_parser.TimeFieldParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CronCommandParserFactoryTest {
    @Mock
    MinutesTimeFieldParserFactory minutesTimeFieldParserFactory;
    @Mock
    HoursTimeFieldParserFactory hoursTimeFieldParserFactory;
    @Mock
    DayOfMonthTimeFieldParserFactory dayOfMonthTimeFieldParserFactory;
    @Mock
    MonthsTimeFieldParserFactory monthsTimeFieldParserFactory;
    @Mock
    DaysOfWeekTimeFieldParserFactory daysOfWeekTimeFieldParserFactory;
    @Mock
    TimeFieldParser minutesTimeFieldParser;
    @Mock
    TimeFieldParser hoursTimeFieldParser;
    @Mock
    TimeFieldParser dayOfMonthTimeFieldParser;
    @Mock
    TimeFieldParser monthsTimeFieldParser;
    @Mock
    TimeFieldParser daysOfWeekTimeFieldParser;

    @Test
    void create() {
        when(minutesTimeFieldParserFactory.create()).thenReturn(minutesTimeFieldParser);
        when(hoursTimeFieldParserFactory.create()).thenReturn(hoursTimeFieldParser);
        when(dayOfMonthTimeFieldParserFactory.create()).thenReturn(dayOfMonthTimeFieldParser);
        when(monthsTimeFieldParserFactory.create()).thenReturn(monthsTimeFieldParser);
        when(daysOfWeekTimeFieldParserFactory.create()).thenReturn(daysOfWeekTimeFieldParser);

        CronCommandParserFactory cronCommandParserFactory = new CronCommandParserFactory(
                minutesTimeFieldParserFactory,
                hoursTimeFieldParserFactory,
                dayOfMonthTimeFieldParserFactory,
                monthsTimeFieldParserFactory,
                daysOfWeekTimeFieldParserFactory);
        CronCommandParser cronCommandParser = cronCommandParserFactory.create();

        assertSame(minutesTimeFieldParser, cronCommandParser.getMinutesParser());
        assertSame(hoursTimeFieldParser, cronCommandParser.getHoursParser());
        assertSame(dayOfMonthTimeFieldParser, cronCommandParser.getDayOfMonthParser());
        assertSame(monthsTimeFieldParser, cronCommandParser.getMonthsParser());
        assertSame(daysOfWeekTimeFieldParser, cronCommandParser.getDaysOfWeekParser());

    }
}