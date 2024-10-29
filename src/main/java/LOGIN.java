/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 import
 */
import java.util.Scanner;
public class LOGIN {
    public static boolean checkUserName(){
        String username = "leseg_";
        
        if(username.contains("_")&&username.length()<=5){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean containsCapitalLetter(String password){
        
            return password.matches("^(?=.*[A-Z])(?=.\\d)(?=.[^a-zA-Z0-9]).{5,}$");
        }
    
    public static boolean checkPasswordCoplexity(){
        String password = "Le$egoTariqThebe100";
        
        if(password.length()>=8&&containsCapitalLetter(password)){
        
            return true;
        }
        
        else{
        
            return false;
        }
    }
    public static void registerUser(){
        Scanner lsg = new Scanner(System.in);
        
        String username = "leseg_";
        String password = "Le$egoTariqThebe100";
        
        //promt the user to enter username and password
        System.out.println("Please enter your username: ");
        username = lsg.next();
        
        if(username.contains("_")&&username.length()<=5){
            System.out.println("Username successfully captured");
        }
        else{
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters long in length ");
        }
        
        System.out.println("Please enter your password: ");
        password = lsg.next();
        
        if(password.length()>=8&&containsCapitalLetter(password)){
        
            System.out.println("Password successfully captured");
        }
        
        else{
        
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, and a special character");
        }
    }
    
    public static boolean login(){
        String username = "leseg_";
        String password = "Le$egoTariqThebe";
        
       if(username.equals("leseg_")&&password.equals("Le$egoTariqThebe100")){
            return true;
        }
        else{
        
            return false;
        }
    }
    public static void returnLoginStatus(){
        String username = "leseg_";
        String password = "Le$egoTariqThebe100";
        
        if(username.equals("leseg_")&&password.equals("Le$egoTariqThebe100")){
            System.out.println("Welcome Lesego Thebe it is great to see you again");
        }
        else{
        
            System.out.println("Username or password incorrect, pease try again");
        }
    }
}
