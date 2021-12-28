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
public class CaculateManagement {

    static void displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addtion Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    static void additionMatrix() {
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("------- Addition -------");
        //Input number of row, number of column of matrix1
        int row1 = GetInput.getNumberOfMatrix("Enter Row Matrix 1:");
        int column1 = GetInput.getNumberOfMatrix("Enter Column Matrix 1:");
        //Input values of matrix1
        matrix1 = GetInput.getMatrix(row1, column1, 1);

        //Input number of row, number of column of matrix2
        int row2 = GetInput.getNumberOfMatrix("Enter Row Matrix 2:");
        int column2;

        // Loop to re-input if dimension is invalid
        while (true) {
            // Case row matrix 2 not equal row matrix 1
            if (row2 != row1) {
                System.err.println("Can not add 2 matrix has differnt row! Input again");
                row2 = GetInput.getNumberOfMatrix("Enter Row Matrix 2:");
            }
            // Case row matrix 2 equal row matrix 1
            if (row2 == row1) {
                column2 = GetInput.getNumberOfMatrix("Enter Column Matrix 2:");
                //Case column matrix 2 not euqual comlumn matrix 1
                if (column2 != column1) {
                    System.err.println("Can not add 2 matrix has differnt column! Input again");
                    column2 = GetInput.getNumberOfMatrix("Enter Column Matrix 2:");
                }
                //Case column matrix 2 euqual column matrix 1
                if (column2 == column1) {
                    break;
                }
            }
        }
        //Input values of matrix2
        matrix2 = GetInput.getMatrix(row2, column2, 2);
              
        System.out.println("------- Result -------");
        displayMatrix(matrix1, row1, column1);
        System.out.println("+");
        displayMatrix(matrix2, row2, column2);
        System.out.println("=");
        int[][] matrixSum = new int[row1][column1];
        
        //Loop to access from first row to last row
        for (int i = 0; i < row1; i++) {
            //Loop to access from first element to last element in each row
            for (int j = 0; j < column1; j++) {
                matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        displayMatrix(matrixSum, row1, column1);
        System.out.println();
    }

    static void subtractionMatrix() {
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("------- Subtraction -------");
        int row1 = GetInput.getNumberOfMatrix("Enter Row Matrix 1:");
        int column1 = GetInput.getNumberOfMatrix("Enter Column Matrix 1:");
        matrix1 = GetInput.getMatrix(row1, column1, 1);       
        int row2 = GetInput.getNumberOfMatrix("Enter Row Matrix 2:");
        int column2;

        // Loop to re-input if dimension is invalid
        while (true) {
            // Case row matrix 2 not equal row matrix 1
            if (row2 != row1) {
                System.err.println("Can not subtract 2 matrix has differnt row!"
                                                               + "Input again");
                row2 = GetInput.getNumberOfMatrix("Enter Row Matrix 2:");
            }
            // Case row matrix 2 euqual row matrix 1
            if (row2 == row1) {
                column2 = GetInput.getNumberOfMatrix("Enter Column Matrix 2:");
                //Case column matrix 2 not euqual comlumn matrix 1
                if (column2 != column1) {
                    System.err.println("Can not subtract 2 matrix has differnt column! "
                                                               + "Input again");
                    column2 = GetInput.getNumberOfMatrix("Enter Column Matrix 2:");
                }
                //Case column matrix 2 euqual column matrix 1
                if (column2 == column1) {
                    break;
                }
            }
        }
        matrix2 = GetInput.getMatrix(row2, column2, 2);
        
        System.out.println("------- Result -------");
        displayMatrix(matrix1, row1, column1);
        System.out.println("-");
        displayMatrix(matrix2, row2, column2);
        System.out.println("=");
        int[][] matrixSubtract = new int[row1][column1];
        //Loop to access from first row to last row
        for (int i = 0; i < row1; i++) {
            //Loop to access from first element to last element in each row
            for (int j = 0; j < column1; j++) {
                matrixSubtract[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        displayMatrix(matrixSubtract, row1, column1);
        System.out.println();
    }

    static void multiplicationMatrix() {
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("------- Multiplication -------");
        int row1 = GetInput.getNumberOfMatrix("Enter Row Matrix 1:");
        int column1 = GetInput.getNumberOfMatrix("Enter Column Matrix 1:");
        matrix1 = GetInput.getMatrix(row1, column1, 1);
        int row2 = GetInput.getNumberOfMatrix("Enter Row Matrix 2:");
        int column2;

        // Loop to re-input if dimension is invalid
        while (true) {
            //Case row matrix 2 not equal column matrix 1
            if (row2 != column1) {
                System.err.println("Can not multiple! Row matrix 2 not equal "
                                              + "column matrix 1. Input again");
                row2 = GetInput.getNumberOfMatrix("Enter Row Matrix 2:");
            } else {
                column2 = GetInput.getNumberOfMatrix("Enter Column Matrix 2:");
                break;
            }
        }
        matrix2 = GetInput.getMatrix(row2, column2, 2);

        System.out.println("------- Result -------");
        displayMatrix(matrix1, row1, column1);
        System.out.println("*");
        displayMatrix(matrix2, row2, column2);
        System.out.println("=");
        int[][] matrixMulti = new int[row1][column2];

        //Loop to access from first row to last row of matrix 1          
        for (int i = 0; i < row1; i++) {
            //Loop to access from first column to last column of matrix 2
            for (int j = 0; j < column2; j++) {
                //Loop to access row of matrix 2 and column of matrix 1
                for (int x = 0; x < column1; x++) {
                    matrixMulti[i][j] += matrix1[i][x] * matrix2[x][j];
                }
            }
        }
        displayMatrix(matrixMulti, row1, column2);
        System.out.println();
    }

    private static void displayMatrix(int[][] matrix1, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix1[i][j] + "]");
            }
            System.out.println();
        }
    }
}
