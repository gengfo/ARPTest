package com.oocl.ir4.arp.service.audittrail;

public class SimpleStringUsage {
    
    public static void main(String[] args){
        
        String bizKey = "";
        
        String[] splitedKeys = bizKey.split(";");
        StringBuffer toPramKeys = new StringBuffer();
        int last = splitedKeys.length -1;
        int seq = 0;
        toPramKeys.append("(");
        while (seq <= last) {

            toPramKeys.append("'");
            toPramKeys.append(splitedKeys[seq]);
            toPramKeys.append("'");
            if (seq != last) {
                toPramKeys.append(",");
            }
            seq = seq + 1;
        }
        toPramKeys.append(")");
        
      System.out.println(toPramKeys);
      
    }

}
