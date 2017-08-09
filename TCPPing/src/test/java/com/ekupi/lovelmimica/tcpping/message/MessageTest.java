/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lovelmimica
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of getAB method, of class Message.
     */
    @Test
    public void testGetAB() {
        Message instance = new Message(0, 0, 100, 110, 120, "aaa");

        assertEquals(10, instance.getAB());
    }

    /**
     * Test of getBA method, of class Message.
     */
    @Test
    public void testGetBA() {
        Message instance = new Message(0, 0, 100, 110, 120, "aaa");

        assertEquals(10, instance.getBA());
    }

    /**
     * Test of getABA method, of class Message.
     */
    @Test
    public void testGetABA() {
        
        Message instance = new Message(0, 0, 100, 110, 120, "aaa");

        assertEquals(20, instance.getABA());
    }

    /**
     * Test of isReturned method, of class Message.
     */
    @Test
    public void testIsReturned() {
       
        Message instance = new Message(0, 0, 100, 110, 120, "aaa");
        assertTrue(instance.isReturned());
        instance = new Message(0, 0, 100, -1, -1, "aaa");
        assertFalse(instance.isReturned());
    }
    
}
