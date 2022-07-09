

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trust-Based Video Management Framework for Social Multimedia Networks</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
</head>
<body id="top">
<div class="wrapper col1">
  <div id="header">
    <div id="logo" style="width:auto;">
      <h1><a href="#">Trust-Based Video Management Framework</a></h1>
      <p><strong>for Social Multimedia Networks</strong></p>
    </div>
    
    <br class="clear" />
  </div>
</div>
<div class="wrapper col2">
  <div id="topbar">
    <div id="topnav">
      <ul>
        <li><a href="index.html">Home</a></li>
        <li class="active"><a href="RemoteUser.jsp">Remote User</a></li>
        <li><a href="VideoServer.jsp">Video Server</a></li>
     
        
        
      </ul>
    </div>
   
    <br class="clear" />
  </div>
</div>
<div class="wrapper col3">
  <div id="intro">

    <div class="fl_right">
    <br class="clear" />
  </div>
</div>

<div class="wrapper col5">
  <div id="container">
    <div id="content">
      <h2>User Remote Registration</h2>
       <form action="UserRegAction.jsp" method="post">
              <%String msg=request.getParameter("msg");
                      if(msg!=null&&msg.equals("success")){
                          %>
                          <font color="red">Registration Successful...!!!</font>
                          <%
}else  if(msg!=null&&msg.equals("failed")){
%>
<font color="red">Registration Failed...!!!</font>
<%
}%>          
          <table>
         
              <tr><th> Name</th><td><input type="text" name="name" required=""></tD></tr>
              <tr><th> Email</th><td><input type="email" name="email" required=""></tD></tr>
              <tr><th>Mobile</th><td><input type="number" name="mobile" required=""></tD></tr>
               <tr><th>Address</th><td><input type="text" name="address" required=""></tD></tr>
               <tr><th>UserName</th><td><input type="text" name="username" required=""></tD></tr>
               <tr><th>Password</th><td><input type="password" name="password" required=""></tD></tr>
               <tr><th></th><td><input type="submit" value="Register"> <a href="RemoteUser.jsp">Login</a>
                  
                  </tD></tr>
          </table>
      </form>


    </div>
    <div id="column">
     
    </div>
    <br class="clear" />
  </div>
</div>
<div class="wrapper col6">
  <div id="footer">
    
    
    
    <br class="clear" />
  </div>
</div>
<div class="wrapper col7">
  <div id="copyright">
    <p class="fl_left">Trust-Based Video Management Framework for Social Multimedia Networks</p>
     <br class="clear" />
  </div>
</div>
</body>
</html>