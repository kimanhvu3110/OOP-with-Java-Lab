/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbasenumber;

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
        while(true){
            //Display menu input base case
            BaseConvertion.displayMenuBaseInput(); 
            //Input a base case in
            int in = GetInput.getBaseCaseIn();
            //Display menu output base case
            BaseConvertion.displayMenuBaseOutput();           
            //Input a base case out
            int out = GetInput.getBaseCaseOut();
            //Input a number to convert
            String number = GetInput.getNumber(in);
            //Number after base case converting 
            BaseConvertion.NumberAfterBaseCaseConverting(in, out, number);
        }
    }   
}
