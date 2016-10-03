package com.ookmm.habittracker;

/*
    The model for habit list
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HabitList {

    protected List<Habit> habitList;

    public HabitList() {
        this.habitList = new ArrayList<Habit>();
    }

    public Habit getHabit(int i) {
        return habitList.get(i);
    }

    public List<Habit> getHabits() {
        return habitList;
    }

    public List<Habit> getHabitsOrdered() {
    /* Returns habitList in ascending order by date */

        Collections.sort(habitList, new Comparator<Habit>() {
            public int compare(Habit h1, Habit h2) {
                return h1.getEnteredDate().compareTo(h2.getEnteredDate());
            }
        });

        return this.habitList;
    }

    public void addHabit(Habit habit) {
        habitList.add(habit);
    }


    public void deleteHabit(Habit habit) {
        habitList.remove(habit);
    }

    public int getCount() {
        return habitList.size();
    }

    public Boolean hasHabit(Habit habit) {
        return habitList.contains(habit);
    }
}
