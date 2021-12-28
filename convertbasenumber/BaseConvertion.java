/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbasenumber;

import java.math.BigInteger;

/**
 *
 * @author black
 */
public class BaseConvertion {

    static void displayMenuBaseInput() {
        System.out.println("--------------------");
        System.out.println("Menu input : 1 to 3 to input base case or 4 to exit");
        System.out.println("  1. Binary number (BIN 2)");
        System.out.println("  2. Decimal number (DEC 10)");
        System.out.println("  3. Hexadecimal number (HEX 16)");
        System.out.println("  4. Exit");
    }

    static void displayMenuBaseOutput() {
        System.out.println();
        System.out.println("Menu output: base case to be converted");
        System.out.println("  1. Binary number (BIN 2)");
        System.out.println("  2. Decimal number (DEC 10)");
        System.out.println("  3. Hexadecimal number (HEX 16)");
    }

    static void NumberAfterBaseCaseConverting(int in, int out, String number) {
        System.out.print("Number after converting is : ");
        //Case convert same base
        if (in == out) {
            System.out.println(number);
            System.out.println("2 base is the same! No convertion is perform");
        //Case convert from binary to decimal
        } else if (in == 1 && out == 2) {
            System.out.println(BinToDec(number));
            System.out.println();
        //Case convert from binary to hexadecimal
        } else if (in == 1 && out == 3) {   
            BigInteger temp = BinToDec(number);
            System.out.println(decToHex(temp.toString()));
            System.out.println();
        //Case convert from decimal to binary
        } else if (in == 2 && out == 1) {
            System.out.println(decToBin(number));
            System.out.println();
        //Case convert from decimal to hexadecimal
        } else if (in == 2 && out == 3) {            
            System.out.println(decToHex(number));
            System.out.println();
        //Case convert from hexadecimal to binary
        } else if (in == 3 && out == 1) {
            BigInteger temp = hexToDec(number);
            System.out.println(decToBin(temp.toString()));
            System.out.println();
        //Case convert from hexadecimal to decimal
        } else if(in == 3 && out == 2) {
            System.out.println(hexToDec(number));
            System.out.println();
        }
    }

    static String decToBin(String number) {
        BigInteger decimal = new BigInteger(number);
        String binary = "";
        BigInteger b = new BigInteger("2");  
        //Loop until the remain is 0
        while (!decimal.equals(BigInteger.ZERO)) {           
            binary = binary + decimal.mod(b).toString(); 
            decimal = decimal.divide(b); 
        }
        String result = "";
        // Loop run from last emlement string bi to first element
        for (int i = binary.length() - 1; i >= 0; i--) {
            result = result + binary.charAt(i);
        }
        return result;
    }

    static BigInteger BinToDec(String binary) {
        BigInteger pow = BigInteger.ONE; 
        BigInteger decimal = BigInteger.ZERO; 
        // Loop run from last emlement string binary to first element
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (Character.isDigit((binary.charAt(i)))) {
                int value = Integer.parseInt(String.valueOf(binary.charAt(i)));
                decimal = decimal.add(pow.multiply(BigInteger.valueOf(value)));  
                pow = pow.multiply(BigInteger.valueOf(2)); 
            }
        }
        return decimal;
    }

    static BigInteger hexToDec(String hexa) {
        BigInteger pow = BigInteger.ONE; 
        BigInteger dec = BigInteger.ZERO; 
        // Loop run from last emlement string hexa to first element
        for (int i = hexa.length() - 1; i >= 0; i--) {
        // Condition check char i hexa is a letter 
            if (Character.isLetter((hexa.charAt(i)))) {                
                int decValue = hexa.toUpperCase().charAt(i) - 55;
                dec = dec.add(pow.multiply(BigInteger.valueOf(decValue)));               
                pow = pow.multiply(BigInteger.valueOf(16));
            } else {
                int decValue = Integer.parseInt(String.valueOf(hexa.charAt(i)));
                dec = dec.add(pow.multiply(BigInteger.valueOf(decValue)));               
                pow = pow.multiply(BigInteger.valueOf(16));               
            }
        }
        return dec;
    }
    
    static String decToHex(String number) {
        BigInteger decimal = new BigInteger(number);
        char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                                                       'B', 'C', 'D', 'E', 'F'};
        String hexa = "";
        BigInteger b = new BigInteger("16");
        while (!decimal.equals(BigInteger.ZERO)) {
            int index = Integer.parseInt(decimal.mod(b).toString()); 
            hexa = hexa + hexChar[index]; //assign index to the correct hex digit
            decimal = decimal.divide(b); 
        }
        StringBuilder result = new StringBuilder(hexa);
        return result.reverse().toString();
    }
}
