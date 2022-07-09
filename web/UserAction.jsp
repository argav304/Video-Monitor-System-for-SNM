

<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.Queries"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
try{

   
    String uname=request.getParameter("uname");
    String pwd=request.getParameter("pwd");
    
    String query="select * from user where username='"+uname+"'and password='"+pwd+"'";
    ResultSet i=Queries.getExecuteQuery(query);
    if(i.next()){
      String status=i.getString("status");
      if(status.equals("waiting")){
       %>
      <script type='text/javascript'>
          window.alert("You account not activated by server....!!!");
          window.location="RemoteUser.jsp";
      </script>
      <%   
      }else{
       session.setAttribute("id",i.getString("id"));
       session.setAttribute("username",i.getString("username"));
        session.setAttribute("email",i.getString("email"));
        session.setAttribute("trust",i.getDouble("trust"));
%>
      <script type='text/javascript'>
          window.alert("Login Successful...!!");
          window.location="UserHome.jsp";
      </script>
      <%
          }

    }else{
    
%>
      <script type='text/javascript'>
          window.alert("Login Failed..!!");
          window.location="RemoteUser.jsp";
      </script>
      <%
}
}catch(Exception e){
    out.println(e);
}



%>