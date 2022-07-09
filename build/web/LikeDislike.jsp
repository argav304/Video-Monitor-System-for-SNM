
<%@page import="com.database.Queries"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.Dbconnection"%>
<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trust-Based Video Management Framework for Social Multimedia Networks</title>
        <link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
    </head>
    <body>
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
  String fname= (String)session.getAttribute("videoPath");
     /*retrieving state of response and increasing the respective state count*/
     /*THIS IS THE LIKE-DISLIKE FUNCTIONALITY*/
  String state = (String)request.getParameter("state");
  String column ="";
  if(state.equalsIgnoreCase("LIKE")){
      column="likes";
  }
  if(state.equalsIgnoreCase("DISLIKE")){
      column="dislikes";
  }

  int likeflag=0;
  int dislikeflag=0;
  int empty = 0;
  
  ResultSet r1 = Queries.getExecuteQuery("select * from userinput where username='"+username+"' and fname='"+fname+"'");
  if(r1.next()==false){
      empty=1;
  }
  else{
  likeflag=r1.getInt("likes");
  dislikeflag=r1.getInt("dislikes");
  }
  String getCurrent = "select * from video where fname='"+fname+"'";
  ResultSet r=Queries.getExecuteQuery(getCurrent);
  r.next();
  int ID = r.getInt("id");
  int currentCount = Integer.parseInt(r.getString(column));
  currentCount+=1;
  String value=String.valueOf(currentCount);
  
  PreparedStatement psmnt = null;
  
  if(column.equalsIgnoreCase("likes") && empty==1){
  Queries.getExecuteUpdate("update video set likes='"+value+"' where id='"+ID+"';");
  
 
      likeflag=1;
      
      Connection con=Dbconnection.getcon();
                        
 			Statement st = con.createStatement();
                        psmnt = con.prepareStatement("insert into userinput(id,username,fname,likes,dislikes) values(null,?,?,?,?)");
 			//fis = new FileInputStream(f);
 			//psmnt.setBinaryStream(1, (InputStream)fis, (int)(f.length()));

 			psmnt.setString(1, username);
 			psmnt.setString(2, fname);
                        psmnt.setInt(3, likeflag);
                        psmnt.setInt(4, dislikeflag);
 		
 			psmnt.executeUpdate();
  
  }
  if(column.equalsIgnoreCase("dislikes") && empty ==1 ){
  Queries.getExecuteUpdate("update video set dislikes='"+value+"' where id='"+ID+"';");
  
  
  
      
      dislikeflag=1;
      Connection con=Dbconnection.getcon();
                        
 			Statement st = con.createStatement();
                        psmnt = con.prepareStatement("insert into userinput(id,username,fname,likes,dislikes) values(null,?,?,?,?)");
 			//fis = new FileInputStream(f);
 			//psmnt.setBinaryStream(1, (InputStream)fis, (int)(f.length()));

 			psmnt.setString(1, username);
 			psmnt.setString(2, fname);
                        psmnt.setInt(3, likeflag);
                        psmnt.setInt(4, dislikeflag);
 		
 			psmnt.executeUpdate();
  
  }
  
   %>
        <h2>WELCOME : <%=username%></h2>
        
        
        
        
        
        
    
   

<div class="wrapper col5">
  <div id="container">
    <div id="content">
      <video controls preload="auto" src="./videos/<%=fname%>" width="600" height="400"></video>
				
    </div>
    <div id="column">
        <%
            session.setAttribute("videoPath2",fname);
        %>
            <form action="playVideo.jsp" method="post">
          <input type="submit" name="like" value="LIKE" style="width:100px; height:35px; background-color:#7CFC00; color:#003399;"/>
          <input type="submit"  name="dislike" value="DISLIKE" style="width:100px; height:35px; background-color:#DC143C; color:#003399;"/>
      </form>
       
        
        
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
    </body>
</html>
