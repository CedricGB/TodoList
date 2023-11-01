package org.example;

public class Task {

    private String task;
    public static int id;

    public Task(String task){
        this.task = task;
        this.id = id + 1;
    }
    public String getTask(){
        return this.task;
    }
    public int getId(){
        return this.id;
    }

}
