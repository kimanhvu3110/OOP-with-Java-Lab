/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logintpbank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author black
 */
public class GetInput {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static int getOption() {
        //Loop to re-input
        while (true) {
            try {
                System.out.print("Please choice one option: ");
                int num;
                num = Integer.parseInt(in.readLine());
                //Case input only between 1 and 3
                if (1 <= num && num <= 3) {
                    return num;
                } else {
                    System.out.println("Option only in rang 1-3. Please enter again");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Option is a positive number from 1-3");
            }
        }
    }

    static String getString(String msg, String err, String regex) {
        //Loop to re-input
        while (true) {
            try {
                System.out.print(msg);
                String str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("Something wrong with read/write IOException");
            }
            System.out.println(err);
        }
    }

    static String inputCaptcha(String msg) {
        System.out.print(msg);
        String str = null;
        try {
            str = in.readLine();

        } catch (IOException ex) {
            System.out.println("Something wrong with read/write IOException");
        }
        return str;
    }

    static String getPassword(String msg, String err) {
        //Loop to re-input
        while (true) {
            try {
                System.out.print(msg);
                String str = in.readLine();
                //Regex : any character a-z A-z 0-9 but only 8 times to 31 times
                if (str.matches("^[a-zA-Z0-9]{8,31}$")
                        //Regex: any character alphabet and number at least one or more and number at least 1 
                        && str.matches("^\\w*[0-9]+\\w*$")
                        //Regex: any character alphabet and number at least one or more and alphabet at least 1
                        && str.matches("^\\w*[a-zA-Z]+\\w*$")) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("Something wrong with read/write IOException");
            }
            System.out.println(err);
        }
    }
}
