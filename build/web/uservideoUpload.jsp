<%-- 
    Document   : uservideoUpload
    Created on : Jun 13, 2022, 8:37:21 PM
    Author     : Bharghava <your.name at your.org>
--%>

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
        <li class="active"><a href="ViewMyProfile.jsp">View My Profile</a></li>
        <li><a href="SerachFriends.jsp">Search Friends</a></li>
     
     <li><a href="SerachVideo.jsp">Search Video</a></li>
     <li><a href="Top_KVideos.jsp">Top-K Videos</a></li>
        <li><a href="SharedVideos.jsp">View All Shared Videos</a></li>
        <li><a href="uservideoUpload.jsp">Upload Video</a></li>
     <li><a href="RemoteUser.jsp">Logout</a></li>  
        
      </ul>
    </div>
   
    <br class="clear" />
  </div>
</div>
        <!--++++++++++++++++++++++++++++++write code here++++++++++++++++++++++++++++++++++++-->
        
 <div class="wrapper col5">
  <div id="container">
    <div id="content">
      <h2>Upload Video </h2>
      
 <form action="Decision" method="post"
                        enctype="multipart/form-data">
                <table width="600" border="0" align="center"  cellpadding="0" cellspacing="0"  style="border-collapse: collapse; display:inline; margin:10px 10px 10px 10px; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:14px;">
				
					
					

					<tr>
 						<td   width="100" align="left" valign="middle" height="45" style="color: #2c83b0;"><div align="left" style="margin-left:20px;"><strong >Select <b >Video</b> </strong></div></td>
						<td  width="100" align="left" valign="middle" height="45" style="color: #2c83b0;"><div align="left"><div align="left" style="margin-left:20px;"><input type="file" name="file" style="height:40px" size="30" required=""></div></td>
					</tr>
					<div > <tr><td height="45" colspan="2" id="learn_more" align="center"  style="color:#003399;"><input type="submit" value="Upload" style="width:100px; height:35px; background-color:#999999; color:#003399;"/>
					<input type="reset" name="Reset" style="width:100px; height:35px; background-color:#999999; color:#003399;"/></td></tr></div>
					
					
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
