/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

/**
 *
 * @author lovelmimica
 */
public class IdGenerator {
    private static int idSequence = 0;
    
    public synchronized static int createNewId(){
        return idSequence++;
    }
}
