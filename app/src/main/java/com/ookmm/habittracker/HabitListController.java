package com.ookmm.habittracker;

/*
    Control for HabitList
 */

public class HabitListController {
    private static HabitList habitList = null;

    // Lazy singleton
    static public HabitList getHabitList() {
        if(habitList == null) {
            habitList = new HabitList();
        }
        return habitList;
    }

    public void addHabit(Habit habit) {
        getHabitList().addHabit(habit);
    }

}
