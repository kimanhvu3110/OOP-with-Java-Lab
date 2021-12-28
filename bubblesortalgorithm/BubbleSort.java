/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesortalgorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author black
 */
public class BubbleSort {

    static Scanner in = new Scanner(System.in);

    public static int inputArraySize() {
    //Loop to re-input if input not right
        while (true) {        
            try {
                System.out.println("Enter number of array: ");
                int num;
                num = Integer.parseInt(in.nextLine());
                if (num > 0) {  // Check if input is a positive integer number
                    return num;
                } else {
                    System.out.println("Integer number must be positive. Please input again");
                }
            } catch (NumberFormatException ex) {
                System.out.println("This is not an integer. Please input again");
            }
        }
    }

    public static int[] randomArrayElement(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        // Loop to random n integers
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }
        return arr;
    }

    public static void displayArrayBeforeSort(int[] arr) {
        System.out.print("Unsorted array: ");
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }
   
    public static void bubbleSort(int[] arr) {
        // Loop run to move each element to sorted position
        for (int i = 0; i < arr.length - 1; i++) {
            // Loop to run from first element to last unsorted element
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Condition to compare 2 adjacent element                         
                if (arr[j] > arr[j + 1]) {
                    // System.out.println(arr[j] +">"+ arr[j+1] + " ,swap ");     
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
//                else{
//                    System.out.println(arr[j]+ "<" + arr[j+1]+", ok");
//                }
            }
        }
    }
   
    public static void displayArrayAfterSort(int[] arr) {
        System.out.print("Sorted array: ");
        System.out.print(Arrays.toString(arr));
    }
}
