package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.database.Queries;
import java.sql.ResultSet;
import com.database.Dbconnection;
import java.sql.*;

public final class LikeDislike_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Trust-Based Video Management Framework for Social Multimedia Networks</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"layout/styles/layout.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <body id=\"top\">\n");
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
      out.write("        <li><a href=\"UserHome.jsp\">Home</a></li>\n");
      out.write("        <li><a href=\"ViewMyProfile.jsp\">View My Profile</a></li>\n");
      out.write("        <li><a href=\"SerachFriends.jsp\">Search Friends</a></li>\n");
      out.write("     \n");
      out.write("     <li class=\"active\"><a href=\"SerachVideo.jsp\">Search Video</a></li>\n");
      out.write("     <li><a href=\"Top_KVideos.jsp\">Top-K Videos</a></li>\n");
      out.write("      <li><a href=\"SharedVideos.jsp\">View All Shared Videos</a></li>\n");
      out.write("     <li><a href=\"RemoteUser.jsp\">Logout</a></li>  \n");
      out.write("        \n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("    <br class=\"clear\" />\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("          \n");
      out.write(" ");
 
   
   
   
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
  
  if(column.equalsIgnoreCase("likes") && likeflag==0){
  Queries.getExecuteUpdate("update video set likes='"+value+"' where id='"+ID+"';");
  if(empty==0){
  Queries.getExecuteUpdate("update userinput set likes=1 where username='"+username+"' and fname='"+fname+"';");    
  }
  else{
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
  }
  if(column.equalsIgnoreCase("dislikes") && dislikeflag ==0 ){
  Queries.getExecuteUpdate("update video set dislikes='"+value+"' where id='"+ID+"';");
  Queries.getExecuteUpdate("update video set likes='"+value+"' where id='"+ID+"';");
  if(empty==0){
  Queries.getExecuteUpdate("update userinput set dislikes=1 where username='"+username+"' and fname='"+fname+"';");    
  }
  else{
      
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
  }
  
   
      out.write("\n");
      out.write("        <h2>WELCOME : ");
      out.print(username);
      out.write("</h2>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    \n");
      out.write("   \n");
      out.write("\n");
      out.write("<div class=\"wrapper col5\">\n");
      out.write("  <div id=\"container\">\n");
      out.write("    <div id=\"content\">\n");
      out.write("      <video controls preload=\"auto\" src=\"./videos/");
      out.print(fname);
      out.write("\" width=\"600\" height=\"400\"></video>\n");
      out.write("\t\t\t\t\n");
      out.write("    </div>\n");
      out.write("    <div id=\"column\">\n");
      out.write("        ");

            session.setAttribute("videoPath2",fname);
        
      out.write("\n");
      out.write("            <form action=\"playVideo.jsp\" method=\"post\">\n");
      out.write("          <input type=\"submit\" name=\"like\" value=\"LIKE\" style=\"width:100px; height:35px; background-color:#7CFC00; color:#003399;\"/>\n");
      out.write("          <input type=\"submit\"  name=\"dislike\" value=\"DISLIKE\" style=\"width:100px; height:35px; background-color:#DC143C; color:#003399;\"/>\n");
      out.write("      </form>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("        \n");
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
      out.write("</html>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
