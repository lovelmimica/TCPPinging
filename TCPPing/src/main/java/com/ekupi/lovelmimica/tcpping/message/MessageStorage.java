/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author lovelmimica
 */
public class MessageStorage {
    private static MessageStorage instance = new MessageStorage();

    private MessageStorage() {
        messageMap = new HashMap<Integer, Message>();
        
    }

    public static synchronized MessageStorage getInstance() {
        return instance;
    }
    
    private  Map<Integer, Message> messageMap;

    
    public void putMessage(Message message){
        synchronized(this.messageMap){
            messageMap.put(message.getId(), message);
        }
        
    }

    public Map<Integer, Message> getMessageMap() {
        return messageMap;
    }
    
    public long getMaxAB(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        long max = 0;
        
        for(Message m : lastIterationMessages){
            if(m.isReturned() && (m.getAB() > max)) max = m.getAB();
        }
        
        return max;
    }
    public long getMaxBA(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        long max = 0;
        
        for(Message m : lastIterationMessages){
            if(m.isReturned() && (m.getBA() > max)) max = m.getBA();
        }
        
        return max;
    }
    public long getMaxABA(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        long max = 0;
        
        for(Message m : lastIterationMessages){
            if(m.isReturned() && (m.getABA() > max)) max = m.getABA();
        }
        
        return max;
    }
    public long getAverageAB(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        long sum = 0;
        int counter = 0;
        for(Message m : lastIterationMessages){
            if(m.isReturned()) {
                sum += m.getAB();
                counter++;
            }
        }
        if(counter == 0)return Long.MAX_VALUE;
        return sum/counter;
    }
    public long getAverageBA(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        long sum = 0;
        int counter = 0;
        for(Message m : lastIterationMessages){
            if(m.isReturned()) {
                sum += m.getBA();
                counter++;
            }
        }
        if(counter == 0)return Long.MAX_VALUE;
        return sum/counter;
    }
    public long getAverageABA(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        long sum = 0;
        int counter = 0;
        for(Message m : lastIterationMessages){
            if(m.isReturned()) {
                sum += m.getABA();
                counter++;
            }
        }
        if(counter == 0)return Long.MAX_VALUE;
        return sum/counter;
    }
    
    public List<Message> getUnrespondedMessages(int mps){
        List<Message> lastIterationMessages = getLastIterationMsgs(mps);
        List<Message> unrespondedMessages = new ArrayList<Message>();
        
        for(Message m : lastIterationMessages){
            if(m.isReturned() == false) unrespondedMessages.add(m);
        }
        return unrespondedMessages;
    }
   
    public List<Message> getLastIterationMsgs(int mps){
        List<Message> allMessagesList = new ArrayList<>();
        synchronized(this.messageMap){
            Collection<Message> allMessagesCollection = this.messageMap.values();
        
            for(Message m : allMessagesCollection){
                allMessagesList.add(m);
            }
        }
        
       
        allMessagesList.sort(new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                if(m1.getSent() < m2.getSent()) return 1;
                if(m1.getSent() == m2.getSent()) return 0;
                return -1;
            }
        });
        List<Message> lastMessagesList = new ArrayList<>();
        
        for(int i = 0; (i< mps) && (i<allMessagesList.size()); i++){
            lastMessagesList.add(allMessagesList.get(i));
        }
        return lastMessagesList;
    }
    
   
}
