/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author black
 */
class Management {

    static void displayMenu() {
        System.out.println("Main menu:");
        System.out.println("     1. Add employees");
        System.out.println("     2. Update employees");
        System.out.println("     3. Remove employees");
        System.out.println("     4. Search employees");
        System.out.println("     5. Sort employees by salary ");
        System.out.println("     6. Exit");
    }
    static Scanner in = new Scanner(System.in);

    static void addEmployee(List<Employee> listEmployees) {
        String id = GetInput.getID(listEmployees, null, null);
        String firstName = GetInput.getString("Enter first name: ", "First Name is wrong format",
                //Regex: contain only alphabet character at least 1 and tab between or not
                "^([a-zA-Z]+\\s*)*[a-zA-Z]+$", null);
        String lastName = GetInput.getString("Enter last name: ", "Last Name is wrong format",
                //Regex: contain only alphabet character at least 1 and tab between or not
                "^([a-zA-Z]+\\s*)*[a-zA-Z]+$", null);
        String phone = GetInput.getString("Enter phone: ", "Phone is invalid",
                //Regex: contain number from 0-9 only and contain at least 9 number or more
                "^[0-9]+\\d{9}$", null);
        String email = GetInput.getString("Enter email: ", "Wrong format of email",
                //Regex: contain any char and @ and domain ".xxx" or ".xxx.yyy"
                "^[\\w]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$", null);
        String address = GetInput.getString("Enter Address: ", "Address is wrong format",
                //Regex: contain number at first and only alphabet char after 
                "^([0-9]*\\s*)*([a-zA-Z]+\\s*)+$", null).trim();
        Date dob = GetInput.getDate(null);
        String sex = GetInput.getString("Enter sex(M for male/ F for female): ",
                //Regex: only valid with 4 value M,F,m,f
                "Sex is wrong format. Enter male or female only.", "^([M]|[F]|[m]|[f])$", null);
        double salary = GetInput.getSalary(null);
        String agency = GetInput.getString("Enter agency: ", "Agency is wrong format",
                //Regex: contain only alphabet character at least 1 and tab between or not
                "^([a-zA-Z]+\\s*)*[a-zA-Z]+$", null);
        listEmployees.add(new Employee(id, firstName, lastName, phone, email,
                address, dob, sex, salary, agency));
        System.out.println();
        //displayEmployeeList(listEmployees);      
        System.out.println("Add employee successfull!");
        System.out.println("-------------------");
    }

    static void updateEmployee(List<Employee> listEmployees) {
        if (listEmployees.isEmpty()) {
            System.out.println("List is empty. Please add employee");
            System.out.println();
            return;
        }
        boolean check = false;
        //Loop to re-input
        while (true) {
            int dem = -1;
            String id = GetInput.getString("Enter ID to update: ", "ID is invalid."
                    + "ID format is a positive number", "^[a-zA-Z]+[0-9]+", null);
            //Loop to access from first employee to last employee in list
            for (Employee employee : listEmployees) {
                dem++;
                // Condition compare id of employee with id input
                if (employee.getId().equalsIgnoreCase(id)) {
                    String newID = GetInput.getID(listEmployees, "", id);
                    String newFirstName = GetInput.getString("Enter first name: ", "First Name is wrong format",
                            "^([a-zA-Z]+\\s*)*[a-zA-Z]+$", "");
                    String newLastName = GetInput.getString("Enter last name: ", "Last Name is wrong format",
                            "^([a-zA-Z]+\\s*)*[a-zA-Z]+$", "");
                    String newPhone = GetInput.getString("Enter phone: ", "Phone is invalid",
                            "^[0-9]+\\d{9}$", "");
                    String newEmail = GetInput.getString("Enter email: ", "Wrong format of email",
                            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$", "");
                    String newAddress = GetInput.getString("Enter Address: ", "Address is wrong format",
                            "^([0-9]*\\s*)*([a-zA-Z]+\\s*)+$", "");
                    Date newDob = GetInput.getDate("");
                    String newSex = GetInput.getString("Enter sex(M for male/ F for female): ",
                            "Sex is wrong format. Enter male or female only.", "^([M]|[F]|[m]|[f])$", "");
                    Double newSalary = GetInput.getSalary("");
                    String newAgency = GetInput.getString("Enter agency: ", "Agency is wrong format",
                            "^([a-zA-Z]+\\s*)*[a-zA-Z]+$", "");
                    //Condition case input newID is empty
                    if (newID == null) {
                        newID = employee.getId();
                    }
                    if (newFirstName == null) {
                        newFirstName = employee.getFirstName();
                    }
                    if (newLastName == null) {
                        newLastName = employee.getLastName();
                    }
                    if (newPhone == null) {
                        newPhone = employee.getPhone();
                    }
                    if (newEmail == null) {
                        newEmail = employee.getEmail();
                    }
                    if (newAddress == null) {
                        newAddress = employee.getAddress();
                    }
                    if (newDob == null) {
                        newDob = employee.getDob();
                    }
                    if (newSex == null) {
                        newSex = employee.getSex();
                    }
                    if (newAgency == null) {
                        newAgency = employee.getAgency();
                    }
                    if (newSalary == null) {
                        newSalary = employee.getSalary();
                    }
                    listEmployees.remove(employee);
                    listEmployees.add(dem, new Employee(newID, newFirstName, newLastName, newPhone,
                            newEmail, newAddress, newDob, newSex, newSalary, newAgency));
                    check = true;
                    break;
                }
            }
            if (check == false) {
                System.err.println("No id is found. Please enter again");
            } else {
                //displayEmployeeList(listEmployees);
                System.out.println();
                System.out.println("Update successful!");
                System.out.println("-------------------");
                return;
            }
        }
    }

    static void removeEmployee(List<Employee> listEmployees) {
        if (listEmployees.isEmpty()) {
            System.out.println("List is empty. Please add employee");
            System.out.println();
            return;
        }
        //Loop to re-input
        while (true) {
            String id = GetInput.getString("Enter ID: ", "ID is invalid."
                    + "ID format is a positive number", "^[a-zA-Z]+[0-9]+", null);
            //Loop to access from first employee to last employee in list
            for (Employee employee : listEmployees) {
                if (employee.getId().equalsIgnoreCase(id)) {
                    listEmployees.remove(employee);
                    System.out.println();
                    System.out.println("Remove successful!");
                    System.out.println("------------------");
                    return;
                }
            }
            System.err.println("No id is found. Please enter again");
        }
    }

    static void searchEmployee(List<Employee> listEmployees) {
        if (listEmployees.isEmpty()) {
            System.out.println("List is empty. Please add employee");
            System.out.println();
            return;
        }
        boolean check = false;
        int dem = 0;
        //Loop to re-input
        while (true) {
            System.out.print("Enter text(name): ");
            String name = in.nextLine();
            //Case input is empty
            if (name.isEmpty()) {
                System.out.format("%-10s%-14s%-12s%-17s%-26s%-18s%-15s%-13s%-10s\n",
                        "ID", "First Name", "Last Name", "Phone", "Email",
                        "Address", "DOB", "Sex", "Salary", "Agency");
                for (Employee employee : listEmployees) {
                    System.out.println(employee.toString());
                }
                return;
            }
            //Loop to access from first to last employee in the list
            for (Employee employee : listEmployees) {
                if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())
                        || employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                    dem++;
                    if (dem == 1) {
                        System.out.format("%-10s%-14s%-12s%-17s%-26s%-18s%-15s%-13s%-10s\n",
                                "ID", "First Name", "Last Name", "Phone", "Email",
                                "Address", "DOB", "Sex", "Salary", "Agency");
                    }
                    System.out.println(employee.toString());
                    check = true;
                }
            }
            if (check == false) {
                System.out.println();
                System.out.println("No name is found !");
                System.out.println("-------------------");
                return;
            } else {
                System.out.println();
                System.out.println("----------------");
                return;
            }
        }
    }

    static void sortEmployeesBySalary(List<Employee> listEmployees) {
        if (listEmployees.isEmpty()) {
            System.out.println("List is empty. Please add employee");
            System.out.println();
            return;
        }
        //Sort list desecding
        //Loop to access from first to pentulimate employee in the list
        for (int i = 0; i < listEmployees.size() - 1; i++) {
            // Loop to access from the ith + 1 to last employee in the list
            for (int j = i + 1; j < listEmployees.size(); j++) {
                // Compare 2 salary of ith employee with jth employee
                if (listEmployees.get(i).getSalary() > listEmployees.get(j).getSalary()) {
                    Collections.swap(listEmployees, i, j);
                }
            }
        }
        System.out.println("List after sorting is: ");
        System.out.format("%-10s%-14s%-12s%-17s%-26s%-18s%-15s%-13s%-10s\n",
                "ID", "First Name", "Last Name", "Phone", "Email",
                "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employee employee : listEmployees) {
            System.out.println(employee.toString());
        }
    }
}
