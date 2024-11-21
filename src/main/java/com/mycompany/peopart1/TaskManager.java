/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peopart1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RC_Student_lab
 */
public class TaskManager {

    static String[] getDevelopers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final List<String> developers = new ArrayList<>();
    private final List<String> taskNames = new ArrayList<>();
    private final List<String> taskIDs = new ArrayList<>();
    private final List<Integer> taskDurations = new ArrayList<>();
    private final List<String> taskStatuses = new ArrayList<>();

    /**
     * Adds a task to the manager.
     */
    public void addTask(String developer, String taskName, String taskID, int taskDuration, String taskStatus) {
        developers.add(developer);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);
    }

    /**
     * Returns the number of tasks currently in the manager.
     */
    public int getTaskCount() {
        return taskNames.size();
    }

    /**
     * Generates a unique Task ID.
     */
    public static String generateTaskID(String taskName, int taskIndex, String devLastName) {
        return taskName.substring(0, 2).toUpperCase() + ":" +
                taskIndex + ":" +
                devLastName.substring(devLastName.length() - 3).toUpperCase();
    }

    /**
     * Retrieves all tasks with a specific status.
     */
    public String getTasksByStatus(String status) {
        StringBuilder result = new StringBuilder("Tasks with status '" + status + "':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase(status)) {
                result.append("Developer: ").append(developers.get(i)).append("\n")
                        .append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No tasks found with the status '" + status + "'.";
    }

    /**
     * Retrieves the task with the longest duration.
     */
    public String getTaskWithLongestDuration() {
        if (taskDurations.isEmpty()) return "No tasks available.";
        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return "Task with the longest duration:\n" +
                "Developer: " + developers.get(maxIndex) + "\n" +
                "Task Name: " + taskNames.get(maxIndex) + "\n" +
                "Duration: " + taskDurations.get(maxIndex) + " hours";
    }

    /**
     * Searches for a task by its name.
     */
    public String searchTaskByName(String taskName) {
        int index = taskNames.indexOf(taskName);
        if (index != -1) {
            return "Task Found:\n" +
                    "Task Name: " + taskNames.get(index) + "\n" +
                    "Developer: " + developers.get(index) + "\n" +
                    "Status: " + taskStatuses.get(index);
        }
        return "Task not found.";
    }

    /**
     * Deletes a task by its name.
     */
    public String deleteTaskByName(String taskName) {
        int index = taskNames.indexOf(taskName);
        if (index != -1) {
            developers.remove(index);
            taskNames.remove(index);
            taskIDs.remove(index);
            taskDurations.remove(index);
            taskStatuses.remove(index);
            return "Task deleted successfully.";
        }
        return "Task not found.";
    }

    /**
     * Retrieves all tasks.
     */
    public String getAllTasks() {
        if (taskNames.isEmpty()) return "No tasks available.";
        StringBuilder allTasks = new StringBuilder("All Tasks:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            allTasks.append("Task ID: ").append(taskIDs.get(i)).append("\n")
                    .append("Developer: ").append(developers.get(i)).append("\n")
                    .append("Task Name: ").append(taskNames.get(i)).append("\n")
                    .append("Duration: ").append(taskDurations.get(i)).append(" hours\n")
                    .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
        }
        return allTasks.toString();
    }
}
