/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

/**
 *
 * @author lovelmimica
 */
public class AppModeFactory {
    public static AppMode createAppMode(String name){
        if(name.equalsIgnoreCase("-p")) return new PitcherMode();
        if(name.equalsIgnoreCase("-c")) return new CatcherMode();
        return null;
    }
}
