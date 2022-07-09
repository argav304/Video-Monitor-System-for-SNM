
<%@page import="com.database.Dbconnection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%@page import="java.util.Random"%>
<%
    String id=request.getParameter("id");
   
    
    try
    {
        Connection con=Dbconnection.getcon();
        Statement st=con.createStatement();
        int i=st.executeUpdate("update request set status='Accepted' where id='"+id+"'");
        if(i>0)
        {
         
       response.sendRedirect("ViewFRequest.jsp?msg=success");
        } else {
            response.sendRedirect("ViewFRequest.jsp?msgg=failed");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>