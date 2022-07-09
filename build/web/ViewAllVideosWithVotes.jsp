

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
    <div id="content">
      <h2>View ALL Videos with Votes</h2>
 
      <table style="margin-bottom: 100px;">
          <tr><th>Video Id</th>
          <th>Video Name</th>
           <th>Upload Date</th>
          <th>Video votes</th></tr>
          
          <%try{
          ResultSet r=Queries.getExecuteQuery("select * from video where not status='check'");
          while(r.next()){
              %>
              <tr>
                  <td><%=r.getString("id")%></td>     
                  <td><%=r.getString("fname")%></td>
                   <td><%=r.getString("dt")%></td>
                  <td><%=r.getString("likes")%></td> 
                  
              </tr>
              
              <%
          }
          }catch(Exception e){
            out.println(e);  
          }
          
             %>
          
      </table>
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