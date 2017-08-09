/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MessageBuilderTest {
    
    public MessageBuilderTest() {
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
     * Test of createMessage method, of class MessageBuilder.
     */
    @Test
    public void testCreateMessage() {
        System.out.println("createMessage");
        
        Message m = MessageBuilder.createMessage(40);
        
        assertEquals(50, m.getSize());
    }

    /**
     * Test of convertMessageToString method, of class MessageBuilder.
     */
    @Test
    public void testConvertMessageToString() {
        System.out.println("convertMessageToString");
        Message message =MessageBuilder.createMessage(40);
        String messageString = MessageBuilder.convertMessageToString(message);
        
        
        String[] contentArray = messageString.split(" ");
        
        
        assertEquals(50, messageString.length());
        assertEquals(5, contentArray.length);
        
        //assertEquals(contentArray[0], "1");
        assertEquals(contentArray[1], "-1");
        assertEquals(contentArray[2], "-1");
        assertEquals(contentArray[3], "-1");
        
    }

    /**
     * Test of convertStringToMessage method, of class MessageBuilder.
     */
    @Test
    public void testConvertStringToMessage() {
        System.out.println("convertStringToMessage");
        String messageString = "1 5000 6000 7000 abc";
        Message message = MessageBuilder.convertStringToMessage(messageString);
        
        assertEquals(new Integer(1), message.getId());
        assertEquals(5000, message.getSent());
        assertEquals(6000, message.getAtCatcher());
        assertEquals(7000, message.getAtPitcher());
        assertEquals("abc", message.getContent());
        assertEquals(messageString.length(), message.getSize());
    }

    
}
