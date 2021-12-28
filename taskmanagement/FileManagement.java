/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.io.File;
import java.io.FileInputStream;
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
public class FileManagement {
    public static List<Task> readListTask(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                writeListTask(fileName, new ArrayList<>());
            }
            ObjectInputStream O = new ObjectInputStream(new FileInputStream(fileName));
            List<Task> listTask = (List<Task>) O.readObject();
            return listTask;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Can not read database file");
        }
        return null;
    }

    public static void writeListTask(String fileName, List<Task> list) {
        try {
            ObjectOutputStream O = new ObjectOutputStream(new FileOutputStream(fileName));
            O.writeObject(list);
            O.close();
        } catch (IOException ex) {
            System.out.println("Error Write File");                  
        }
    }
}
