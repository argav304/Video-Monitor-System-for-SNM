
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Trust-Based Video Management Framework for Social Multimedia Networks</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />

    </head>
    <body>
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
        <li><a href="UserHome.jsp">Home</a></li>
       
        <li class="active"><a href="RemoteUser.jsp">Logout</a></li>
     
        
        
      </ul>
    </div>
   
    <br class="clear" />
  </div>
</div>


<div class="wrapper col5">
  <div id="container">
    <div id="content">
<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
<%
    
  String status = request.getAttribute("status").toString();
  String result="";
  if(status.equalsIgnoreCase("success")){
      result="You have successfully upload the file by the name of:"+request.getAttribute("filepath").toString();

  }
  if(status.equalsIgnoreCase("fail")){
    result = request.getAttribute("error").toString();}
   
%>
    
    <h2><b><%out.println(result);%></b></h2> 
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
