package com.ookmm.habittracker;

/*
    Activity to view the details about a particular habit.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewHabitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_habit_detail);
    }
}
