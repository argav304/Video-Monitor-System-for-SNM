/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trust_based;



import java.sql.*;
import com.database.Queries;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Bharghava <your.name at your.org>
 */
@WebServlet(name = "ChangeStatus", urlPatterns = {"/ChangeStatus"})
public class ChangeStatus extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    
        
                    String path="C:\\Users\\bharghava\\OneDrive\\Desktop\\project\\debug.txt";
                    RequestDispatcher rd=request.getRequestDispatcher("/ServerHome.jsp");
                    String id = request.getParameter("id").toString();
                    String accept="update video set status='ok+' where id="+id+";";
                    String reject="delete from video where id="+id+";";
                    ResultSet r=Queries.getExecuteQuery("select fname from video where id="+id+";");
                    String fname="";
                    String username="";
                    ResultSet r1=Queries.getExecuteQuery("select source from video where id="+id+";");
                    Double trust=0.0;
                    try{ //getting values for the file,username and trust
                    r.next();
                    r1.next();
                    fname=r.getString("fname");
                    username=r1.getString("source");
                    ResultSet r2=Queries.getExecuteQuery("select trust from user where username='"+username+"';");
                    r2.first();
                    trust=r2.getDouble("trust");
                    }
                   
                    catch(Exception e){
                    e.printStackTrace();
                    }
                    Write.write("hi", path); 
                    String action=request.getParameter("action").toString();
                        PrintWriter out=response.getWriter();
                        if(action.equalsIgnoreCase("accept")){ //if accept user trust increase acc. to trustplus method and file moved to normal Dir.Status changed to 'ok'
                                Queries.getExecuteUpdate(accept);
                                Accept.filechange(fname);
                                Double temp=TrustCalc.trustplus(trust);
                                Queries.getExecuteUpdate("update user set trust="+temp+" where username='"+username+"';");
                                
                                
                                UserPenalise.penalise(fname);
                                
                        }
                        if(action.equalsIgnoreCase("reject")){// user trust reduced acc to trustmin and video is deleted completely
                            Queries.getExecuteUpdate(reject);
                           File file= new File("C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\review\\"+fname);
                           file.delete();
                           Double temp=TrustCalc.trustmin(trust);
                           Queries.getExecuteUpdate("update user set trust="+temp+" where username='"+username+"';");
                           Queries.getExecuteUpdate("update user set reject=1 where username='"+username+"';");
                           Reward.award(fname);
                        }
                        rd.forward(request, response);
                       
    }
    
    
    }


