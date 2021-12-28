/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedoctor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author black
 */
public class FileProcess {
    public static List<Doctor> readListDoctor(File file) {
        try {           
            if (!file.exists()) {
                writeListDoctor(file, new ArrayList<>());
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            List<Doctor> listDoctor = (List<Doctor>) ois.readObject();
            return listDoctor;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Read file fail");
        }
        return null;
    }

    public static void writeListDoctor(File file, List<Doctor> list) {
        try {
            FileOutputStream fos = new FileOutputStream ("D:/doctor.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not exist");
        } catch (IOException ex) {
            System.out.println("Read file fail");
        }
    }
}
