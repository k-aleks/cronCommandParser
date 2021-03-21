package com.cron_command_parser;

import com.cron_command_parser.factory.CronCommandParserFactory;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(String.format("Incorrect number of arguments. Expected 1 but found %s", args.length));
            System.out.println("USAGE: your-program \"*/15 0 1,15 * 1-5 /usr/bin/find\"");
        }

        CronCommand cronCommand = new CronCommandParserFactory().create().parse(args[0]);

        String printed = new CronCommandPrinter().print(cronCommand);

        System.out.println(printed);
    }
}

