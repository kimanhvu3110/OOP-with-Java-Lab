/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author black
 */
public class SystemManagement {

    static Scanner in = new Scanner(System.in);
    static File file = new File("D:/user.dat");

    static void displayMenu() {
        System.out.println();
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    static int inputChoice() {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("> Choose: ");
            try {
                int choice = Integer.parseInt(in.nextLine());
                //Condition to compare input between 1 and 3
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Please enter choice between 1-3");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    static void createNewAccount() throws IOException {
        //Check existing of user.dat file before inserting a new account.
        if (file.exists() != true) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //Input username 
        String username;
        // Loop to re-input if username already exists
        while (true) {
            boolean check = false;
            username = getUsername();
            String line;
            // Loop to access first line to last line
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split("/");
                //Condition to compare username input with usename in file  
                if (username.equalsIgnoreCase(account[0])) {
                    System.err.println("Username already exists! Create another username");
                    check = true;
                    break;
                }
            }
            if (check == false) {
                break;
            }
        }
        bufferedReader.close();
        fileReader.close();
        //Input password
        String password = getPassword();
        
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(username + "/" + password + "\n");
        fileWriter.close();
    }

    static void loginSystem() throws IOException {
        //Condition cannot loggin if file is not exist
        if (file.exists() != true) {
            System.out.println("Please create file and create an account before login");
        }
        else{
        String username = getUsername();
        String password = getPassword();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        // Loop to access first line to last line
        while ((line = bufferedReader.readLine()) != null) {
            String[] account = line.split("/");
            // Condition to compare username input with username in file
            if (username.equalsIgnoreCase(account[0])) {
                //Condition to compare password input with password in file
                if (password.equals(account[1])) {
                    System.out.println("Login successful!");
                    return;
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
        System.err.println("Invalid user name or password");
    }
    }

    private static String getUsername() {
        String username;
        //Loop to re-input username if can not return
        while (true) {
            System.out.print("Enter Username: ");
            username = in.nextLine().trim();
            //Regex to identify username has at least 5 char and no spaces
            if (username.matches("^\\S{5}\\S*$")) {
                return username;
            } else {
                System.out.println("You must enter least at 5 character, and no space!");
            }
        }
    }

    private static String getPassword() {
        String password;
        //Loop to re-input username if can not return
        while (true) {
            System.out.print("Enter Password: ");
            password = in.nextLine().trim();
            //Regex to identify password has at least 6 char and no spaces
            if (password.matches("^\\S{6}\\S*$")) {
                return password;
            } else {
                System.out.println("You must enter least at 6 character, and no space!");
            }
        }
    }

}
