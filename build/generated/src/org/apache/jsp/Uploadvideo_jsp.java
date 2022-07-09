package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.annotation.MultipartConfig;
import com.database.Dbconnection;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.*;
import java.security.Key;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Base64;
import java.sql.*;
import java.util.Random;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.BufferedInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public final class Uploadvideo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Trust-Based Video Management Framework for Social Multimedia Networks</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"layout/styles/layout.css\" type=\"text/css\" />\n");
      out.write("</head>\n");
      out.write("<body id=\"top\">\n");
      out.write("<div class=\"wrapper col1\">\n");
      out.write("  <div id=\"header\">\n");
      out.write("    <div id=\"logo\" style=\"width:auto;\">\n");
      out.write("      <h1><a href=\"#\">Trust-Based Video Management Framework</a></h1>\n");
      out.write("      <p><strong>for Social Multimedia Networks</strong></p>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"wrapper col2\">\n");
      out.write("  <div id=\"topbar\">\n");
      out.write("    <div id=\"topnav\">\n");
      out.write("      <ul>\n");
      out.write("        <li><a href=\"ServerHome.jsp\">Home</a></li>\n");
      out.write("       \n");
      out.write("        <li class=\"active\"><a href=\"VideoServer.jsp\">Logout</a></li>\n");
      out.write("     \n");
      out.write("        \n");
      out.write("        \n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"wrapper col5\">\n");
      out.write("  <div id=\"container\">\n");
      out.write("    <div id=\"content\">\n");
      out.write("    \n");
      out.write("        ");

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

		
 			String rank = "0";
                        /*String dislike = "0";*/
                        Connection con=Dbconnection.getcon();
                        
 			Statement st = con.createStatement();
 		
 			psmnt = con.prepareStatement("insert into video(id,fname,dt,rank) values(null,?,?,?)");
 			//fis = new FileInputStream(f);
 			//psmnt.setBinaryStream(1, (InputStream)fis, (int)(f.length()));

 			psmnt.setString(1, saveFile);
 			psmnt.setString(2, dt);
                        psmnt.setString(3, rank);
                        /*psmnt.setString(4, dislike);*/
 		
 			psmnt.executeUpdate();
 
      out.write("<Br>\n");
      out.write("<h2><b>You have successfully upload the file by the name of:");
out.println(saveFile);
      out.write("</b></h2>\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\n");
      out.write("\n");

	} catch (Exception e) {
		out.print(e.getMessage());
			e.printStackTrace();
		}
	}

      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div id=\"column\">\n");
      out.write("     \n");
      out.write("    </div>\n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"wrapper col6\">\n");
      out.write("  <div id=\"footer\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"wrapper col7\">\n");
      out.write("  <div id=\"copyright\">\n");
      out.write("    <p class=\"fl_left\">Trust-Based Video Management Framework for Social Multimedia Networks</p>\n");
      out.write("     <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
