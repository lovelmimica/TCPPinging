/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping;

/**
 *
 * @author lovelmimica
 */
public class AppStatus {
    private static AppStatus instance = new AppStatus();

    private AppStatus() {
    }

    
    public static AppStatus getInstance() {
        return instance;
    }
    
    private boolean working = true;

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
    
    
    
}
