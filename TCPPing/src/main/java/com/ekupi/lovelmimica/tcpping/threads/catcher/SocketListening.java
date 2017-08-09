/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.threads.catcher;

import com.ekupi.lovelmimica.tcpping.AppStatus;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lovelmimica
 */
public class SocketListening extends Thread{
    private ServerSocket server;
    public SocketListening(String bindAddress, String port) throws UnknownHostException, IOException {
        super();
        setServer(new Integer(port), 100, InetAddress.getByName(bindAddress));
    }

    @Override
    public void run() {
        System.out.println("Started socket listening....");
        try {
        while(AppStatus.getInstance().isWorking()){
            Socket socket = server.accept();
            if(AppStatus.getInstance().isWorking() == false) break;
            new ReceiveMessage(socket).start();        
        }
        server.close();
        server = null;
        }
        catch (Exception ex) {

        }
        
    }

    @Override
    public void interrupt() {
        try {
            server.close();
            server = null;
        } catch (IOException ex) {
        }
        super.interrupt();
    }
    
    protected void setServer(int port, int backlog, InetAddress inetAddres) throws IOException{
        this.server = new ServerSocket(port, backlog, inetAddres); 
    }

    public ServerSocket getServer() {
        return server;
    }
    
}
