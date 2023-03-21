package ua.com.alevel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomCalendar {
    Calendar calendar;

    public CustomCalendar() {
        calendar = Calendar.getInstance();
    }

    public CustomCalendar(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = dateFormat.parse(format);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void now() {
        calendar = Calendar.getInstance();
    }

    public long getTimeMillis() {
        return calendar.getTimeInMillis();
    }

    public void set(int year, int month) {
        set(year, month, 1, 0, 0, 0, 0);
    }

    public void set(int year, int month, int day, int hour, int minutes) {
        set(year, month, day, hour, minutes, 0, 0);
    }

    public void set(int year, int month, int day, int hour, int minutes, int seconds, int milliseconds) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, seconds);
        calendar.set(Calendar.MILLISECOND, milliseconds);
    }

    public void set(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = dateFormat.parse(format);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDate(CustomCalendar date) {
        calendar.add(Calendar.YEAR, date.calendar.get(Calendar.YEAR));
        calendar.add(Calendar.MONTH, date.calendar.get(Calendar.MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, date.calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.HOUR_OF_DAY, date.calendar.get(Calendar.HOUR_OF_DAY));
        calendar.add(Calendar.MINUTE, date.calendar.get(Calendar.MINUTE));
        calendar.add(Calendar.SECOND, date.calendar.get(Calendar.SECOND));
        calendar.add(Calendar.MILLISECOND, date.calendar.get(Calendar.MILLISECOND));
    }

    public void addYears(int years) {
        calendar.add(Calendar.YEAR, years);
    }

    public void addMonths(int months) {
        calendar.add(Calendar.MONTH, months);
    }

    public void addDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }

    public void addHours(int hours) {
        calendar.add(Calendar.HOUR_OF_DAY, hours);
    }

    public void addMinutes(int minutes) {
        calendar.add(Calendar.MINUTE, minutes);
    }

    public void addSeconds(int seconds) {
        calendar.add(Calendar.SECOND, seconds);
    }

    public void addMilliseconds(int milliseconds) {
        calendar.add(Calendar.MILLISECOND, milliseconds);
    }

    public void minusDate(CustomCalendar date) {
        calendar.add(Calendar.YEAR, -date.calendar.get(Calendar.YEAR));
        calendar.add(Calendar.MONTH, -date.calendar.get(Calendar.MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, -date.calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.HOUR_OF_DAY, -date.calendar.get(Calendar.HOUR_OF_DAY));
        calendar.add(Calendar.MINUTE, -date.calendar.get(Calendar.MINUTE));
        calendar.add(Calendar.SECOND, -date.calendar.get(Calendar.SECOND));
        calendar.add(Calendar.MILLISECOND, -date.calendar.get(Calendar.MILLISECOND));
    }

    public void addDate(Date date) {
    }
}