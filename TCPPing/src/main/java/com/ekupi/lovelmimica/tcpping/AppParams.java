/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lovelmimica
 */
public class AppParams {
    private static AppParams instance = new AppParams();
    
    private String MODE = "mode";
    private  String PORT = "-port";
    private  String BIND = "-bind";
    private  String MPS = "-mps";
    private  String SIZE = "-size";
    private  String HOST ="host";
    
    private static Map<String, String> paramMap;

    private AppParams() {
        
    }

    public static AppParams getInstance() {
        return instance;
    }
    
    public void loadParams(String[] args){
        paramMap = new HashMap<>();
        String mode = searchAppModeArg(args);
        String port = searchArgs(PORT, args);
        String bind = searchArgs(BIND, args);
        String mps = searchArgs(MPS, args);
        if(mps == null) mps = "1";
        String size = searchArgs(SIZE, args);
        if(size == null) size = "300";
        
        String host = searcHostname(args);
        
        paramMap.put(MODE, mode);
        paramMap.put(PORT, port);
        paramMap.put(BIND, bind);
        paramMap.put(MPS, mps);
        paramMap.put(SIZE, size);

        if(mode != null && StringComparator.compareStrings("-p", mode)) paramMap.put(HOST, host);
    }
    
    public String getParam(String name){
        if(paramMap.containsKey(name)) return paramMap.get(name);
        return null;
    }
    
    private String searchArgs(String argName, String[] args){
        for(int i = 0; i<args.length; i++){
           if(StringComparator.compareStrings(argName, args[i])) return args[i+1]; 
        }
        return null;
    }
    private String searchAppModeArg(String[] args){
        for(int i = 0; i<args.length; i++){
           if(StringComparator.compareStrings("-p", args[i]) || StringComparator.compareStrings("-c", args[i])) return args[i]; 
        }
        return null;
    }
    private static String searcHostname(String[] args){
        if(args.length == 0) return null;
        return args[args.length-1];
    }
    
   
}
