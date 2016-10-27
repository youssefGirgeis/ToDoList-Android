package com.youssefgirgeis.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView todoList = (ListView) findViewById(R.id.todo_list);

        String[] values = new String[] {"millk", "asda", "aaaa", "wwww"};

        ArrayList<String> list = new ArrayList<String>();

        for(int i=0; i<values.length; i++){

            list.add(values[i]);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        todoList.setAdapter(adapter);
    }
}
