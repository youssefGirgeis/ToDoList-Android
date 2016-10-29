package com.youssefgirgeis.todolist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youssefyacoub on 2016-10-29.
 */

public class ToDoListManager {

    List<ToDoItem> items;

    public ToDoListManager(){

        items = new ArrayList<ToDoItem>();

        items.add(new ToDoItem("asd", false));
        items.add(new ToDoItem("wqqww", true));
        items.add(new ToDoItem("wwwwww", false));
    }

    public List<ToDoItem> getList(){
        return items;
    }
}
