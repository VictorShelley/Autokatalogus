/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import org.json.JSONArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kristóf
 */
public class XmlReadTest {
    
    public XmlReadTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of carRead method, of class XmlRead.
     
    @Test
    public void testCarRead() {
        System.out.println("carRead");
        XmlRead instance = new XmlRead();
        JSONArray expResult = null;
        JSONArray result = instance.carRead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of carValaszt method, of class XmlRead.
     
    @Test
    public void testCarValaszt() {
        System.out.println("carValaszt");
        String alvazszam = "";
        String motorszam = "";
        XmlRead instance = new XmlRead();
        JSONArray expResult = null;
        JSONArray result = instance.carValaszt(alvazszam, motorszam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /*
    @Test
    public void testUserRead() {
        System.out.println("carRead");
        XmlRead instance = new XmlRead();
        JSONArray expResult = null;
        JSONArray result = instance.carRead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}