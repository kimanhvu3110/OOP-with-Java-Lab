/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author black
 */
public class GetInput {

    static Scanner in = new Scanner(System.in);

    static int getChoice() {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("> Choose: ");
            try {
                int choice = Integer.parseInt(in.nextLine());
                //Condition to compare input choice between 1 and 6
                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Please enter choice between 1-6");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    static String getID(List<Employee> listEmployees, String temp, String temp2) {
        // Loop to re-input
        while (true) {
            boolean check = true;
            System.out.print("Enter ID: ");
            String id = in.nextLine().trim();
            if (temp != null && id.equals("")) {
                return null;
            }
            // Case input is empty
            if (id.isEmpty()) {
                System.err.println("Input is empty. Please input again");
            } else {
                if (id.equalsIgnoreCase(temp2)) {
                    return id;
                } else {
                    // Condition check input into right format   
                    // Regex to identify input must contain char from a-Z at least 1
                    // and contain a number 0-9 at least 1
                    if (id.matches("^[a-zA-Z]+[0-9]+")) {
                        for (Employee employee : listEmployees) {
                            if (employee.getId().equalsIgnoreCase(id)) {
                                System.err.println("ID is duplicate. Please input again");
                                check = false;
                            }
                        }
                        if (check == true) {
                            return id;
                        }
                    } else {
                        System.err.println("ID is invalid. Please input again");
                    }
                }
            }
        }
    }

    static String getString(String msg, String err, String regex, String temp) {
        // Loop to re-input
        while (true) {
            System.out.print(msg);
            String string = in.nextLine().trim();
            if (temp != null && string.equals("")) {
                return null;
            }
            // Condition check input into right format         
            if (string.matches(regex)) {
                return string;
            } // Case input is empty
            else if (string.isEmpty()) {
                System.err.println("Input is empty. Please input again");
            } else {
                System.err.println(err + ". Please input again");
            }
        }
    }

    static Double getSalary(String temp) {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("Enter Salary: ");
            try {
                String number = in.nextLine();
                if (temp != null && number.equals("")) {
                    return null;
                }
                double salary = Double.parseDouble(number);
                // Condition input must be positive or 0 
                if (salary >= 0) {
                    return salary;
                } else {
                    System.err.println("Availability must be 0 or positive");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Availability is a number. Please input again");
            }
        }
    }

    static Date getDate(String temp) {
        Date current = new Date();
        // Loop to re-input
        while (true) {
            try {
                System.out.print("Enter DOB: ");
                String str = in.nextLine();
                if (temp != null && str != null && str.trim().equals(temp)) {
                    return null;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    sdf.parse(str);
                } catch (ParseException e) {
                    System.err.println("Wrong format of DOB dd/MM/yyyy. Please enter again");
                    continue;
                }
                sdf.setLenient(false);
                Date date = sdf.parse(str);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int year = cal.get(Calendar.YEAR);
                // Condition case dob not valid with today
                if (date.after(current) || year < 1800) {
                    System.err.println("DOB is wrong time. Please enter again");
                } else {
                    return date;
                }
            } catch (ParseException e) {
                System.err.println("DOB does not exist. Please enter again");
            }
        }
    }

    static String toString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
