/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

import com.ekupi.lovelmimica.tcpping.AppParams;
import com.ekupi.lovelmimica.tcpping.threads.pitcher.PrintingStatistics;
import com.ekupi.lovelmimica.tcpping.threads.pitcher.SendingMessages;
import com.ekupi.lovelmimica.tcpping.threads.catcher.SocketListening;
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
public class PitcherModeTest {
    
    public PitcherModeTest() {
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
     * Test of checkParams method, of class PitcherMode.
     */
    @Test
    public void testCheckParams() {
        System.out.println("checkParams");
        String argsLine_1 = "-p -port 8888 -mps 30 -size 50 192.168.0.1"; 
        String argsLine_2 = "-p -port 888r8 -mps 30 -size 50 192.168.0.1";
        String argsLine_3 = "-p -port 8888 -size 50 192.168.0.1 -mps 100";
        String argsLine_4 = "-p -porwt 8888 -mps 30 -size 5r0 192.168.0.1";
        String argsLine_5 = "-p -size 50 -port 8888 -mps 30 124.168.0.1";
        String argsLine_6 = "-p -prort 8888 -mps 30 -size 50 192.168.0.1";
        String argsLine_7 = "-p -port 8888 -size 50 192.168.0.1";
        String argsLine_8 = "-p -port 8888 -mps 30 192.168.0.1";
        
        PitcherMode instance = new PitcherMode();
        AppParams.getInstance().loadParams(argsLine_1.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_2.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_3.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_4.split(" "));
        assertFalse(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_5.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_6.split(" "));
        assertFalse(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_7.split(" "));
        assertTrue(instance.checkParams());
        
        AppParams.getInstance().loadParams(argsLine_8.split(" "));
        assertTrue(instance.checkParams());
        
  
    }

    
    /**
     * Test of startThreads method, of class PitcherMode.
     */
    @Test
    public void testStartThreads() {
        PitcherMode instance = new PitcherMode();
        AppParams.getInstance().loadParams("-p -port 8888 -mps 30 -size 50 192.168.0.1".split(" "));
        instance.startThreads();
        
        assertEquals(1, instance.getThreadPool().size());
        assertEquals(SendingMessages.class, instance.getThreadPool().get(0).getClass());
    }
    
}
