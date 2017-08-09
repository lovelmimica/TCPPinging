/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author lovelmimica
 */
public class MessageBuilder {
    public static Message createMessage(int size) {
        int id;
        
        if(size <50) size = 50;
        if(size > 3000) size = 3000;
        id = IdGenerator.createNewId();
        
        return new Message(id, size);
    }
    
    public static String convertMessageToString(Message message){
        String messageString = message.getId() + " " + message.getSent() + " " 
                + message.getAtCatcher() + " " + message.getAtPitcher() + " ";
        while(messageString.length() < message.getSize()){
            messageString +="a";
        }
        return messageString;
    }
    
    public static Message convertStringToMessage(String messageString){
        String[] contentArray = messageString.split(" ");
        try{
            int id = new Integer(contentArray[0]);
            int size = messageString.length();
            long sent = new Long(contentArray[1]);
            long atCatcher = new Long(contentArray[2]);
            long atPitcher = new Long(contentArray[3]);
            String content = contentArray[4];
            
            return new Message(id, size, sent, atCatcher, atPitcher, content);
            
        }catch(Exception e){
            return null;
        }
    }
        
    
}
