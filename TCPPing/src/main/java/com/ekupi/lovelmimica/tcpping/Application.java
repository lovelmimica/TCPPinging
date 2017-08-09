/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping;

import com.ekupi.lovelmimica.tcpping.appmodes.AppMode;
import com.ekupi.lovelmimica.tcpping.appmodes.AppModeFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lovelmimica
 */
public class Application {
    public static void main(String[] args){
        AppParams.getInstance().loadParams(args);
        String appModeName = AppParams.getInstance().getParam("mode");
        AppMode appMode = AppModeFactory.createAppMode(appModeName);
        if(appMode == null) return;
        
        try {
            appMode.execute();
            System.in.read();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        appMode.stopThreads();
        
        
    }
}
