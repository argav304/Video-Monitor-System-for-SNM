<%-- 
    Document   : serverreview
    Created on : Jun 17, 2022, 12:18:42 AM
    Author     : Bharghava <your.name at your.org>
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.Queries"%>
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
        <li><a href="ServerHome.jsp">Home</a></li>
       
        <li class="active"><a href="VideoServer.jsp">Logout</a></li>
     
        
        
      </ul>
    </div>
   
    <br class="clear" />
  </div>
</div>


<div class="wrapper col5">
  <div id="container">
      <table style="margin-bottom: 100px;">
          <tr><th>Source</th>
          <th>Video Name</th>
           <th>Dislikes</th>
         <th>Action</th></tr>
          
          <%try{
              int id;
          ResultSet r=Queries.getExecuteQuery("select * from video where status='check'");
          while(r.next()){
              id=r.getInt("id");
              
              %>
              <tr>
                  <td><%=r.getString("source")%></td>     
                  <td><%=r.getString("fname")%></td>
                   <td><%=r.getString("dislikes")%></td>
                   <td><a href="ChangeStatus?action=accept&id=<%=id%>">Accept</a><span> | </span><a href="ChangeStatus?action=reject&id=<%=id%>">Reject</a></td>
                   
                  
              </tr>
              
              <%
          }
          }catch(Exception e){
            out.println(e);  
          }
          
             %>
          
      </table>
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