/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class MessageStorageTest {
    private List<Message> messageList;
    
    public MessageStorageTest() {
        messageList = new ArrayList<>();
        MessageStorage.getInstance().putMessage(new Message(0, 0, 100, 120, 140, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(1, 0, 110, 130, 150, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(2, 0, 120, 140, 160, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(3, 0, 130, 140, 150, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(4, 0, 140, 150, 160, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(5, 0, 150, 160, 170, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(5, 0, 150, 190, 230, "aaa"));
        //unresponded messsages
        MessageStorage.getInstance().putMessage(new Message(6, 0, 120, -1, -1, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(7, 0, 120, -1, -1, "aaa"));
        MessageStorage.getInstance().putMessage(new Message(8, 0, 120, -1, -1, "aaa"));
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
     * Test of putMessage method, of class MessageStorage.
     */
    @Test
    public void testPutMessage() {
        System.out.println("putMessage");
        
        assertEquals(9, MessageStorage.getInstance().getMessageMap().size());
        
    }

    /**
     * Test of getMaxAB method, of class MessageStorage.
     */
    @Test
    public void testGetMaxAB() {
        System.out.println("getMaxAB");
        assertEquals(40, MessageStorage.getInstance().getMaxAB(3));
    }

    /**
     * Test of getMaxBA method, of class MessageStorage.
     */
    @Test
    public void testGetMaxBA() {
        System.out.println("getMaxBA");
        assertEquals(40, MessageStorage.getInstance().getMaxBA(3));
    }

    /**
     * Test of getMaxABA method, of class MessageStorage.
     */
    @Test
    public void testGetMaxABA() {
        System.out.println("getMaxABA");
        assertEquals(80, MessageStorage.getInstance().getMaxABA(3));
    }

    /**
     * Test of getAverageAB method, of class MessageStorage.
     */
    @Test
    public void testGetAverageAB() {
        System.out.println("getAverageAB");
        assertEquals(20, MessageStorage.getInstance().getAverageAB(3));
    }

    /**
     * Test of getAverageBA method, of class MessageStorage.
     */
    @Test
    public void testGetAverageBA() {
        System.out.println("getAverageBA");
        assertEquals(20, MessageStorage.getInstance().getAverageBA(3));
    }

    /**
     * Test of getAverageABA method, of class MessageStorage.
     */
    @Test
    public void testGetAverageABA() {
        System.out.println("getAverageABA");
        assertEquals(40, MessageStorage.getInstance().getAverageABA(3));
    }

    
    

    /**
     * Test of getUnrespondedMessages method, of class MessageStorage.
     */
    @Test
    public void testGetUnrespondedMessages() {
        System.out.println("testGetUnrespondedMessages");
        assertEquals(0, MessageStorage.getInstance().getUnrespondedMessages(3).size());
    }
    
}
