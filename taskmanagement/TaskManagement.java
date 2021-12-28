/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

/**
 *
 * @author black
 */
public class TaskManagement {

    static void displayMenu() {
        System.out.println("========= Task program ==========");
        System.out.println("   1. Add Task");
        System.out.println("   2. Delete Task");
        System.out.println("   3. Display Task");
        System.out.println("   4. Exit");
    }

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String fileName = "TaskList.txt";

    public void addTask(List<Task> listTasks, int ID) throws Exception {
        listTasks = FileManagement.readListTask(fileName);
        int id = 1;
        //Condition check list empty
        if (!listTasks.isEmpty()) {
            if (ID > listTasks.get(listTasks.size() - 1).getId()) {
                id = ID + 1;
            } else {
                id = listTasks.get(listTasks.size() - 1).getId() + 1;
            }
        }
        String requirementName = GetInput.getString("Requirement Name: ",
                "Name only contain alphabet ", "^([a-zA-Z]+\\s*)*[a-zA-Z]+$");
        //Regex: contain only alphabet character at least 1 and tab between or not
        int taskTypeNum = GetInput.getInt("Task Type: ", "Please enter number from 1-4", 1, 4);
        Date date = GetInput.getDate(listTasks);
        double planFrom = GetInput.getTime("From: ", date, listTasks, 0.0);
        double planTo = GetInput.getTime("To: ", date, listTasks, planFrom);
        String assignee = GetInput.getString("Assignee: ", "Assignee contain alphabet only",
                "^([a-zA-Z]+\\s*)*[a-zA-Z]+$");
        //Regex: contain only alphabet character at least 1 and tab between or not
        String reviewer = GetInput.getString("Reviewer: ", "Reviewer contain alphabet only",
                "^([a-zA-Z]+\\s*)*[a-zA-Z]+$");
        //Regex: contain only alphabet character at least 1 and tab between or not
        listTasks.add(new Task(id, taskTypeNum, requirementName, date, planFrom, 
                                                     planTo, assignee, reviewer));
        FileManagement.writeListTask(fileName, listTasks);
        System.out.println("Add Task successful");
        System.out.println();
    }

    public void deleteTask(List<Task> listTasks, Integer id) throws Exception {
        listTasks = FileManagement.readListTask(fileName);
        if (id == null) {
            System.out.println("Database is empty. Please add task");
        } else {
            //Loop access from first task to last task in list
            for (Task task : listTasks) {
                //Condition case id of task equal to variable id
                if (task.getId() == id) {
                    listTasks.remove(task);
                    FileManagement.writeListTask(fileName, listTasks);
                    System.out.println("Delete successful !");
                    System.out.println();
                    return;
                }
            }
        }
    }

    public int updateID(int ID, Integer id) {
        if (id == null) {
            return 0;
        } else if (id > ID) {
            return id;
        } else {
            return ID;
        }
    }

    public void showTask(List<Task> listTasks) {
        listTasks = FileManagement.readListTask(fileName);
        if (listTasks.isEmpty()) {
            System.out.println("Database is empty. Please add task");
        } else {
            System.out.format("%-10s%-20s%-17s%-20s%-18s%-15s%-15s\n", "ID", "Name",
                    "Task Type", "Date", "Time", "Assignee", "Reviewer");
            System.out.println();
            //Loop access from first task to last task in list
            for (Task task : listTasks) {
                System.out.println(task.toString());
            }
        }
    }
}
