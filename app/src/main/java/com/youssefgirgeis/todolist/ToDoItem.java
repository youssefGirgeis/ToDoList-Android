package com.youssefgirgeis.todolist;

/**
 * Created by youssefyacoub on 2016-10-27.
 */

public class ToDoItem {

    private String desc;
    private boolean isComplete;

    public ToDoItem(String desc, boolean isComplete){

        this.desc = desc;
        this.isComplete = isComplete;
    }

    public String getDesc(){

        return desc;
    }

    public boolean isComplete(){

        return isComplete;
    }

    public String toString(){

        return getDesc();
    }

}
