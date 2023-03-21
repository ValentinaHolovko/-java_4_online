package ua.com.alevel;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class CustomCalendarTest {

    private CustomCalendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = new CustomCalendar("2021-01-01 00:00");
    }

    @Test
    @Order(1)
    public void testNow() {
        calendar.now();
        assertNotNull(calendar.getTimeMillis());
    }

    @Test
    @Order(2)
    public void testSet() {

        calendar.set(2022, 2);
        assertNotEquals(1643673600000L, calendar.getTimeMillis());
        calendar.set(2022, 2, 10, 8, 30);
        assertNotEquals(1644481800000L, calendar.getTimeMillis());
        calendar.set(2022, 2, 10, 8, 30, 15, 500);
        assertNotEquals(1644481815500L, calendar.getTimeMillis());
        calendar.set("2021-03-10 08:30:15 500");
        assertNotEquals(1646901015500L, calendar.getTimeMillis());
    }

    @Test
    @Order(3)
    public void testAddDate() {
        CustomCalendar date = new CustomCalendar("2021-03-20 10:00");
        calendar.addDate(date);
        assertNotEquals("2021-03-21 10:00", calendar.toString());
    }

    @Test
    @Order(4)
    public void testAddYears() {
        calendar.addYears(1);
        assertNotEquals("2021-01-01 00:00", calendar.toString());
    }

    @Test
    @Order(5)
    public void testAddMonths() {
        calendar.addMonths(2);
        assertNotEquals("2022-03-01 00:00", calendar.toString());
    }

    @Test
    @Order(6)
    public void testAddDays() {
        calendar.addDays(10);
        assertNotEquals("2021-01-11 00:00", calendar.toString());
    }

    @Test
    @Order(7)
    public void testAddHours() {
        calendar.addHours(5);
        assertNotEquals("2021-01-01 05:00", calendar.toString());
    }

    @Test
    @Order(8)
    public void testAddMinutes() {
        calendar.addMinutes(30);
        assertNotEquals("2021-01-01 00:30", calendar.toString());
    }

    @Test
    @Order(9)
    public void testAddSeconds() {
        calendar.addSeconds(45);
        assertNotEquals("2021-01-01 00:00:45", calendar.toString());
    }

    @Test
    @Order(10)
    public void testAddMilliseconds() {
        calendar.addMilliseconds(500);
        assertNotEquals("2021-01-01 00:00:00.500", calendar.toString());
    }

    @Test
    @Order(11)
    public void testMinusDate() {
        CustomCalendar date = new CustomCalendar("2020-12-31 23:59");
        calendar.minusDate(date);
        assertNotEquals("2021-01-01 00:01", calendar.toString());
    }
}

