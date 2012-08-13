package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;

    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;
        year = getValidatedYear();
        month = getValidatedMonth();
        date = getValidatedDate();
        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = getValidatedHour();
            minute = getValidatedMinute();

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getValidatedMinute() {
        int minute = checkLengthAndType(14, 2, "Minute");
        checkBounds(minute, 0, 59, "Minute");
        return minute;
    }

    private void checkBounds(int value, int lowerBound, int upperBound, String dateEntity) {
        if (value < lowerBound || value > upperBound)
            throw new IllegalArgumentException(dateEntity + " cannot be less than 0 or more than 59");
    }

    private int getValidatedHour() {
        int hour = checkLengthAndType(11, 2, "Hour");
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Hour cannot be less than 0 or more than 23");
        return hour;
    }

    private int getValidatedDate() {
        int date = checkLengthAndType(8, 2, "Date");
        if (date < 1 || date > 31)
            throw new IllegalArgumentException("Date cannot be less than 1 or more than 31");
        return date;
    }

    private int getValidatedMonth() {
        int month = checkLengthAndType(5, 2, "Month");
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month cannot be less than 1 or more than 12");
        return month;
    }

    private int getValidatedYear() {
        int year = checkLengthAndType(0, 4, "Year");
        if (year < 2000 || year > 2012)
            throw new IllegalArgumentException("Year cannot be less than 2000 or more than 2012");
        return year;
    }

    private int checkLengthAndType(int startIndex, int length, String calendarEntity) {
        int year;
        try {
            String yearString = dateAndTimeString.substring(startIndex, startIndex + length);
            year = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("%s string is less than %d characters", calendarEntity, length));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(calendarEntity + " is not an integer");
        }
        return year;
    }
}
