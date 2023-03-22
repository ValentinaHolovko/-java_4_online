package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarController {
    private final CustomCalendar calendar;
    private final SimpleDateFormat dateFormat;

    public CalendarController() {
        this.calendar = new CustomCalendar();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void start() throws IOException {
        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Display current date and time");
            System.out.println("2. Add years to current date");
            System.out.println("3. Add months to current date");
            System.out.println("4. Add days to current date");
            System.out.println("5. Add hours to current date");
            System.out.println("6. Add minutes to current date");
            System.out.println("7. Add seconds to current date");
            System.out.println("8. Add milliseconds to current date");
            System.out.println("9. Subtract a date from current date");
            System.out.println("10. Subtract a date in a specific format from current date");
            System.out.println("11. Format current date");
            System.out.println("12. Exit");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1 -> displayCurrentDateAndTime();
                case 2 -> addYearsToCurrentDate();
                case 3 -> addMonthsToCurrentDate();
                case 4 -> addDaysToCurrentDate();
                case 5 -> addHoursToCurrentDate();
                case 6 -> addMinutesToCurrentDate();
                case 7 -> addSecondsToCurrentDate();
                case 8 -> addMilliseconds();
                case 9 -> subtractDate();
                case 10 -> subtractDateInFormat();
                case 11 -> formatCurrentDate();
                case 12 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayCurrentDateAndTime() {
        System.out.println(dateFormat.format(new Date(calendar.getTimeMillis())));
    }

    private void addYearsToCurrentDate() throws IOException {
        System.out.println("Enter the number of years to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int years = Integer.parseInt(br.readLine());
        calendar.addYears(years);
        displayCurrentDateAndTime();
    }

    private void addMonthsToCurrentDate() throws IOException {
        System.out.println("Enter the number of months to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int months = Integer.parseInt(br.readLine());
        calendar.addMonths(months);
        displayCurrentDateAndTime();
    }

    private void addDaysToCurrentDate() throws IOException {
        System.out.println("Enter the number of days to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        calendar.addDays(days);
        displayCurrentDateAndTime();
    }

    private void subtractDate() throws IOException {
        System.out.println("Enter the date to subtract in yyyy-MM-dd HH:mm:ss format:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dateStr = br.readLine();
        try {
            Date date = dateFormat.parse(dateStr);
            calendar.addDate(date);
            displayCurrentDateAndTime();
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }

    private void subtractDateInFormat() throws IOException {
        System.out.println("Enter the date to subtract in a specific format:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dateStr = br.readLine();
        System.out.println("Enter the format of the date:");
        String formatStr = br.readLine();
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            Date date = format.parse(dateStr);
            calendar.addDate(date);
            displayCurrentDateAndTime();
        } catch (ParseException e) {
            System.out.println("Invalid date or format. Please try again.");
        }
    }

    private void formatCurrentDate() throws IOException {
        System.out.println("Enter the format to display the current date and time:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formatStr = br.readLine();
        dateFormat.applyPattern(formatStr);
        displayCurrentDateAndTime();
    }

    private void addHoursToCurrentDate() throws IOException {
        System.out.println("Enter the number of hours to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hours = Integer.parseInt(br.readLine());
        calendar.addHours(hours);
        displayCurrentDateAndTime();
    }

    private void addMinutesToCurrentDate() throws IOException {
        System.out.println("Enter the number of minutes to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minutes = Integer.parseInt(br.readLine());
        calendar.addMinutes(minutes);
        displayCurrentDateAndTime();
    }

    private void addSecondsToCurrentDate() throws IOException {
        System.out.println("Enter the number of seconds to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seconds = Integer.parseInt(br.readLine());
        calendar.addSeconds(seconds);
        displayCurrentDateAndTime();
    }

    private void addMilliseconds() throws IOException {
        System.out.println("Enter the number of milliseconds to add:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int milliseconds = Integer.parseInt(br.readLine());
        calendar.addMilliseconds(milliseconds);
        displayCurrentDateAndTime();
    }
}
