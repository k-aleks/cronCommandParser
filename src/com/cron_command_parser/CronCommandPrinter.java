package com.cron_command_parser;

import java.util.List;
import java.util.stream.Collectors;

public class CronCommandPrinter {
    private static final String EOL = "\r\n";

    public String print(final CronCommand cronCommand) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTimeFieldLine("minute", cronCommand.getMinutes()));
        sb.append(getTimeFieldLine("hour", cronCommand.getHours()));
        sb.append(getTimeFieldLine("day of month", cronCommand.getDaysOfMonth()));
        sb.append(getTimeFieldLine("month", cronCommand.getMonths()));
        sb.append(getTimeFieldLine("day of week", cronCommand.getDaysOfWeek()));
        sb.append(getLine("command", cronCommand.getCommand()));
        return sb.toString();
    }

    private String getTimeFieldLine(String name, List<Integer> timePoints) {
        String timePointsString = timePoints.stream().map(Object::toString).collect(Collectors.joining(" "));
        return getLine(name, timePointsString);
    }

    private String getLine(String lineName, String lineValue) {
        return String.format("%-14s%s%s", lineName, lineValue, EOL);
    }
}
