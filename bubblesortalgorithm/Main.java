/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesortalgorithm;

/**
 *
 * @author black
 */
public class Main {
    public static void main(String[] args) {     
        
        // Input the array size from keyboard
        int size = BubbleSort.inputArraySize();
        
        // Random array elements
        int []arr = BubbleSort.randomArrayElement(size);
        
        //int[] arr = {5 , 1 , 12, -5 ,16};
        
        // Display array before sort
        BubbleSort.displayArrayBeforeSort(arr);
        
        // Function sort array by bubble sort algorithm 
        BubbleSort.bubbleSort(arr);
        
        // Display array after sort
        BubbleSort.displayArrayAfterSort(arr);
    }
}
 