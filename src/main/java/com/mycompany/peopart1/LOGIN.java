/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peopart1;

import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */

class LOGIN {
 // Variables to store user details
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    // Constructor
    public LOGIN() {
    }

    // Method to check if the username contains an underscore and is no more than 5 characters
    public boolean checkUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }

    // Method to check if the password meets the complexity requirements
    public boolean checkPasswordComplexity(String password) {
        // Regex to check at least 8 characters, 1 uppercase, 1 digit, 1 special character
        String passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";
        return Pattern.matches(passwordPattern, password);
    }

    // Method to register the user
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUsername(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            return "User registered successfully!";
        }
    }

    // Method to log in the user
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return login status message
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + ", " + lastName + ", it is great to see you again";
        } else {
            return "Username or password incorrect, please try again";
        }
    }

    
}
