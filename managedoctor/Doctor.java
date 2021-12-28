/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedoctor;

import java.io.Serializable;

/**
 *
 * @author black
 */
public class Doctor implements Serializable{
    String name;
    String code;
    String specialization;
    int availability;
    
    public Doctor(){        
    }
    
    public Doctor(String code, String name,  String specialization, int availability) {
        this.name = name;
        this.code = code;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{" + "code=" + code + ", name=" + name + ", specialization=" + specialization + ", availability=" + availability + '}';
    }
    
}
