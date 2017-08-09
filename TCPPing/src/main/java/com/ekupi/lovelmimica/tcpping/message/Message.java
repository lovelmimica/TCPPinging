/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping.message;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lovelmimica
 */
public class Message implements Serializable{
    private int id;
    private int size;
    private long sent = -1;
    private long atCatcher = -1;
    private long atPitcher = -1;
    private String content;

    public Message(int id,int size) {
        this.id = id;
        this.size = size;
        
    }
    public Message(int id,int size, long sent, long atCatcher, long atPitcher, String content) {
        this.id = id;
        
        this.sent = sent;
        this.atCatcher = atCatcher;
        this.atPitcher = atPitcher;
        this.size = size;
        this.content = content;
    }
    public Integer getId() {
        return id;
    }

    public void setSent(long sent) {
        this.sent = sent;
    }

    public long getSent() {
        return sent;
    }

    public long getAtCatcher() {
        return atCatcher;
    }

    public long getAtPitcher() {
        return atPitcher;
    }
    

    public int getSize() {
        return size;
    }

    public String getContent() {
        return content;
    }
    
    
    public void setAtCatcher(long atCatcher) {
        this.atCatcher = atCatcher;
    }

    public void setAtPitcher(long atPitcher) {
        this.atPitcher = atPitcher;
    }

    public long getAB(){
        return atCatcher - sent;
    }
    public long getBA(){
        return atPitcher - atCatcher;
    }
    public long getABA(){
        return atPitcher - sent;
    }
    
    public boolean isReturned(){
        if(sent != -1 && atPitcher == -1) return false;
        return true;
    }
    
}
