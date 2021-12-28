/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedoctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/**
 *
 * @author black
 */
public class getInput {   
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    static int getChoice() throws IOException {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("> Choose: ");
            try {
                int choice = Integer.parseInt(in.readLine());
                //Condition to compare input between 1 and 5
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Please enter choice between 1-5");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    

    static String getString(String msg, String err, String regex) throws IOException {
        while (true) {
            boolean check = true;
            System.out.print(msg);
            String str = in.readLine().trim();
            if (str.matches(regex)) {
                return str;
            } else {
                System.out.println(err + " is wrong string format. Please input again");
            }
        }
    }
    
    static String getInCode( List<Doctor> listDoctor) throws IOException  {      
        while (true) {
            boolean check = false;
            System.out.print("Enter Code: ");
            String code = in.readLine().trim();
            for (Doctor doctor : listDoctor){
                if(doctor.getCode().equalsIgnoreCase(code)){
                    System.out.println("Duplicate code. Please enter again");
                    check = true;
                    break;
                }
            }
            if(check == false){
                return code;
            }
        }
    }
    
    static Integer getAvailability(String ignore) throws IOException {

        //Loop to re-input choice if can not return
        while (true) {

            System.out.print("Enter Availability: ");
            try {
                String number = in.readLine();
                if (ignore != null && number != null && number.trim().equals(ignore)) {
                    return null;
                }
                int availability = Integer.parseInt(number);
                if (availability >= 0) {
                    return availability;
                } else {
                    System.out.println("Availability must >= 0");
                }
            } catch (NumberFormatException ex) {

                System.out.println(" Availability is a number. Please input again");

            }
        }
    }
}
