package com.cron_command_parser;

import java.util.List;

public class CronCommand {
    private final List<Integer> minutes;
    private final List<Integer> hours;
    private final List<Integer> daysOfMonth;
    private final List<Integer> months;
    private final List<Integer> daysOfWeek;
    private final String command;

    public CronCommand(List<Integer> minutes,
                       List<Integer> hours,
                       List<Integer> daysOfMonth,
                       List<Integer> months,
                       List<Integer> daysOfWeek,
                       String command) {
        this.minutes = minutes;
        this.hours = hours;
        this.daysOfMonth = daysOfMonth;
        this.months = months;
        this.daysOfWeek = daysOfWeek;
        this.command = command;
    }

    public List<Integer> getMinutes() {
        return minutes;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public List<Integer> getDaysOfMonth() {
        return daysOfMonth;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public List<Integer> getDaysOfWeek() {
        return daysOfWeek;
    }

    public String getCommand() {
        return command;
    }
}
