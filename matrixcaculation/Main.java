/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcaculation;

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
            // Display a menu 
            CaculateManagement.displayMenu();
            // Select an option
            int option = GetInput.getOption();
            switch (option) {
                // Option 1: Addition matrixes           
                case 1:
                    CaculateManagement.additionMatrix();
                    break;
                // Option 2: Subtraction matrixes
                case 2:
                    CaculateManagement.subtractionMatrix();
                    break;
                // Option 3: Multiplitcation matrixes
                case 3:
                    CaculateManagement.multiplicationMatrix();
                    break;
                // Option 4: Exit program
                case 4:
                    System.exit(0);
            }
        }

    }
}
