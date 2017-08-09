/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

import com.ekupi.lovelmimica.tcpping.AppParams;
import com.ekupi.lovelmimica.tcpping.threads.catcher.SocketListening;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lovelmimica
 */
public class CatcherMode extends AppMode{

    public CatcherMode() {
        super();
    }
    
    @Override
    protected boolean checkParams() {
               
        if(AppParams.getInstance().getParam("-port") != null 
                && AppParams.getInstance().getParam("-bind") != null) return true;
        return false;
    }

    

    @Override
    protected void startThreads() throws IOException {
        startThread(new SocketListening(AppParams.getInstance().getParam("-bind"), AppParams.getInstance().getParam("-port")));
    }
    
    
}
