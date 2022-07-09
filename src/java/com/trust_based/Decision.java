/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trust_based;
import com.database.Queries;
import java.sql.*;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bharghava <your.name at your.org>
 */
@WebServlet(name = "Decision", urlPatterns = {"/Decision"})
public class Decision extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher rd=request.getRequestDispatcher("UploadUserVideo");
            
            HttpSession session=request.getSession();   
            String get="select avg(trust) from user";
            ResultSet r=Queries.getExecuteQuery(get);
            String username=session.getAttribute("username").toString();
            String getUserTrust="select trust from user where username='"+username+"';";
            Double trust,avgtrust;
            PrintWriter out=response.getWriter();
            try{
            r.next();
            avgtrust=Double.parseDouble(r.getString(1));
            r=Queries.getExecuteQuery(getUserTrust);
            r.next();
            trust=Double.parseDouble(r.getString("trust"));
            if(trust>=avgtrust){
                //upload the file
               request.setAttribute("checkflag", "good");
               rd.forward(request, response);
            }
            else{
                request.setAttribute("checkflag", "bad");
               rd.forward(request, response);
                
            }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            
            
    }
}
                
            
           
    

   
            


    
