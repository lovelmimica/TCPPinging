/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.threads.pitcher;

import com.ekupi.lovelmimica.tcpping.AppStatus;
import com.ekupi.lovelmimica.tcpping.message.Message;
import com.ekupi.lovelmimica.tcpping.message.MessageBuilder;
import com.ekupi.lovelmimica.tcpping.message.MessageStorage;
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
public class SendMessage extends Thread{
    private int port;
    private String host;
    private int size;
    
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public SendMessage(int port, String host, int size) {
        super();
        this.port = port;
        this.host = host;
        this.size = size;
    }

    @Override
    public void run() {
        try {
            setSocket();
            
            sendMessage(size);
            
            receiveResponse();
            
            closeSocket();
        } catch (Exception ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setSocket() throws IOException{
        socket = new Socket(host, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }
    private void closeSocket() throws IOException{
        oos.close();
        ois.close();
        socket.close();
    }
    private void sendMessage(int size) throws IOException{
        
        Message message = MessageBuilder.createMessage(size);
        message.setSent(new Date().getTime());
        String messageString = MessageBuilder.convertMessageToString(message);
        oos.writeObject(messageString);
        oos.flush();
        
        MessageStorage.getInstance().putMessage(message);

    }
    private void receiveResponse() throws Exception{
        String responseString = (String)ois.readObject();
        Message response = MessageBuilder.convertStringToMessage(responseString);
        response.setAtPitcher(new Date().getTime());
        MessageStorage.getInstance().putMessage(response);
        
    }
    
}
