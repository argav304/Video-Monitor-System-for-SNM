package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.database.Queries;

public final class AllSharedVideos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      <h2>View ALL Shared Video</h2>\n");
      out.write(" \n");
      out.write("     <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Video Shared By</th><th>Video Share To </th><th>Shared To Id</th>\n");
      out.write("            </tr>\n");
      out.write("       ");

       try{
       String query="select * from share";
    ResultSet r=Queries.getExecuteQuery(query);
    while(r.next()){
      

    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(r.getString("username"));
      out.write("</td>\n");
      out.write("        <td><a href=\"SplayVideo.jsp?fname=");
      out.print(r.getString("videoname"));
      out.write('"');
      out.write('>');
      out.print(r.getString("videoname"));
      out.write("</a></tD> \n");
      out.write("         <td>");
      out.print(r.getString("fid"));
      out.write("</td>\n");
      out.write("    </tR>\n");
      out.write("\n");
    
        
    }
       
       
       }catch(Exception e){
           out.println(e);
}
      out.write("\n");
      out.write("        </table>\n");
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
