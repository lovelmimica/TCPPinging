/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

import java.util.List;
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
public class AppModeTest {
    
    public AppModeTest() {
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
     * Test of startThread method, of class AppMode.
     */
    @Test
    public void testStartThread() {
        System.out.println("startThread");

        AppMode instance = new AppModeImpl_1();
        
        instance.startThread(new Thread());
        assertEquals(1, instance.getThreadPool().size());
        
        instance.startThread(new Thread());
        assertEquals(2, instance.getThreadPool().size());
    }

    public class AppModeImpl_1 extends AppMode {

        public boolean checkParams() {
            return false;
        }

        
        public void startThreads() {
        }
    }
    
}
