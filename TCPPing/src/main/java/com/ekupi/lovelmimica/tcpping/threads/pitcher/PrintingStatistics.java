/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.threads.pitcher;

import com.ekupi.lovelmimica.tcpping.message.Message;
import com.ekupi.lovelmimica.tcpping.message.MessageStorage;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lovelmimica
 */
public class PrintingStatistics extends Thread{
    private int mps;

    public PrintingStatistics(int mps) {
        this.mps = mps;
    }
    
    
    
    @Override
    public void run() {
        printReport();
        printWarning();
    }
    
    private void printReport(){
        if(MessageStorage.getInstance().getLastIterationMsgs(mps).size() == 0) return;
        StringBuilder sb = new StringBuilder();
        sb.append("Report at " + new Date().toString() + ": ");
        sb.append("mps=" + mps + "\n");
        sb.append("Average AB=" + MessageStorage.getInstance().getAverageAB(mps));
        sb.append("; Average BA=" + MessageStorage.getInstance().getAverageBA(mps));
        sb.append("; Average ABA=" + MessageStorage.getInstance().getAverageABA(mps));
        sb.append("; Max AB=" + MessageStorage.getInstance().getMaxAB(mps));
        sb.append("; Max BA=" + MessageStorage.getInstance().getMaxBA(mps));
        sb.append("; Max ABA=" + MessageStorage.getInstance().getMaxABA(mps) + "\n");
        System.out.println(new String(sb));
    }
    private void printWarning(){
        List<Message> unrespondedMessages = MessageStorage.getInstance().getUnrespondedMessages(mps);
        if(unrespondedMessages.size() > 0){
            StringBuilder sb = new StringBuilder();
            sb.append("Warning: Messages with ids ");
            for(Message m : unrespondedMessages){
                sb.append(m.getId()).append(" ");
            }
            sb.append("has been lost.");
        }
    }
    
}
