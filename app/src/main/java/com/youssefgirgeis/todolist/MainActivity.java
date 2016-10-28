package com.youssefgirgeis.todolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView todoList = (ListView) findViewById(R.id.todo_list);

/*        String[] values = new String[] {"millk", "asda", "aaaa", "wwww"};

        ArrayList<String> list = new ArrayList<String>();

        for(int i=0; i<values.length; i++){

            list.add(values[i]);
        }*/

        List<ToDoItem> items = new ArrayList<ToDoItem>();

        items.add(new ToDoItem("asd", false));
        items.add(new ToDoItem("wqqww", true));
        items.add(new ToDoItem("wwwwww", false));

        ToDoItemAdapter adapter = new ToDoItemAdapter(this, items);

        todoList.setAdapter(adapter);
    }

    private class ToDoItemAdapter extends ArrayAdapter<ToDoItem>{

        private Context context;
        private List<ToDoItem> items;

        public ToDoItemAdapter(Context context, List<ToDoItem> items){

            super(context, -1, items);
            this.context = context;
            this.items = items;
        }

        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.to_do_item_layout, parent, false);

            TextView textView = (TextView) convertView.findViewById(R.id.item);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

            textView.setText(items.get(position).getDesc());
            checkBox.setChecked(items.get(position).isComplete());

            return convertView;
        }

    }
}
