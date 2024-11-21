/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.peopart1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
 

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        Task instance = null;
        boolean expResult = false;
        boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        Task instance = null;
        String expResult = "";
        String result = instance.printTaskDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @org.junit.jupiter.api.Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        int totalDuration = 0;
        int expResult = 0;
        int result = Task.returnTotalHours(totalDuration);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
