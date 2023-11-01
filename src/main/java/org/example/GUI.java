package org.example;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class GUI implements UserInterface{
        private List<Subject> listSubjects;
        private Scanner scanner;
        public GUI(){
            this.listSubjects = new ArrayList<>();
            this.scanner = new Scanner(System.in);
        }
    public void start(){

        System.out.println("Welcome to the todolist");


        while(true){
            System.out.println("Choose the option :");
            System.out.println("1/ List the subject and their task ");
            System.out.println("2/ Add a subject");
            System.out.println("3/ Add a task");
            System.out.println("4/ Remove a Subject");
            System.out.println("5/ Quit");

        String input = scanner.nextLine();

            if(input.equals("1")){
                if(this.listSubjects.isEmpty()){

                    firstSubject();

                } else {
                    for(Subject subject: this.listSubjects){
                        System.out.println(subject.getName());
                        subject.listTask();
                    }
                }
            }
            if(input.equals("2")){
                addSubject();
            }
            if(input.equals("3")){
                if(this.listSubjects.isEmpty()){

                    firstSubject();

                }
                System.out.println("Please, write the name of the subject where the task belong");
                input = scanner.nextLine();
                if(addTask(input)){
                    System.out.println("Task added !");
                } else {
                    System.out.println("Sorry, I couldn't find the subject");
                }

            }
            if(input.equals("4")){
                System.out.println("Please, enter the name of the subject to remove from this list below :");
                for(Subject s : this.listSubjects){
                    System.out.println(s.getName());
                }
                input = scanner.nextLine();
                removeSubject(input);


            }
            if(input.equals("5")){
                System.out.println("Goodbye");
                break;
            }
        }
    }
    @Override
    public boolean addSubject(){
        System.out.println("What's the name of the subject you wish to add ? ");
        String input = scanner.nextLine();
        if(alreadyInList(input)){
            System.out.println("This is already in the list");
            return false;
        }
        if(input.length() > 255){
            System.out.println("Name too long");
            return false;
        } else {
            this.listSubjects.add(new Subject(input));
            System.out.println("This subject is now in the list");
                while(true){
                    System.out.println("Do you wish to add a task to this subject ?  Yes/No");
                    input = scanner.nextLine().toLowerCase();
                    if(input.equals("yes")
                            || input.equals("y")){
                        System.out.println("What's the task you wish to add ? ");
                        input = scanner.nextLine();
                        this.listSubjects.get(0).addTask(input);

                    }else if(input.equals("n")
                            || input.equals("no")){
                        break;
                    }else {
                        System.out.println("The answer wasn't yes or no");
                    }
                }

            return true;
        }

    }
    @Override
    public boolean addTask(String subject){
        for(Subject s : this.listSubjects){
            if(s.getName().equals(subject)){
                System.out.println("Please, write the task: ");
                String input = scanner.nextLine();
                s.addTask(input);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean removeSubject(String subject){
        for(Subject s : this.listSubjects){
            if(s.getName().equals(subject)){
                this.listSubjects.remove(s);
                System.out.println("Removal done");
                return true;
            }
        }
        System.out.println("Couldn't find the subject to remove");
        return false;
    }
    public boolean alreadyInList(String name){

            for(Subject subject:this.listSubjects){
                if(subject.getName().equals(name)){
                    return true;
                }
            }
            return false;
    }

    public void firstSubject(){

        while(true){
            System.out.println("You don't have any subject for the moment ! Do you wish to create a subject ? Yes/No");

            String input = scanner.nextLine().toLowerCase();
            if(input.equals("yes")
                    || input.equals("y")) {

                // Call the addSubject method to add it if it pass the check
                addSubject();
                break;
            } else if(input.equals("n")
            || input.equals("no")){
                break;
            } else {
                System.out.println("The answer wasn't yes or no");
            }
        }
    }

    @Override
    public void listTask(Subject subject){
        subject.listTask();
    }
}
