package com.ookmm.habittracker;

/*
    Test cases related to functions in Habit.java
 */

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class HabitTest extends ActivityInstrumentationTestCase2 {
    public HabitTest() {
        super(MainActivity.class);
    }

    public void testHabit() {
        String habitName = "Read novel";
        List<String> occurrenceDaysList = new ArrayList<>();

        occurrenceDaysList.add("Monday");
        occurrenceDaysList.add("Tuesday");
        occurrenceDaysList.add("Friday");
        occurrenceDaysList.add("Sunday");

        Habit habit = new Habit(habitName, occurrenceDaysList);

        assertTrue("Habit Name is not equal", habitName.equals(habit.getHabitName()));

        // Testing habitName to string
        assertTrue("Habit Name.toString is not equal",
                habitName.toString().equals(habit.getHabitName()));

        String day1 = "Monday";
        String day2 = "Tuesday";
        String day3 = "Friday";
        String day4 = "Sunday";

        // Get the occurrence days list
        List<String> testListDays = habit.getOccurrenceDaysList();

        String value1 = testListDays.get(0);
        assertTrue("Day 1 not the same", day1.equals(value1));

        String value2 = testListDays.get(1);
        assertTrue("Day 2 not the same", day2.equals(value2));

        String value3 = testListDays.get(2);
        assertTrue("Day 3 not the same", day3.equals(value3));

        String value4 = testListDays.get(3);
        assertTrue("Day 4 not the same", day4.equals(value4));


        Date enteredDate = habit.getEnteredDate();
        Date testDate = new Date();



        assertTrue("Year not the same", enteredDate.getYear() == testDate.getYear());
        assertTrue("Month not the same", enteredDate.getMonth() == testDate.getMonth());
        assertTrue("Day not the same", enteredDate.getDay() == testDate.getDay());


        // Testing for habit with a supplied date
        String habitName2 = "Sleep";
        GregorianCalendar gc = new GregorianCalendar(2015, 10, 13);
        Date testDate2 = gc.getTime();
        Habit habit2 = new Habit(habitName2, occurrenceDaysList, testDate2);

        assertTrue("Habit2 Name is not equal", habitName2.equals(habit2.getHabitName()));

        assertTrue("Habit is complete", habit2.isComplete() == Boolean.FALSE);

        habit2.setToComplete();
        assertTrue("Habit is not complete", habit2.isComplete() == Boolean.TRUE);

        habit2.setToComplete();
        assertTrue("Habit is not complete", habit2.isComplete() == Boolean.TRUE);

        habit2.addCompletionCount();
        assertTrue("Complete count not 1", habit2.getCompletionCount() == 1);

        habit2.addCompletionCount();
        assertTrue("Complete count not 2", habit2.getCompletionCount() == 2);

        habit2.addCompletionCount();
        assertTrue("Complete count not 3", habit2.getCompletionCount() == 3);


    }
}
