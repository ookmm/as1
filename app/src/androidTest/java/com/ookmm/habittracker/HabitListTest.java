package com.ookmm.habittracker;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;

public class HabitListTest extends ActivityInstrumentationTestCase2 {
    public HabitListTest() {
        super(MainActivity.class);
    }

    public void testEmptyHabitList() {
        HabitList habitList = new HabitList();
        List<Habit> habits = habitList.getHabits();
        assertTrue("Habit List is empty", habits.size() == 0);
    }

    public void testAddHabit() {
        HabitList habitList = new HabitList();

        String habitName = "Read novel";
        List<String> occurrenceDaysList = new ArrayList<>();

        occurrenceDaysList.add("Monday");
        occurrenceDaysList.add("Tuesday");
        occurrenceDaysList.add("Friday");

        Habit habit = new Habit(habitName, occurrenceDaysList);
        habitList.addHabit(habit);
        assertTrue("Habit List has 1", habitList.getCount() == 1);
        assertTrue("List doesn't contains that habit", habitList.hasHabit(habit));
    }

    public void testDeleteHabit() {
        HabitList habitList = new HabitList();

        String habitName = "Watch TV";
        List<String> occurrenceDaysList = new ArrayList<>();

        occurrenceDaysList.add("Monday");
        occurrenceDaysList.add("Tuesday");
        occurrenceDaysList.add("Sunday");

        Habit habit = new Habit(habitName, occurrenceDaysList);
        habitList.addHabit(habit);
        assertTrue("Habit List has 1", habitList.getCount() == 1);
        assertTrue("List doesn't contains that habit", habitList.hasHabit(habit));

        habitList.deleteHabit(habit);

        assertTrue("Habit List is empty", habitList.getCount() == 0);
        assertFalse("List contains that habit", habitList.hasHabit(habit));
    }


}
