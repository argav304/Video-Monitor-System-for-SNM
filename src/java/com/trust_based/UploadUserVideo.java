
package com.trust_based;
import javax.servlet.annotation.MultipartConfig;
import com.database.Dbconnection;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.Key;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Base64;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.BufferedInputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.*;  
import javax.servlet.http.*;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bharghava <your.name at your.org>
 */
@WebServlet(name = "UploadUserVideo", urlPatterns = {"/UploadUserVideo"})
public class UploadUserVideo extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
       String status = "null";
        HttpSession session=request.getSession();   
       RequestDispatcher rd=request.getRequestDispatcher("/userUploadStatus.jsp");    
       String contentType = request.getContentType();
       String checkflag=request.getAttribute("checkflag").toString();

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
    if(checkflag.equalsIgnoreCase("good")){
    FileOutputStream fileOut = new FileOutputStream(
            "C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\videos\\" + saveFile);
    fileOut.write(dataBytes, startPos, (endPos - startPos));
    fileOut.flush();
    fileOut.close();
    }
    if(checkflag.equalsIgnoreCase("bad")){
    FileOutputStream fileOut = new FileOutputStream(
            "C:\\Users\\bharghava\\Downloads\\Trust-Based Video Management Framework for Social Multimedia Networks\\SOURCE CODE\\Trust-Based Video Management Framework for Social Multimedia Networks\\web\\review\\" + saveFile);
    
    fileOut.write(dataBytes, startPos, (endPos - startPos));
    fileOut.flush();
    fileOut.close();
    }
    String user = session.getAttribute("username").toString();
    
    PreparedStatement psmnt = null;
    
    

    try {

    


        SimpleDateFormat sdfDate = new SimpleDateFormat(
                "dd/MM/yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

        Date now = new Date();
        String strDate = sdfDate.format(now);
        String strTime = sdfTime.format(now);
        String dt = strDate + "   " + strTime;
        String videostatus="";
        if(checkflag.equalsIgnoreCase("good")){
            videostatus = "ok";
        }
        if(checkflag.equalsIgnoreCase("bad")){
            videostatus = "check";
        }
        
    
        String likes = "0";
        String dislikes = "0";
        Connection con=Dbconnection.getcon();
                    
         Statement st = con.createStatement();
     
         psmnt = con.prepareStatement("insert into video(id,fname,dt,likes,dislikes,shares,source,status) values(null,?,?,?,?,?,?,?)");
         //fis = new FileInputStream(f);
         //psmnt.setBinaryStream(1, (InputStream)fis, (int)(f.length()));

         psmnt.setString(1, saveFile);
         psmnt.setString(2, dt);
         psmnt.setString(3, likes);
         psmnt.setString(4, dislikes);
         psmnt.setInt(5,0);
         psmnt.setString(6, user);
         psmnt.setString(7, videostatus);          
                    
     
         psmnt.executeUpdate();
                    status = "success";
                    request.setAttribute("status",status);
                    request.setAttribute("filepath",saveFile);
                    
                    } 
            
            catch (Exception e) {
               status="fail"; 
               request.setAttribute("status",status);
               String err = e.getMessage();
               request.setAttribute("error", err);
            }
}
rd.forward(request, response);
        
        }
    }


