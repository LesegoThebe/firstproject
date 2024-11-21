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
public class PEOPART1Test {
@Test
    public void testLongestDurationTask() {
        Task longestTask = taskManager.getLongestDurationTask();

        assertEquals("Glenda Oberholzer", longestTask.getDeveloper());
        assertEquals(11, longestTask.getDuration());
    }
    
}
