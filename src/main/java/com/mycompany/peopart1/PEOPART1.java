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
        // Scanner for reading user input from the console
        Scanner lsg = new Scanner(System.in);

        // Create an instance of the LOGIN class for registration and login functionality
        LOGIN loginApp = new LOGIN();

      
               // Registration
        System.out.println("====Registration====");
        System.out.print("Enter username: ");
        String username = lsg.nextLine();
        System.out.print("Enter password: ");
        String password = lsg.nextLine();
        System.out.print("Enter first name: ");
        String firstName = lsg.nextLine();
        System.out.print("Enter last name: ");
        String lastName = lsg.nextLine();

        String registrationMessage = loginApp.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User successfully registered.")) {
            // Login
            System.out.println("\nLogin:");
            System.out.print("Enter username: ");
            String inputUsername = lsg.nextLine();
            System.out.print("Enter password: ");
            String inputPassword = lsg.nextLine();

            String loginStatus = loginApp.returnLoginStatus(inputUsername, inputPassword);
            System.out.println(loginStatus);
        }

        // Display EasyKanban welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Initialize a list to store tasks and a variable for tracking total duration
        List<Task> tasks = new ArrayList<>();
        int totalDuration = 0;

        // Main application loop
        while (true) {
            // Display the menu options using JOptionPane
            String menuOption = JOptionPane.showInputDialog(
                    "Please select an option:\n" +
                    "1) Add tasks\n" +
                    "2) Show report\n" +
                    "3) Quit"
            );

            // Exit the application if the user chooses "Quit" or closes the dialog
            if (menuOption == null || menuOption.equals("3")) {
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                break;
            }

            switch (menuOption) {
                case "1": { // Add tasks
                    // Prompt user to specify the number of tasks they want to add
                    String taskCountInput = JOptionPane.showInputDialog("How many tasks do you want to enter?");
                    int numberOfTasks;
                    try {
                        // Parse the input as an integer
                        numberOfTasks = Integer.parseInt(taskCountInput);
                    } catch (NumberFormatException e) {
                        // Handle invalid input
                        JOptionPane.showMessageDialog(null, "Invalid number. Returning to main menu.");
                        continue;
                    }

                    // Loop to create tasks based on the user's input
                    for (int i = 0; i < numberOfTasks; i++) {
                        // Collect task details from the user
                        String taskName = JOptionPane.showInputDialog("Enter Task Name:");

                        String taskDescription;
                        while (true) {
                            // Prompt for task description and validate its length
                            taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                            if (taskDescription.length() <= 50) {
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters!");
                            }
                        }

                        // Collect developer details
                        String devFirstName = JOptionPane.showInputDialog("Enter Developer First Name:");
                        String devLastName = JOptionPane.showInputDialog("Enter Developer Last Name:");

                        int taskDuration;
                        while (true) {
                            // Prompt for task duration and validate it as a number
                            String durationInput = JOptionPane.showInputDialog("Enter Task Duration in hours:");
                            try {
                                taskDuration = Integer.parseInt(durationInput);
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid duration. Please enter a number.");
                            }
                        }

                        // Prompt user to select a task status
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

                        // Create a new Task object and add it to the list
                        Task task = new Task(taskName, taskDescription, devFirstName, devLastName, taskDuration, taskStatus);
                        tasks.add(task);

                        // Accumulate the total duration across all tasks
                        totalDuration += taskDuration;

                        // Display the details of the newly created task
                        JOptionPane.showMessageDialog(null, task.printTaskDetails());
                    }

                    // Display the total hours for all tasks
                    JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + Task.returnTotalHours(totalDuration) + " hours");
                    break;
                }

                case "2": // Show report
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;

                default: // Handle invalid menu options
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
        
        TaskManager taskManager = new TaskManager();

        while (true) {
            // Main menu
            String menuOption = JOptionPane.showInputDialog(
                    "Please select an option:\n" +
                            "1) Add tasks\n" +
                            "2) View tasks with status 'Done'\n" +
                            "3) View task with longest duration\n" +
                            "4) Search for a task by name\n" +
                            "5) Delete a task by name\n" +
                            "6) Display all tasks\n" +
                            "7) Quit"
            );

            if (menuOption == null || menuOption.equals("7")) {
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!");
                break;
            }

            switch (menuOption) {
                case "1": { // Add tasks
                    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                    String taskDescription;

                    while (true) {
                        taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                        if (taskDescription.length() <= 50) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Task description must be less than 50 characters!");
                        }
                    }

                    String devFirstName = JOptionPane.showInputDialog("Enter Developer First Name:");
                    String devLastName = JOptionPane.showInputDialog("Enter Developer Last Name:");
                    String developer = devFirstName + " " + devLastName;

                    int taskDuration;
                    while (true) {
                        try {
                            String durationInput = JOptionPane.showInputDialog("Enter Task Duration (in hours):");
                            taskDuration = Integer.parseInt(durationInput);
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number for duration.");
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

                    // Generate Task ID
                    String taskID = TaskManager.generateTaskID(taskName, taskManager.getTaskCount(), devLastName);

                    // Add task to TaskManager
                    taskManager.addTask(developer, taskName, taskID, taskDuration, taskStatus);

                    JOptionPane.showMessageDialog(null,
                            "Task added successfully:\n" +
                                    "Task ID: " + taskID + "\n" +
                                    "Developer: " + developer + "\n" +
                                    "Duration: " + taskDuration + " hours\n" +
                                    "Status: " + taskStatus
                    );
                    break;
                }

                case "2": { // View tasks with status "Done"
                    String result = taskManager.getTasksByStatus("Done");
                    JOptionPane.showMessageDialog(null, result);
                    break;
                }

                case "3": { // View task with longest duration
                    String result = taskManager.getTaskWithLongestDuration();
                    JOptionPane.showMessageDialog(null, result);
                    break;
                }

                case "4": { // Search for a task by name
                    String searchName = JOptionPane.showInputDialog("Enter the Task Name to search:");
                    String result = taskManager.searchTaskByName(searchName);
                    JOptionPane.showMessageDialog(null, result);
                    break;
                }

                case "5": { // Delete a task by name
                    String deleteName = JOptionPane.showInputDialog("Enter the Task Name to delete:");
                    String result = taskManager.deleteTaskByName(deleteName);
                    JOptionPane.showMessageDialog(null, result);
                    break;
                }

                case "6": { // Display all tasks
                    String allTasks = taskManager.getAllTasks();
                    JOptionPane.showMessageDialog(null, allTasks);
                    break;
                }

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }}
    