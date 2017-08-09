/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

import com.ekupi.lovelmimica.tcpping.AppParams;
import com.ekupi.lovelmimica.tcpping.threads.pitcher.PrintingStatistics;
import com.ekupi.lovelmimica.tcpping.threads.pitcher.SendingMessages;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author lovelmimica
 */
public class PitcherMode extends AppMode{

    public PitcherMode() {
        super();
    }
    
    
    
    @Override
    protected boolean checkParams() {
        /*if(args.length != 8) return false;
        
        if((args[0].equalsIgnoreCase("-p") 
                && args[1].equalsIgnoreCase("-port") 
                && args[3].equalsIgnoreCase("-mps")
                && args[5].equalsIgnoreCase("-size")) == false) return false;
        
        try{
            new Integer(args[2]);
            new Integer(args[4]);
            new Integer(args[6]);
        }catch(Exception e) {
            return false;
        }
        try {
            InetAddress.getByName(args[7]);
        } catch (UnknownHostException ex) {
            return false;
        }
        
        return true;*/
        if(AppParams.getInstance().getParam("-port") != null
                && AppParams.getInstance().getParam("-mps") != null 
                && AppParams.getInstance().getParam("-port") != null
                && AppParams.getInstance().getParam("-size") != null
                && AppParams.getInstance().getParam("host") != null) return true;
        else return false;
    }


    @Override
    protected void startThreads() {
        startThread(new SendingMessages(AppParams.getInstance().getParam("host"),
                AppParams.getInstance().getParam("-port"), 
                AppParams.getInstance().getParam("-size"), 
               AppParams.getInstance().getParam("-mps")));
    }
    
}
