

package com.trust_based;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class Write {
        public static String date(){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();  
            return dtf.format(now);
        }
        public static String time(){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
            return dtf.format(now);
        }
        public static void write(String data,String path){
                  try {
              
         FileWriter fileWritter = new FileWriter(path,true);
         BufferedWriter bw = new BufferedWriter(fileWritter);
         bw.write(data);
         bw.newLine();
         bw.close();
         
      } catch(IOException e){
         e.printStackTrace();
      }
   }
    
        }
        
        
        

    



