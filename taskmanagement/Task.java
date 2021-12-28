/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author black
 */
public class Task implements Serializable {

    private int id;
    private int taskTypeId;
    private String name;
    private Date date;
    private double planfrom;
    private double planTo;
    private String assign;
    private String review;

    public Task() {

    }

    public Task(int id, int taskTypeId, String name, Date date, double planfrom,
            double planTo, String assign, String review) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.name = name;
        this.date = date;
        this.planfrom = planfrom;
        this.planTo = planTo;
        this.assign = assign;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeName(int taskTypeId) {
        String taskTypeName = "";
        switch (taskTypeId) {
            case 1:
                taskTypeName = "Code";
                break;
            case 2:
                taskTypeName = "Test";
                break;
            case 3:
                taskTypeName = "Design";
                break;
            case 4:
                taskTypeName = "Review";
                break;
        }
        return taskTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanfrom() {
        return planfrom;
    }

    public void setPlanfrom(double planfrom) {
        this.planfrom = planfrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-20s%-17s%-20s%-18.1f%-15s%-15s\n", id,
                name, getTaskTypeName(taskTypeId), GetInput.toString(date),
                planTo - planfrom, assign, review);
    }

}
