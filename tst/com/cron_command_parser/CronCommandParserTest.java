package com.cron_command_parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CronCommandParserTest {
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

    @Mock
    List<Integer> minutes;
    @Mock
    List<Integer> hours;
    @Mock
    List<Integer> daysOfMonth;
    @Mock
    List<Integer> months;
    @Mock
    List<Integer> daysOfWeek;

    @Captor
    ArgumentCaptor<String> parserInputCaptor;

    CronCommandParser cronCommandParser;

    String INPUT = "one two three four five six seven eight nine";

    @BeforeEach
    public void beforeEach() {
        cronCommandParser = new CronCommandParser(
                minutesTimeFieldParser,
                hoursTimeFieldParser,
                dayOfMonthTimeFieldParser,
                monthsTimeFieldParser,
                daysOfWeekTimeFieldParser);
    }

    @Test
    void parse_createCommandUsingParsersOutputCorrectly() {
        when(minutesTimeFieldParser.parse(anyString())).thenReturn(minutes);
        when(hoursTimeFieldParser.parse(anyString())).thenReturn(hours);
        when(dayOfMonthTimeFieldParser.parse(anyString())).thenReturn(daysOfMonth);
        when(monthsTimeFieldParser.parse(anyString())).thenReturn(months);
        when(daysOfWeekTimeFieldParser.parse(anyString())).thenReturn(daysOfWeek);

        CronCommand cronCommand = cronCommandParser.parse(INPUT);

        assertEquals(minutes, cronCommand.getMinutes());
        assertEquals(hours, cronCommand.getHours());
        assertEquals(daysOfMonth, cronCommand.getDaysOfMonth());
        assertEquals(months, cronCommand.getMonths());
        assertEquals(daysOfWeek, cronCommand.getDaysOfWeek());
        assertEquals("six seven eight nine", cronCommand.getCommand());
    }

    @Test
    void parse_callsMinutesTimeFieldParserWithTheCorrectArgurment() {
        cronCommandParser.parse(INPUT);

        verify(minutesTimeFieldParser).parse(parserInputCaptor.capture());
        assertEquals("one", parserInputCaptor.getValue());
    }

    @Test
    void parse_callsHoursTimeFieldParserWithTheCorrectArgurment() {
        cronCommandParser.parse(INPUT);

        verify(hoursTimeFieldParser).parse(parserInputCaptor.capture());
        assertEquals("two", parserInputCaptor.getValue());
    }

    @Test
    void parse_callsDayOfMonthTimeFieldParserWithTheCorrectArgurment() {
        cronCommandParser.parse(INPUT);

        verify(dayOfMonthTimeFieldParser).parse(parserInputCaptor.capture());
        assertEquals("three", parserInputCaptor.getValue());
    }

    @Test
    void parse_callsMonthsTimeFieldParserWithTheCorrectArgurment() {
        cronCommandParser.parse(INPUT);

        verify(monthsTimeFieldParser).parse(parserInputCaptor.capture());
        assertEquals("four", parserInputCaptor.getValue());
    }

    @Test
    void parse_callsDaysOfWeekTimeFieldParserWithTheCorrectArgurment() {
        cronCommandParser.parse(INPUT);

        verify(daysOfWeekTimeFieldParser).parse(parserInputCaptor.capture());
        assertEquals("five", parserInputCaptor.getValue());
    }
}