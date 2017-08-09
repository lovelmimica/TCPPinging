/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.appmodes;

import com.ekupi.lovelmimica.tcpping.AppStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lovelmimica
 */
public abstract class AppMode {
    protected List<Thread> threadPool; 
    
    protected abstract boolean checkParams();
    protected abstract void startThreads() throws Exception;

    public AppMode() {
        threadPool = new ArrayList<Thread>();
    }
    
    
    
    public void execute() throws Exception{
        if(checkParams() == false) throw new Exception("Invalid parameters for " + this.getClass().getSimpleName() + " mode.");
        
        //loadParams(args);
        startThreads();
    }
    
    public void stopThreads(){
        AppStatus.getInstance().setWorking(false);
        for(Thread t : this.threadPool){
            t.interrupt();
        }
    }
    
    public void startThread(Thread thread){
        thread.start();
        this.threadPool.add(thread);
    }

    public List<Thread> getThreadPool() {
        return threadPool;
    }

    
    
    
}
