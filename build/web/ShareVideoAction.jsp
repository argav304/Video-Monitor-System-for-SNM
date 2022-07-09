

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
   
   String vid=request.getParameter("vid");
   String fname=request.getParameter("fname");
   %>
        <h2>WELCOME : <%=username%></h2>
    
   

<div class="wrapper col5">
  <div id="container">
    <div id="content">
        <form action="ShareAction2.jsp" method="post">
        <table>
            <tr>
                <th>Video Id</th><td><input type="text" name="vid" value="<%=vid%>" readonly=""></td>
            </tr>
             <tr>
                <th>Video Name</th><td><input type="text" name="vname" value="<%=fname%>" readonly=""></td>
            </tr>
            <tr>
                <th>Select Friend To Share</th><td>
                    <select name="fid" required="">
            <option></option>
             <%try{
       String query="select * from request where status!='waiting'";
       ResultSet r=Queries.getExecuteQuery(query);
       while(r.next()){
          String sendt=r.getString("sendto");
          String sendf=r.getString("sendfrom"); 
          if(username.equals(sendt)){
           %>
           <option value="<%=r.getString("sendfrom_id")%>"><%=r.getString("sendfrom")%></option>
           <%
          }if(username.equals(sendf)){
%>
 <option value="<%=r.getString("sendto_id")%>"><%=r.getString("sendto")%></option>
<%
}
       }
       }catch(Exception e){
           out.println(e);
}%>
            
            
            
                    </select>
                </td>
            </tr>
            <tr><th><input type="submit" value="Share"></th></tr>
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