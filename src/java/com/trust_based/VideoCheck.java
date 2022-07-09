

package com.trust_based;

import java.sql.*;
import com.database.Queries;


/**
 *
 * @author Bharghava <your.name at your.org>
 */
public class VideoCheck {
    
                        public static void videoCheck(){
                                                        ResultSet r=Queries.getExecuteQuery("select avg(dislikes) from video;");
                    Double dislikesAvg=null;
                    
                   
                    try{
                        r.next();
                        dislikesAvg=r.getDouble(1);
                       }
                   
                    catch(Exception e){
                            
                        e.printStackTrace();
                    }
                   
                    
                    r=Queries.getExecuteQuery("select * from video where dislikes>="+dislikesAvg+" and status='ok';");
                    try{
                    while(r.next()){
                            Double likes=r.getDouble("likes");
                            Double dislikes=r.getDouble("dislikes");
                            Double ratio=likes/dislikes;
                            if(ratio<0.4){//set this value to check this videos,here 40%
                                            int id=r.getInt("id");
                                            String fname=r.getString("fname");
                                             VideoFlag.flag(id,fname);
                            }
                            else{
                            continue;
                            }
                    }
                    }
                    catch(Exception e){
                    
                        e.printStackTrace();
                    }
                        }
                       

}
