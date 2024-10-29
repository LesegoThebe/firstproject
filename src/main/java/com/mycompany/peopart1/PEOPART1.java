/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.peopart1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */

public class PEOPART1 {
    
    public static void main(String[] args) {
        Scanner lsg = new Scanner(System.in);
        LOGIN loginApp = new LOGIN();
       
        // Registration and Login
        System.out.println("=== Registration ===");
        System.out.print("Enter Username: ");
        String username = lsg.nextLine();

        System.out.print("Enter Password: ");
        String password = lsg.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = lsg.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = lsg.nextLine();

        String registrationMessage = loginApp.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);

        if (!registrationMessage.equals("User registered successfully!")) {
            System.out.println("Registration failed. Please restart the program.");
            
            return;
        }

        System.out.println("\n=== Login ===");
        System.out.print("Enter Username: ");
        String loginUsername = lsg.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = lsg.nextLine();

        String loginMessage = loginApp.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginMessage);

        if (!loginMessage.startsWith("Welcome")) {
            System.out.println("Login failed. Exiting.");
           
            return;
        }

        // Show EasyKanban welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        List<Task> tasks = new ArrayList<>();
        int totalDuration = 0;

        while (true) {
            // Menu options
            String menuOption = JOptionPane.showInputDialog(
                    "Please select an option:\n" +
                    "1) Add tasks\n" +
                    "2) Show report\n" +
                    "3) Quit"
            );

            if (menuOption == null || menuOption.equals("3")) {
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                break;
            }

            switch (menuOption) {
                case "1": {
                    // Number of tasks to add
                    String taskCountInput = JOptionPane.showInputDialog("How many tasks do you want to enter?");
                    int numberOfTasks;
                    try {
                        numberOfTasks = Integer.parseInt(taskCountInput);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number. Returning to main menu.");
                        continue;
                    }

                    for (int i = 0; i < numberOfTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter Task Name:");

                        String taskDescription;
                        while (true) {
                            taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                            if (taskDescription.length() <= 50) {
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters!");
                            }
                        }

                        String devFirstName = JOptionPane.showInputDialog("Enter Developer First Name:");
                        String devLastName = JOptionPane.showInputDialog("Enter Developer Last Name:");

                        int taskDuration;
                        while (true) {
                            String durationInput = JOptionPane.showInputDialog("Enter Task Duration in hours:");
                            try {
                                taskDuration = Integer.parseInt(durationInput);
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid duration. Please enter a number.");
                            }
                        }

                        String[] statusOptions = {"To Do", "Doing", "Done"};
                        String taskStatus = (String) JOptionPane.showInputDialog(
                                null,
                                "Select Task Status:",
                                "Task Status",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                statusOptions,
                                statusOptions[0]
                        );

                        Task task = new Task(taskName, taskDescription, devFirstName, devLastName, taskDuration, taskStatus);
                        tasks.add(task);
                        totalDuration += taskDuration;

                        JOptionPane.showMessageDialog(null, task.printTaskDetails());
                    }

                    JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + Task.returnTotalHours(totalDuration) + " hours");
                    break;
                }

                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }}}
    