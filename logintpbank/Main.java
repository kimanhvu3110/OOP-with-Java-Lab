/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logintpbank;

/**
 *
 * @author black
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Loop to re-input
        while (true) {           
            // Display menu 
            LoginManagement.displayMenu();
            // Input option
            int choice = GetInput.getOption();
            switch (choice) {
                // Option 1 : Login by Vietnamese
                case 1:
                    LoginManagement.login("vn");
                    break;
                // Option 2 : Login by English
                case 2:
                    LoginManagement.login("en");
                    break;
                // Option 3 : Exit
                case 3:
                    System.exit(0);
            }
        }
    }
}
