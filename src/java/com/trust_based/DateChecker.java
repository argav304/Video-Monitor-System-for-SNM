
package com.trust_based;


import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileReader;  


public class DateChecker {
                                            public static String read(){
                                            String s="";
                                            try{
                                            FileReader fr=new FileReader("C:\\Users\\bharghava\\OneDrive\\Desktop\\project\\DATE.txt");    
                                            int i;    
                                            while((i=fr.read())!=-1)    
                                            s+=(char)i;    
                                            fr.close();
                                            }
                                            catch(IOException e){
                                                e.printStackTrace();
                                            }
                                            return s;
                
                }
                public static void write(){
                                                         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                                    LocalDateTime now = LocalDateTime.now();
                                    try{
                                    FileWriter out = new FileWriter("C:\\Users\\bharghava\\OneDrive\\Desktop\\project\\DATE.txt");
                                    out.write(dtf.format(now));
                                    out.close();
                                    }
                                    catch(IOException e){
                                    e.printStackTrace();
                                    }
                }
                public static boolean test(){
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                                    LocalDateTime now = LocalDateTime.now();
                                    if(DateChecker.read().equalsIgnoreCase(dtf.format(now))){
                                                return false;
                                    }
                                    else{
                                        DateChecker.write();
                                        return true;
                                        
                                    }
                }
}








                

                       

