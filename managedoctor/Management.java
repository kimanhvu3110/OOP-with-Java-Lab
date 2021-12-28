/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedoctor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author black
 */
public class Management {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static File file = new File("D:/doctor.txt");

    static void displayMenu() {
        System.out.println("========= Doctor Management =========");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
    }

    static void addDoctor() throws Exception {
        System.out.println("--------- Add Doctor ---------");
        ArrayList<Doctor> listDoctors = (ArrayList<Doctor>)FileProcess.readListDoctor(file);      
        String code = getInput.getInCode(listDoctors);
        String name = getInput.getString("Enter Name: ", "Name", "^[a-zA-Z]+$");
        String specialization = getInput.getString("Enter Specialization: ",
                "Specialization", "^[a-zA-Z]+$");
        Integer availability = getInput.getAvailability(null);
        System.out.println("Add successful !");
        listDoctors.add(new Doctor(code, name, specialization, availability));
        System.out.println(listDoctors);
        FileProcess.writeListDoctor(file, listDoctors);
    }

    static void updateDoctor() throws Exception {
       
    }

    static void deleteDoctor() throws Exception {
        List<Doctor> doctorList = new ArrayList<>();

        System.out.println("--------- Delete Doctor ---------");
        while (true) {
            boolean check = true;
            System.out.print("Enter Code: ");
            String code = in.readLine().trim();
            for (int i = 0; i < doctorList.size(); i++) {
                if (code.equalsIgnoreCase(doctorList.get(i).getCode())) {
                    doctorList.remove(i);
                    check = false;
                    break;
                }
            }
            if (check == false) {

                System.out.println("Delete succesful !");
                return;
            } else {
                System.out.println("Doctor code does not exist");
            }
        }
    }

    static void searchDoctor() throws Exception {
        System.out.println("--------- Search Doctor ---------");
    
    }

}
