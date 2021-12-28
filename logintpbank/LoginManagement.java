/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logintpbank;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author black
 */
public class LoginManagement {

    static void displayMenu() {
        System.out.println("=======================");
        System.out.println("Menu");
        System.out.println("1.Vietnamese");
        System.out.println("2.English");
        System.out.println("3.Exit");
    }

    static String randomCaptcha() {
        Random rand = new Random();
        StringBuilder alphanumeric = new StringBuilder();
        //Loop run from char a to char z 
        for (char i = 'a'; i <= 'z'; i++) {
            alphanumeric.append(i);
        }
        //Loop run from char A to char Z
        for (char i = 'A'; i <= 'Z'; i++) {
            alphanumeric.append(i);
        }
        //Loop run from 0 to char 9
        for (char i = '0'; i <= '9'; i++) {
            alphanumeric.append(i);
        }
        StringBuilder captCha;
        captCha = new StringBuilder();
        //Loop to run from first to last length stringbuilder
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(alphanumeric.length());
            char randomChar = alphanumeric.charAt(index);
            captCha.append(randomChar);
        }
        return captCha.toString();
    }

    static Locale getLocale(String locale) {
        Locale localeEn = new Locale("en");
        Locale localeVn = new Locale("vn");
        if (locale.equals("en")) {
            return localeEn;
        } else {
            return localeVn;
        }
    }

    public static void login(String in) {
        Locale locale = getLocale(in);
        ResourceBundle bundle = ResourceBundle.getBundle("LoginTPBank.language", locale);
        //Get a string and set to accountNumber variable
        String accountNumber = GetInput.getString(bundle.getString("account"),
                bundle.getString("account.error"), "^\\d{10}$");
        //Get a string and set to password variable
        String password = GetInput.getPassword(bundle.getString("password"),
                bundle.getString("password.error"));
        //Random captcha 5 character include alphanumeric
        while (true) {
            String captcha = randomCaptcha();
            System.out.println("Captcha: " + captcha);
            String inCaptcha = GetInput.inputCaptcha(bundle.getString("captcha"));
            //Compare input with captcha 
            if (captcha.equals(inCaptcha)) {
                try {
                    System.out.println();
                    //Case compare password input match with key named as string 
                    //of accountNumber in file
                    if (password.equals(bundle.getString(accountNumber))) {
                        System.out.println(bundle.getString("login.success"));
                        System.out.println();
                        return;
                    } else {
                        System.out.println(bundle.getString("login.failed"));
                        return;
                    }
                } catch (MissingResourceException ex) {
                    System.out.println(bundle.getString("account.notExist"));
                    System.out.println();
                    return;
                }
            } else {
                System.out.println(bundle.getString("captcha.incorrect"));
                System.out.println();
            }
        }
    }
}
