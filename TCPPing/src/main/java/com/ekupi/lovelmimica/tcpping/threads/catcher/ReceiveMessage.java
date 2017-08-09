/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.threads.catcher;

import com.ekupi.lovelmimica.tcpping.message.Message;
import com.ekupi.lovelmimica.tcpping.message.MessageBuilder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lovelmimica
 */
public class ReceiveMessage  extends Thread{
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String messageString;
    private Message message;
    
    public ReceiveMessage(Socket socket) throws Exception {
        this.socket = socket;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        messageString = (String)ois.readObject();
        message = MessageBuilder.convertStringToMessage(messageString);
        message.setAtCatcher((new Date().getTime()));
        System.out.println("Received message id: " + message.getId());
    }

    @Override
    public void run() {
        
        try {
            processMessage();
            sendResponse();
            closeSocket();
        } catch (IOException ex) {
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void processMessage(){
        message.setAtCatcher(new Date().getTime());
        
    }
    private void sendResponse() throws IOException{
        messageString = MessageBuilder.convertMessageToString(message);
        oos.writeObject(messageString);
        oos.flush();
    }
    private void closeSocket() throws IOException{
        oos.close();
        ois.close();
        socket.close();
    }
}
