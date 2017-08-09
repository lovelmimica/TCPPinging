/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.threads;

import com.ekupi.lovelmimica.tcpping.threads.catcher.SocketListening;
import java.net.InetAddress;
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
public class SocketListeningTest {
    
    public SocketListeningTest() {
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
     * Test of setServer method, of class SocketListening.
     */
    @Test
    public void testSetServer() throws Exception {
        System.out.println("setServer");
        String port = "8888";
        String bindAddress = "localhost";
        SocketListening instance = new SocketListening(bindAddress, port);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getServer().getLocalPort() == 8888);
        assertEquals(instance.getServer().getInetAddress(), InetAddress.getByName("localhost"));
        
        instance.interrupt();
    }
    
}
