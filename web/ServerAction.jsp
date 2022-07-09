
<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.Queries"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
try{

   
    String uname=request.getParameter("uname");
    String pwd=request.getParameter("pwd");
    

    if(uname.equals(" ")&&pwd.equals(" ")){
      
      %>
      <script type='text/javascript'>
          window.alert("Login Successful...!!");
          window.location="ServerHome.jsp";
      </script>
      <%

    }else{
    
%>
      <script type='text/javascript'>
          window.alert("Login Failed..!!");
          window.location="VideoServer.jsp";
      </script>
      <%
}
}catch(Exception e){
    out.println(e);
}



%>