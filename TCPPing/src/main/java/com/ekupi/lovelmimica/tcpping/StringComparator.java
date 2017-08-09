/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekupi.lovelmimica.tcpping;

/**
 *
 * @author lovelmimica
 */
public class StringComparator {
    public static boolean compareStrings(String s1, String s2){
       
        if(s1.length() != s2.length()) return false;
        for(int i = 0; i<s1.length(); i++){
            char c1, c2;
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            if((int)c1 == 45 || (int)c1 == 8211 ) continue;
           
            if(c1 != c2) return false;
        }
        
        return true;
        
    }
    
}
