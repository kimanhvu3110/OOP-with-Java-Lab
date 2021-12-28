/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbasenumber;

import java.util.Scanner;

/**
 *
 * @author black
 */
public class GetInput {

    static Scanner in = new Scanner(System.in);

    static int getBaseCaseIn() {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("> Choose: ");
            try {
                int choice = Integer.parseInt(in.nextLine().trim());
                //Condition to compare input between 1 and 4
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else if (choice == 4) {
                    System.exit(0);
                } else {
                    System.out.println("Please enter choice between 1-4");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    static int getBaseCaseOut() {
        //Loop to re-input choice if can not return
        while (true) {
            System.out.print("> Choose: ");
            try {
                int choice = Integer.parseInt(in.nextLine());
                //Condition to compare input between 1 and 4
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Please enter choice between 1-3");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choice is a number. Please input again");
            }
        }
    }

    static String getNumber(int choice) {
        while (true) {
            //Loop to re-input
            while (true) {
                System.out.print("Enter a number: ");
                String value = in.nextLine();
                switch (choice) {
                    case 1:
                        if (value.matches("[0-1]+")) {
                            //Regex : contain only 0 or 1 one or more times
                            return value;
                        }
                        break;
                    case 2:
                        if (value.matches("[0-9]+")) {
                            //Regex : contain only 0 to 9 one or more times
                            return value;
                        }
                        break;
                    case 3:
                        if (value.matches("[0-9a-fA-F]+")) {
                            //Regex: contain only 0-9 or A-F a-f one or more times
                            return value;
                        }
                }
                System.err.println("Input is invalid with form base. Please input again");
            }
        }
    }
}
