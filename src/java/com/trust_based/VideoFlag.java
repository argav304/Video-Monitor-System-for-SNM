

package com.trust_based;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
import com.database.Dbconnection;
import com.database.Queries;
import java.io.*;
import java.sql.*;
public class VideoFlag {
    
    public static void flag(int id,String path) throws IOException{
                
                        Queries.getExecuteUpdate("update video set status='check' where id="+id+";");
                        Path temp = Files.move(Paths.get("C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\videos\\"+path),
        Paths.get("C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\review\\"+path));


    }
}
        
                        
                        
                        
                        
                        
    

