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
public class IdGeneratorTest {
    
    public IdGeneratorTest() {
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
     * Test of createNewId method, of class IdGenerator.
     */
    @Test
    public void testCreateNewId() {
        System.out.println("createNewId");
        
        assertEquals(0, IdGenerator.createNewId());
        assertEquals(1, IdGenerator.createNewId());
        assertEquals(2, IdGenerator.createNewId());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
