

<%@page import="javax.servlet.annotation.MultipartConfig"%>
<%@page import="com.database.Dbconnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>


<%@page import="java.util.*"%>
<%@page import="java.util.*,java.security.Key,java.util.Random,javax.crypto.Cipher,javax.crypto.spec.SecretKeySpec,org.bouncycastle.util.encoders.Base64"%>

<%@ page import="java.sql.*,java.util.Random,java.io.PrintStream,java.io.FileOutputStream,java.io.FileInputStream,java.security.DigestInputStream,java.math.BigInteger,java.security.MessageDigest,java.io.BufferedInputStream"%>

<%@ page import="java.security.Key,java.security.KeyPair,java.security.KeyPairGenerator,javax.crypto.Cipher"%>
<%@page import="java.util.*,java.text.SimpleDateFormat,java.util.Date,java.io.FileInputStream,java.io.FileOutputStream,java.io.PrintStream"%>

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
    
        <%
	String contentType = request.getContentType();
        
	if ((contentType != null)
			&& (contentType.indexOf("multipart/form-data") >= 0)) {
		DataInputStream in = new DataInputStream(request
				.getInputStream());
		int formDataLength = request.getContentLength();
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead,
					formDataLength);
			totalBytesRead += byteRead;
		}
		String file = new String(dataBytes);
		String saveFile = file
				.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
				saveFile.indexOf("\""));
		out.println(saveFile);
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,
				contentType.length());
		int pos;
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
		FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\videos\\" + saveFile);
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		fileOut.flush();
		fileOut.close();

	
		PreparedStatement psmnt = null;
		
		

		try {

		


			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"dd/MM/yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			Date now = new Date();
			String strDate = sdfDate.format(now);
			String strTime = sdfTime.format(now);
			String dt = strDate + "   " + strTime;

		
 			String likes = "0";
                        String dislikes = "0";
                        Connection con=Dbconnection.getcon();
                        
 			Statement st = con.createStatement();
 		
 			psmnt = con.prepareStatement("insert into video(id,fname,dt,likes,dislikes,shares,source) values(null,?,?,?,?,?,?)");
 			//fis = new FileInputStream(f);
 			//psmnt.setBinaryStream(1, (InputStream)fis, (int)(f.length()));

 			psmnt.setString(1, saveFile);
 			psmnt.setString(2, dt);
                        psmnt.setString(3, likes);
                        psmnt.setString(4, dislikes);
                        psmnt.setInt(5,0);
                        psmnt.setString(6,"server");
 			psmnt.executeUpdate();
 %><Br>
<h2><b>You have successfully upload the file by the name of:<%out.println(saveFile);%></b></h2>

		


<%
	} catch (Exception e) {
		out.print(e.getMessage());
			e.printStackTrace();
		}
	}
%>
        
        


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