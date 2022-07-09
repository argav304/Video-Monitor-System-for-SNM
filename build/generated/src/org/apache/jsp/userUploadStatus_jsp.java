package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userUploadStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Trust-Based Video Management Framework for Social Multimedia Networks</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"layout/styles/layout.css\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper col1\">\n");
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
      out.write("       \n");
      out.write("        <li class=\"active\"><a href=\"RemoteUser.jsp\">Logout</a></li>\n");
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
      out.write("<!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->\n");

    
  String status = request.getAttribute("status").toString();
  String result="";
  if(status.equalsIgnoreCase("success")){
      result="You have successfully upload the file by the name of:"+request.getAttribute("filepath").toString();

  }
  if(status.equalsIgnoreCase("fail")){
    result = request.getAttribute("error").toString();}
   

      out.write("\n");
      out.write("    \n");
      out.write("    <h2><b>");
out.println(result);
      out.write("</b></h2> \n");
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
      out.write("   \n");
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
      out.write("\n");
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
