/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagesystem;

import java.io.IOException;

/**
 *
 * @author black
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Loop to re-run program until exit
        while (true) {
            // Display menu 
            SystemManagement.displayMenu();
            // Input a choice from menu from 1-3
            int choice = SystemManagement.inputChoice();
            switch (choice) {
                // Option 1: Create new account
                case 1:
                    SystemManagement.createNewAccount();
                    break;
                // Option 2: Login System
                case 2:
                    SystemManagement.loginSystem();
                    break;
                // Option 3: Exit the program
                case 3:
                    System.exit(0);
            }
        }
    }
}
