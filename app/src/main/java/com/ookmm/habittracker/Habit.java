package com.ookmm.habittracker;

/*
    The model for a habit
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Habit {

    private String habitName;
    private Date enteredDate;
    private List<String> occurrenceDaysList;
    private Boolean completionState;
    private Integer completionCount;

    public Habit(String habitName, List<String> occurrenceDaysList) {
        this.habitName = habitName;
        // Initialize date to today's date
        this.enteredDate = new Date();
        this.occurrenceDaysList = occurrenceDaysList;
        this.completionState = Boolean.FALSE;
        this.completionCount = 0;
    }

    public Habit(String habitName, List<String> occurrenceDaysList, Date enteredDate) {
        this.habitName = habitName;
        // Allow user to enter their own date
        this.enteredDate = enteredDate;
        this.occurrenceDaysList = occurrenceDaysList;
        this.completionState = Boolean.FALSE;
        this.completionCount = 0;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public List<String> getOccurrenceDaysList() {
        return occurrenceDaysList;
    }

    public void setOccurrenceDaysList(List<String> occurrenceDaysList) {
        this.occurrenceDaysList = occurrenceDaysList;
    }

    public void setToComplete() {
        this.completionState = Boolean.TRUE;
    }

    public Boolean isComplete() {
        return completionState;
    }

    public Integer getCompletionCount() {
        return completionCount;
    }

    // Would probably go to the Controller
    public void addCompletionCount() {
        this.completionCount += 1;
    }

    @Override
    public String toString(){
        return getHabitName();
    }

}
