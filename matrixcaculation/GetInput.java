/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcaculation;

import java.util.Scanner;

/**
 *
 * @author black
 */
public class GetInput {

    static Scanner in = new Scanner(System.in);

    static int getOption() {
        //Loop to re-input option if can not return
        while (true) {
            System.out.print("Your choice: ");
            try {
                int option = Integer.parseInt(in.nextLine());
                //Condition to compare input between 1 and 4
                if (option >= 1 && option <= 4) {
                    return option;
                } else {
                    System.out.println("Please enter option between 1-4");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    public static int getNumberOfMatrix(String string) {
        //Loop to re-input if info is invalid
        while (true) {
            try {
                System.out.print(string);
                String str = in.nextLine();
                if(str.isEmpty()){
                    System.out.println("Is empty. Please input again");
                }
                else{
                int number = Integer.parseInt(str);               
                //Condition to compare input is positive 
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter a positive integer");
                }
            }
            } catch (NumberFormatException ex) {
                System.out.println("Must be an integer number. Please input again");
            }
        }
    }

    public static int[][] getMatrix(int row, int column, int print) {
        int[][] matrix = new int[row][column];
        //Loop to access from first row to last row
        for (int i = 0; i < row; i++) {
            //Loop to input first element to last element in each row
            for (int j = 0; j < column; j++) {
                while (true) {
                    try {
                        System.out.print("Enter Matrix"+print+"["+(i+1)+"]["+(j+1)+"]:");
                        matrix[i][j] = Integer.parseInt(in.nextLine());
                        break;
                    } catch (NumberFormatException ex) {
                        System.err.println("Values of matrix is digit");
                    }
                }
            }
        }
        return matrix;
    }
}
