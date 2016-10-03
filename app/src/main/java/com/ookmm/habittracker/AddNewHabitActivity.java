package com.ookmm.habittracker;

/*
    Activity to add new habits to habit tracker

    Note: The habit date picker is not currently implemented.
          A new date object is created each time a new habit is added.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddNewHabitActivity extends AppCompatActivity {

    private ArrayAdapter<Habit> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_habit);

        Button saveButton = (Button) findViewById(R.id.saveNewEntryButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveHabitAction();
                finish();
            }
        });
    }

    // Get input from user to create new habit
    public void saveHabitAction() {

        HabitListController hlc = new HabitListController();

        // Get habit name
        EditText habitNameTextView = (EditText) findViewById(R.id.newHabitNameEditText);
        String habitName = habitNameTextView.getText().toString();

        //~ Get habit date
        Date habitDateTextView = new Date();


        // Get occurrence days
        CheckBox monCheckBox = (CheckBox) findViewById(R.id.mondayCheckBox);
        boolean isMonChecked = monCheckBox.isChecked();

        CheckBox tueCheckBox = (CheckBox) findViewById(R.id.tuesdayCheckBox);
        boolean isTueChecked = tueCheckBox.isChecked();

        CheckBox wedCheckBox = (CheckBox) findViewById(R.id.wednesdayCheckBox);
        boolean isWedCheckBox = wedCheckBox.isChecked();

        CheckBox thuCheckBox = (CheckBox) findViewById(R.id.thursdayCheckBox);
        boolean isThuCheckBox = thuCheckBox.isChecked();

        CheckBox friCheckBox = (CheckBox) findViewById(R.id.fridayCheckBox);
        boolean isFriCheckBox = friCheckBox.isChecked();

        CheckBox satCheckBox = (CheckBox) findViewById(R.id.fridayCheckBox);
        boolean isSatCheckBox = satCheckBox.isChecked();

        CheckBox sunCheckBox = (CheckBox) findViewById(R.id.sundayCheckBox);
        boolean isSunChecked = sunCheckBox.isChecked();


        // Create a list of occurrence days and add days that are checked to it
        List<String> occurrenceDaysList = new ArrayList<>();

        if(isMonChecked) {
            occurrenceDaysList.add("Monday");
        }
        if(isTueChecked) {
            occurrenceDaysList.add("Tuesday");
        }
        if(isWedCheckBox) {
            occurrenceDaysList.add("Wednesday");
        }
        if(isThuCheckBox) {
            occurrenceDaysList.add("Thursday");
        }
        if(isFriCheckBox) {
            occurrenceDaysList.add("Friday");
        }
        if(isSatCheckBox) {
            occurrenceDaysList.add("Saturday");
        }
        if(isSunChecked) {
            occurrenceDaysList.add("Sunday");
        }

        hlc.addHabit(new Habit(habitName, occurrenceDaysList, habitDateTextView));


    }
}
