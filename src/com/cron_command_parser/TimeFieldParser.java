package com.cron_command_parser;

import java.util.ArrayList;
import java.util.List;

public class TimeFieldParser {
    private final int from;
    private final int to;

    public TimeFieldParser(final int from, final int to) {
        this.from = from;
        this.to = to;
    }

    public List<Integer> parse(String input) {
        List<Integer> res = new ArrayList<>();
        if (input.equals("*")) {
            for (int i = from; i <= to; i++) {
                res.add(i);
            }
            return res;
        }
        if (input.contains("*/")) {
            String periodStr = input.substring(input.indexOf("*/") + 2);
            int period = Integer.parseInt(periodStr);
            int count = ((to - from) + period) / period;
            for (int i = 0; i < count; i++) {
                res.add(i * period);
            }
            return res;
        }

        String[] simpleParts = input.split(",");
        for (String part : simpleParts) {
            if (part.contains("-")) {
                String[] split = part.split("-");
                int partFrom = Integer.parseInt(split[0]);
                int partTo = Integer.parseInt(split[1]);
                for (int i = partFrom; i <= partTo; i++) {
                    res.add(i);
                }
            } else {
                res.add(Integer.parseInt(part));
            }
        }
        return res;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
