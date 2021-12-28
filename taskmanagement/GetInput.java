/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author black
 */
class GetInput {

    static Scanner in = new Scanner(System.in);

    static int getChoice() {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("> Choose: ");
            try {
                int choice = Integer.parseInt(in.nextLine());
                //Condition to compare input choice between 1 and 4
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Please enter choice between 1-4");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    static int getInt(String msg, String err, int min, int max) throws Exception {
        //Loop to re-input
        while (true) {
            try {
                System.out.print(msg);
                int num;
                num = Integer.parseInt(in.nextLine());
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.err.println(err);
                }
            } catch (NumberFormatException ex) {
                System.err.println(err);
            }
        }
    }

    static Integer getID(List<Task> listTasks) throws Exception {
        listTasks = FileManagement.readListTask("TaskList.txt");
        if (listTasks.isEmpty()) {
            return null;
        } else {
            //Loop to re-input
            while (true) {                
                try {
                    System.out.print("ID: ");
                    String str = in.nextLine().trim();
                    int id = Integer.parseInt(str);
                    if (str.isEmpty()) {
                        System.err.println("Input is empty. Please enter again");
                    } else {
                        //Loop access from first task to last task in list
                        for (int i = 0; i < listTasks.size(); i++) {
                            if (listTasks.get(i).getId() == id) {
                                return id;
                            }
                        }                      
                        System.err.println("ID does not exist in database. Please enter again");                        
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("ID must be a number. Please enter again");
                }
            }
        }
    }

    static double getTime(String msg, Date date, List<Task> listTasks, Double temp) {
        //Loop to re-input 
        while (true) {
            try {
                System.out.print(msg);
                double num;
                String str = in.nextLine();
                num = Double.parseDouble(str);
                if (str == null) {
                    System.out.println("Input is empty. Please enter again");
                } else if (num % 0.5 == 0) {
                    if (num >= 8 && num <= 17.5) {
                        if (!checkDuplicateTime(date, num, temp, listTasks)) {
                            if (num > temp) {
                                return num;
                            } else {
                                System.err.println("Time is invalid. Must be larger than " + temp);
                            }
                        } else {
                            System.err.println("Time is duplicate with other task in same day. "
                                    + "Please enter again");
                        }
                    } else {
                        System.err.println("Time calculate from 8h-17h30. Please enter again");
                    }
                } else {
                    System.err.println("Please enter time form x.5 or x.0");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Time is invalid. Please enter again");
            }
        }
    }

    static boolean checkDuplicateTime(Date date, double time,double temp, List<Task> listTasks) {
        //Loop access from first task to last task in list
        for (Task task : listTasks) {
            if (task.getDate().equals(date)) {
                if(temp==0){
                if(time >= task.getPlanfrom()-0.5 && time <=task.getPlanfrom()){
                    return true;
                }
                }
                if(temp!=0){
                if(temp <= task.getPlanfrom() && time >= task.getPlanfrom()){
                    return true;
                }
                }
                if (time >= task.getPlanfrom() && time <= task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    static String getString(String msg, String err, String regex) {
        //Loop to re-input
        while (true) {
            System.out.print(msg);
            String str = in.nextLine();
            if (str.isEmpty()) {
                System.err.println("Input is empty. Please enter again");
                continue;
            }
            if (str.matches(regex)) {
                return str;
            } else {
                System.err.println(err);
            }
        }
    }

    static Date getDate(List<Task> listTasks) {
        Date current = new Date();
        // Loop to re-input
        while (true) {
            try {
                System.out.print("Date: ");
                String str = in.nextLine();
                if (str.isEmpty()) {
                    System.err.println("Input is empty. Please enter again");
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        sdf.parse(str);
                    } catch (ParseException e) {
                        System.err.println("Wrong format of DOB dd-MM-yyyy. Please enter again");
                        continue;
                    }
                    sdf.setLenient(false);
                    Date date = sdf.parse(str);
                    if (date.after(current)) {
                        return date;
                    } else {
                        System.err.println("Can not add task in the past. Please enter again");
                    }
                }
            } catch (ParseException e) {
                System.err.println("DOB does not exist. Please enter again");
            }
        }
    }

    static boolean checkFulltimeDate(Date date, List<Task> listTasks) {
        double timeSum = 0;
        //Loop access from first task to last task in list
        for (Task task : listTasks) {
            //Condition case date of task equal date variable
            if (task.getDate().equals(date)) {
                timeSum = timeSum + (task.getPlanTo() - task.getPlanfrom());
            }
        }
        return timeSum != 9.5;
    }

    static String toString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
}
