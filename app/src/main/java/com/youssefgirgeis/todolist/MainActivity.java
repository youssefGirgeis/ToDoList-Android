package com.youssefgirgeis.todolist;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ToDoListManager listManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView todoList = (ListView) findViewById(R.id.todo_list);

        listManager = new ToDoListManager(getApplicationContext());


        ToDoItemAdapter adapter = new ToDoItemAdapter(this, listManager.getList());

        todoList.setAdapter(adapter);

        ImageButton addButton = (ImageButton) findViewById(R.id.add_item);
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onAddButtonClick();
            }
        });
    }


    private void onAddButtonClick(){

        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Item");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                ToDoItem item = new ToDoItem(input.getText().toString(), false);
                listManager.addItem(item);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });

        builder.show();
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

            if(convertView == null) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.to_do_item_layout, parent, false);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.item);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

            textView.setText(items.get(position).getDesc());
            checkBox.setChecked(items.get(position).isComplete());

            convertView.setTag(items.get(position));

            convertView.setOnClickListener(new View.OnClickListener(){

               public void onClick(View v){

                   ToDoItem item = (ToDoItem) v.getTag();
                   item.toggleComplete();
                   notifyDataSetChanged();
               }
            });

            return convertView;
        }

    }
}
