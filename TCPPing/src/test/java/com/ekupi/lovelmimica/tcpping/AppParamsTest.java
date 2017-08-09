/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping;

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
public class AppParamsTest {
    
    public AppParamsTest() {
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
     * Test of loadParams method, of class AppParams.
     */
    
    @Test
    public void testLoadParams() {
        System.out.println("loadParams");
        String argLine = "–c –port 9900 –bind 192.168.0.1";
        String[] args = argLine.split(" ");
        
        for(int i = 0; i<args.length; i++){
            args[i] = args[i].trim();
        }
        
        AppParams.getInstance().loadParams(args);
        
        assertTrue(StringComparator.compareStrings("-c", AppParams.getInstance().getParam("mode")));
        assertTrue(StringComparator.compareStrings("192.168.0.1", AppParams.getInstance().getParam("-bind")));
        assertTrue(StringComparator.compareStrings("9900", AppParams.getInstance().getParam("-port")));
        
        argLine = "–p –port 9900 –mps 30 –size 1000 kompB";
        args = argLine.split(" ");
        
        for(int i = 0; i<args.length; i++){
            args[i] = args[i].trim();
        }
        AppParams.getInstance().loadParams(args);
        
        assertTrue(StringComparator.compareStrings("-p", AppParams.getInstance().getParam("mode")));
        assertTrue(StringComparator.compareStrings("9900", AppParams.getInstance().getParam("-port")));
        assertTrue(StringComparator.compareStrings("30", AppParams.getInstance().getParam("-mps")));
        assertTrue(StringComparator.compareStrings("1000", AppParams.getInstance().getParam("-size")));
        assertTrue(StringComparator.compareStrings("kompB", AppParams.getInstance().getParam("host")));
        
        
        argLine = "–p –port 9900 -size 1000 –mps 30 kompB";
        args = argLine.split(" ");
        
        for(int i = 0; i<args.length; i++){
            args[i] = args[i].trim();
        }
        AppParams.getInstance().loadParams(args);
        
        assertTrue(StringComparator.compareStrings("-p", AppParams.getInstance().getParam("mode")));
        assertTrue(StringComparator.compareStrings("9900", AppParams.getInstance().getParam("-port")));
        assertTrue(StringComparator.compareStrings("30", AppParams.getInstance().getParam("-mps")));
        assertTrue(StringComparator.compareStrings("1000", AppParams.getInstance().getParam("-size")));
        assertTrue(StringComparator.compareStrings("kompB", AppParams.getInstance().getParam("host")));
    }
    
    
    
}
