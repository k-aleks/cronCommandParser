package com.cron_command_parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CronCommandPrinterTest {
    String EXPECTED = "minute        0 15 30 45\n" +
                    "hour          0\n" +
                    "day of month  1 15\n" +
                    "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                    "day of week   1 2 3 4 5\n" +
                    "command       /usr/bin/find";
    @Mock
    CronCommand cronCommand;

    @Test
    void print() {
        when(cronCommand.getMinutes()).thenReturn(Arrays.asList(0, 15, 30, 45));
        when(cronCommand.getHours()).thenReturn(Arrays.asList(0));
        when(cronCommand.getDaysOfMonth()).thenReturn(Arrays.asList(1, 15));
        when(cronCommand.getMonths()).thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        when(cronCommand.getDaysOfWeek()).thenReturn(Arrays.asList(1, 2, 3, 4, 5));
        when(cronCommand.getCommand()).thenReturn("/usr/bin/find");

        String res = new CronCommandPrinter().print(cronCommand);

        assertEquals(EXPECTED, res);
    }
}