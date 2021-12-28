/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedoctor;

/**
 *
 * @author black
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        // Loop to re-run program until exit
        while (true) {
            // Display menu
            Management.displayMenu();
            // Input a choice from menu
            int choice = getInput.getChoice();
            switch (choice) {
                // Option 1: Add Doctor
                case 1:
                    Management.addDoctor();
                    break;
                // Option 2: Update Doctor
                case 2:
                    Management.updateDoctor();
                    break;
                // Option 3: Delete Doctor
                case 3:
                    Management.deleteDoctor();
                    break;
                // Option 4: Search Doctor
                case 4:
                    Management.searchDoctor();
                    break;
                // Option 5: Exit
                case 5:
                    System.exit(0);
            }
        }
    }
    
}
