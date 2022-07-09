/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trust_based;

import java.io.File;

/**
 *
 
 */
public class Delete {
    void delete(String path){
    
        
        File file= new File("C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\review\\"+path);
 
        file.delete();
                }

}
