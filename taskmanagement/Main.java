/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author black
 */
public class Main {

    public static void main(String[] args) throws Exception {
        TaskManagement taskManagement = new TaskManagement();
        List<Task> listTasks = new ArrayList<>();
        int ID = 0;
        //Loop to re-input choice
        while (true) {
            //Display Menu
            TaskManagement.displayMenu();
            //Input a choice from menu
            int choice = GetInput.getChoice();
            switch (choice) {
                //Option 1 : Add Task
                case 1:
                    taskManagement.addTask(listTasks, ID);
                    break;
                //Option 2 : Delete Task
                case 2:
                    Integer idDelete = GetInput.getID(listTasks);
                    ID = taskManagement.updateID(ID, idDelete);
                    taskManagement.deleteTask(listTasks, idDelete);
                    break;
                //Option 3 : Show Task
                case 3:
                    taskManagement.showTask(listTasks);
                    break;
                //Option 4 : Exit system
                case 4:
                    System.exit(0);
            }
        }
    }
}
