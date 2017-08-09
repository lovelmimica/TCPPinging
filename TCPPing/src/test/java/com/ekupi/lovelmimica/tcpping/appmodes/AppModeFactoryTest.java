/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

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
public class AppModeFactoryTest {
    
    public AppModeFactoryTest() {
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
     * Test of createAppMode method, of class AppModeFactory.
     */
    @Test
    public void testCreateAppMode() {
        System.out.println("createAppMode");
        
        assertEquals(AppModeFactory.createAppMode("-p").getClass(),PitcherMode.class);
        assertEquals(AppModeFactory.createAppMode("-c").getClass(),CatcherMode.class);
        assertEquals(AppModeFactory.createAppMode("-g"),null);
        
    }
    
}
