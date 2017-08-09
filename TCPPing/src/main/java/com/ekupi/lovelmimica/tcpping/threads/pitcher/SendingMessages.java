/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.threads.pitcher;

import com.ekupi.lovelmimica.tcpping.AppStatus;
import java.util.Date;

/**
 *
 * @author lovelmimica
 */
public class SendingMessages extends Thread{
    private long start;
    private long end;
    private long interval = 1000;
    private int port;
    private int mps;
    private int size;
    private String host;
    
    public SendingMessages(String host, String port, String size, String mps) {
        super();
        this.port = new Integer(port);
        this.mps = new Integer(mps);
        this.size = new Integer(size);
        this.host = host;
    }

    @Override
    public void run() {
        while(AppStatus.getInstance().isWorking()){
            start = new Date().getTime();
        for(int i = 0; i < mps; i++){
            new SendMessage(port, host, size).start();
        }

        end = new Date().getTime();
        sleep();
        new PrintingStatistics(mps).start();
        }
    }
    
    private void sleep(){
        long duration = this.end - this.start;
        if(duration < interval)try {
            Thread.sleep(interval - duration);
        } catch (InterruptedException ex) {

        }
    }
}
