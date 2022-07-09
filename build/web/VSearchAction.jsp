

<%@page import="com.database.Queries"%>
<%@page import="java.sql.ResultSet"%>
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
        <li><a href="UserHome.jsp">Home</a></li>
        <li><a href="ViewMyProfile.jsp">View My Profile</a></li>
        <li><a href="SerachFriends.jsp">Search Friends</a></li>
     
     <li class="active"><a href="SerachVideo.jsp">Search Video</a></li>
     <li><a href="Top_KVideos.jsp">Top-K Videos</a></li>
        <li><a href="SharedVideos.jsp">View All Shared Videos</a></li>
     <li><a href="RemoteUser.jsp">Logout</a></li>  
        
      </ul>
    </div>
   
    <br class="clear" />
  </div>
</div>

   <% 
   
   
   
    String id=(String)session.getAttribute("id");
       String username=(String)session.getAttribute("username");
        String email=(String)session.getAttribute("email");
   
   String vname=request.getParameter("vname");
   %>
        <h2>WELCOME : <%=username%></h2>
    
   

<div class="wrapper col5">
  <div id="container">
    <div id="content">
        <table>
            <tr>
                <th>Video Name</th><th>Share</th>
            </tr>
       <%
       try{
       String query="select * from video where fname='"+vname+"' and not status='check'";
    ResultSet r=Queries.getExecuteQuery(query);
    while(r.next()){
    

Queries.getExecuteUpdate("insert into history values('"+username+"','Search',now())");

    %>
    <tr>
        <td><a href="playVideo.jsp?fname=<%=r.getString("fname")%>"><%=r.getString("fname")%></a></tD> 
        <td><a href="ShareVideoAction.jsp?vid=<%=r.getString("id")%>&fname=<%=r.getString("fname")%>">Share</a></tD> 
    </tR>

<%    
        
    }
       
       
       }catch(Exception e){
           out.println(e);
}%>
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