

<%@page import="com.database.Queries"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
try{
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String mobile=request.getParameter("mobile");
    String address=request.getParameter("address");
    String uname=request.getParameter("username");
    String pwd=request.getParameter("password");
    
    String query="insert into user values(null,'"+name+"','"+email+"','"+mobile+"','"+address+"','"+uname+"','"+pwd+"','waiting',0.0)";
    int i=Queries.getExecuteUpdate(query);
    if(i>0){
      %>
      <script type='text/javascript'>
          window.alert("Registration Successful..!!");
          window.location="Register.jsp";
      </script>
      <%
    }else{
%>
      <script type='text/javascript'>
          window.alert("Registration Failed..!!");
          window.location="Register.jsp";
      </script>
      <%
}
}catch(Exception e){
    out.println(e);
}



%>