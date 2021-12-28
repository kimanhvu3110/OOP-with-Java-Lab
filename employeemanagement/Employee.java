/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.Date;

/**
 *
 * @author black
 */
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private Date dob;
    private String sex;
    private double salary;
    private String agency;

    public Employee(String id, String firstName, String lastName, String phone,
        String email, String address, Date dob, String sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String setUpSex(String sex) {
        if (sex.equals("M") || sex.equals("m")) {
            return "Male";
        } else {
            return "Female";
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s%-14s%-12s%-17s%-26s%-18s%-15s%-13s%-10s\n",
                id, firstName, lastName, phone, email, address, GetInput.toString(dob),
                setUpSex(sex), salary, agency);
    }
}
