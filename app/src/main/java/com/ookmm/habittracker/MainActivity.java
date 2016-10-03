package com.ookmm.habittracker;

/*
    HabitTracker: Add habits and keeps track of habit completions
    Copyright (C) 2016 ookmm
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<Habit> habitArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Collection<Habit> habits = HabitListController.getHabitList().getHabits();
        final ArrayList<Habit> list = new ArrayList<Habit>(habits);

        ListView habitListView = (ListView) findViewById(R.id.chooseHabitListListView);
        habitArrayAdapter = new ArrayAdapter<Habit>(
                this, android.R.layout.simple_list_item_1, list);

        habitListView.setAdapter(habitArrayAdapter);

        // Add ability to click on habit
        habitListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int position, long id) {


                Habit habit = list.get(position);
                HabitListController.getHabitList().deleteHabit(habit);


                return false;
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        habitArrayAdapter.clear();
        habitArrayAdapter.addAll(HabitListController.getHabitList().getHabits());
        habitArrayAdapter.notifyDataSetChanged();
    }



    /* Go to Add New Habit screen when pressed */
    public void addNewHabit(View view) {
        Intent intent = new Intent(this, AddNewHabitActivity.class);
        startActivity(intent);
    }


}
