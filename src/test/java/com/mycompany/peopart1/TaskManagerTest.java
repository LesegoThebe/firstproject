/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.peopart1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskManagerTest {
  @Test
    public void testDeveloperArray() {
        // Expected developer array
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        
        // Actual developer array from the TaskManager class
        String[] actualDevelopers = TaskManager.getDevelopers(); // Assuming this method returns the array of developers
        
        // Assert that the arrays are equal
        assertArrayEquals(expectedDevelopers, actualDevelopers);
    }
    
}