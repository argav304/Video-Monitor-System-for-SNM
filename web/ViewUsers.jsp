

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
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
      <h2>View ALL Users & Authorize</h2>
 
      <table style="margin-bottom: 100px;">
          <tr><th>Name</th>
          <th>Email</th>
           <th>Mobile</th>
          <th>Address</th>
           <th>Status</th></tr>
          
          <%try{
          ResultSet r=Queries.getExecuteQuery("select * from user");
          while(r.next()){
              String status=r.getString("status");
              %>
              <tr>
                  <td><%=r.getString("name")%></td>     
                  <td><%=r.getString("email")%></td>
                   <td><%=r.getString("mobile")%></td>
                  <td><%=r.getString("address")%></td> 
                  <%if(status.equals("waiting")){
                    %>
                    <td><a href="UActivate.jsp?id=<%=r.getString("id")%>">Authorize</a></tD> 
                    <%
                  }else{
              %>
                    <td><%=r.getString("status")%></td>
              <%
}%>
                  
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
</html>
