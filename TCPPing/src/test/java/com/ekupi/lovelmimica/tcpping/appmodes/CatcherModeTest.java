/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

import com.ekupi.lovelmimica.tcpping.AppParams;
import com.ekupi.lovelmimica.tcpping.threads.catcher.SocketListening;
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
public class CatcherModeTest {
    
    public CatcherModeTest() {
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
     * Test of checkParams method, of class CatcherMode.
     */
    @Test
    public void testCheckParams() {
        System.out.println("checkParams");
        String argsLine_1 = "-c -port 8888 -bind 192.168.0.1"; 
        String argsLine_2 = "-c -port 88e88 -bind 192.168.0.1";
        String argsLine_3 = "-c -bind 124.168.0.1 -port 8888";
        String argsLine_4 = "-c -port 8888 -biDnd 192.168.0.1";
        String argsLine_5 = "-c -portt 8888 -bind 192.168.0.1";
        
        CatcherMode instance = new CatcherMode();
        
        AppParams.getInstance().loadParams(argsLine_1.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_2.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_3.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_4.split(" "));
        assertFalse(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_5.split(" "));
        assertFalse(instance.checkParams());
              
        
    }

    

    /**
     * Test of startThreads method, of class CatcherMode.
     */
    @Test
    public void testStartThreads() {
        CatcherMode instance = new CatcherMode();
        try {
            AppParams.getInstance().loadParams("-c -port 8888 -bind localhost".split(" "));
            instance.startThreads();
            assertEquals(1, instance.getThreadPool().size());
            assertEquals(SocketListening.class, instance.getThreadPool().get(0).getClass());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        instance.stopThreads();
    }
    
}
