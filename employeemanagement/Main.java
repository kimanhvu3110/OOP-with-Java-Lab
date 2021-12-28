/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author black
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Employee> listEmployees = new ArrayList<>();
        // Loop to re-input
        while (true) {
            // Display a menu 
            Management.displayMenu();
            // Input a choice from menu
            int choice = GetInput.getChoice();
            switch (choice) {
                // Choice 1: Add employees
                case 1:
                    Management.addEmployee(listEmployees);
                    break;
                // Choice 2: Update employees
                case 2:
                    Management.updateEmployee(listEmployees);
                    break;
                // Choice 3: Remove employees
                case 3:
                    Management.removeEmployee(listEmployees);
                    break;
                // Choice 4: Search employees
                case 4:
                    Management.searchEmployee(listEmployees);
                    break;
                // Choice 5: Sort employees by salary
                case 5:
                    Management.sortEmployeesBySalary(listEmployees);
                    break;
                // Choice 6: Exit
                case 6:
                    System.exit(0);
            }
        }
    }
}
