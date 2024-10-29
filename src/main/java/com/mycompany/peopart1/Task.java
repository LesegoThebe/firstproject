/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peopart1;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    
  private static int taskCounter = 0;
    private String taskName;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
   
    // Constructor
    public Task(String taskName, String taskDescription, String developerFirstName,
                String developerLastName, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        taskCounter++;
    }
   
    // Method to check if the task description is within the 50 character limit
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create and return the task ID
    private String createTaskID() {
        String taskInitials = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerEnd = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3).toUpperCase() : developerLastName.toUpperCase();
        return taskInitials + ":" + taskCounter + ":" + developerEnd;
    }
   
    // Method to return full task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerFirstName + " " + developerLastName + "\n" +
               "Task Number: " + taskCounter + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }
   
    // Static method to keep track of total hours for all tasks
    public static int returnTotalHours(int totalDuration) {
        return totalDuration;
    
    }
}
