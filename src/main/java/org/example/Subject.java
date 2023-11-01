package org.example;
import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Task> listTask;
    private String name;
    public Subject(String name){
        this.name = name;
        this.listTask = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addTask(String task){
        this.listTask.add(new Task(task));
        System.out.println("Task added to the list");
    }

    public void listTask(){
        for(Task task: this.listTask){
            System.out.println(task.getTask());
        }
    }


}
