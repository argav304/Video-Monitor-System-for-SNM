
package com.trust_based;

import com.database.Queries;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Reward {
    
          public static void award(String fname){
        
                               List<String> users=new ArrayList<String>();
                        
                            ResultSet r=Queries.getExecuteQuery("select username from userinput where fname='"+fname+"' and dislikes=1;");
                               try{
                                   while(r.next()){
                                                    users.add(r.getString("username"));
                                                       
                                   }
                                   
                                   }
                               catch(Exception e){
                                   e.printStackTrace();
                               }
                               for(String username:users){
                               r=Queries.getExecuteQuery("select * from user where username='"+username+"';");
                               try{
                                   r.next();
                                   
                                   Double temp = TrustCalc.reward(r.getDouble("trust"));
                                   Queries.getExecuteUpdate("update user set trust="+temp+" where username="+username+"';");
                                   
                               }
                               catch(Exception e){
                               e.printStackTrace();
                               }
                               }
    }

}
