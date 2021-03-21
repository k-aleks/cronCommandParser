
# About
This is a command line application which parses a cron string and expands each field to show the times at which it will run.   
The application only considers the standard cron format with five time fields (minute, hour, day of month, month, and day of week) plus a command.

`~$ cronCommandParser "*/15 0 1,15 * 1-5 /usr/bin/find"`

```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

# How to build and run
You would need [Maven](https://maven.apache.org/) in order to build the source code.
Install Maven first and then execute the following command:
```
mvn clean compile assembly:single
```
After the compilation is finished successfully you will find an executable `jar` file in the `target/` directory.  
To use the command line application simply run the following:
```
java -jar cronCommandParser.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```
