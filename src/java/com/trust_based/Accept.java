/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trust_based;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
public class Accept {

    public static void filechange(String path) throws IOException{
    
     Path temp = Files.move
        (Paths.get("C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\review\\"+path),
        Paths.get("C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\videos\\"+path));
 
        
    }

    }
        

