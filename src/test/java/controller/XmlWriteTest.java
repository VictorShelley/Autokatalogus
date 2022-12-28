/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.user;
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
public class XmlWriteTest {
    
    public XmlWriteTest() {
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
     * Test of UserWhite method, of class XmlWrite.
     */
    @Test
    public void testUserWhite() {
        System.out.println("UserWhite");
        ArrayList<user> users = new ArrayList<>();
        Date d = new Date(82,05,12);
        user u = new user("Végh Béla","6969XD","69/6969420","asd@asd.com","4269 Csajágarőcsőge Fő u.69",d);
        users.add(u);
        XmlWrite.UserWhite(users);       
    }
    
}
