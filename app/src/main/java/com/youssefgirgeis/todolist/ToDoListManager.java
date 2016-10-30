package com.youssefgirgeis.todolist;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by youssefyacoub on 2016-10-29.
 */

public class ToDoListManager {

    private SharedPreferences savedData;

    private static final String APP_PREFERENCES = "todoapp";
    private static final String TODO_ITEMS = "itemslist";

    List<ToDoItem> items;

    public ToDoListManager(Context context){

       savedData = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        String json = savedData.getString(TODO_ITEMS, null);

        if(json == null){
            items = new ArrayList<>();
        }else {
            Type type = new TypeToken<List<ToDoItem>>(){}.getType();
            items = new Gson().fromJson(json, type);
        }

    }

    public List<ToDoItem> getList(){
        return items;
    }

    public void addItem(ToDoItem item){

        items.add(item);
        saveList();
    }

    public void saveList(){

        SharedPreferences.Editor edit = savedData.edit();
        edit.clear();

        String json = new Gson().toJson(items);

        edit.putString(TODO_ITEMS, json);
        edit.apply();
    }
}
