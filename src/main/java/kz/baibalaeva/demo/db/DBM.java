package kz.baibalaeva.demo.db;

import kz.baibalaeva.demo.models.Task;

import java.util.ArrayList;

public class DBM {
    public static ArrayList<Task> tasks= new ArrayList<>();

    public static Long id=3L;

    static {
        tasks.add(new Task(0L, "Clear home", "I must cook", "23.10.2022", true));
        tasks.add(new Task(1L, "Buy foods", "I have to buy fish", "25.10.2022", false));
        tasks.add(new Task(2L, "Learn Italian Language", "I should repeat tasks", "28.10.2022", true));
    }

    public static ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public static void addTasks(Task task){
         task.setId(id);
         tasks.add(task);
         id++;
    }
    public static Task detailsT(Long id){
        return tasks.get(Integer.parseInt(id.toString()));
    }

    public static void editT(Task task){
        tasks.set(Integer.parseInt(task.getId().toString()) , task);
    }

    public static void deleteT(Long id){
        tasks.remove(Integer.parseInt(id.toString()));
    }





}
