package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Hello World</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   <h1>Hello World From Struts2</h1>\n");
      out.write("   <form action=\"database_converter\">\n");
      out.write("      <label for=\"name\">Database Converter</label><br/><br/>\n");
      out.write("      Source: \n");
      out.write("      <select name=\"source\">\n");
      out.write("          <option value=\"CSV\">CSV</option>\n");
      out.write("          <option value=\"Excel\">Excel</option>\n");
      out.write("          <option value=\"MySQL\">MySQL</option>\n");
      out.write("      </select>\n");
      out.write("      <br/><br/>\n");
      out.write("      Source Parameter 1: <input type=\"text\" name=\"sourceParam1\" />\n");
      out.write("      <br/>\n");
      out.write("      Source Parameter 2: <input type=\"text\" name=\"sourceParam2\" />\n");
      out.write("      <br/>\n");
      out.write("      Source Parameter 3: <input type=\"text\" name=\"sourceParam3\" />\n");
      out.write("      <br/>\n");
      out.write("      Source Parameter 4: <input type=\"text\" name=\"sourceParam4\" />\n");
      out.write("      <br/>\n");
      out.write("      Source Parameter 5: <input type=\"text\" name=\"sourceParam5\" />\n");
      out.write("      <br />\n");
      out.write("      Source File:\n");
      out.write("      <input type=\"file\" name=\"sourceFile\" />\n");
      out.write("      </br><br/><br/>\n");
      out.write("      Destination:\n");
      out.write("      <select name=\"destination\">\n");
      out.write("          <option value=\"CSV\">CSV</option>\n");
      out.write("          <option value=\"Excel\">Excel</option>\n");
      out.write("          <option value=\"MySQL\">MySQL</option>\n");
      out.write("      </select>\n");
      out.write("      <br/><br/>\n");
      out.write("      Destination Parameter 1: <input type=\"text\" name=\"destinationParam1\" />\n");
      out.write("      <br/>\n");
      out.write("      Destination Parameter 2: <input type=\"text\" name=\"destinationParam2\" />\n");
      out.write("      <br/>\n");
      out.write("      Destination Parameter 3: <input type=\"text\" name=\"destinationParam3\" />\n");
      out.write("      <br/>\n");
      out.write("      Destination Parameter 4: <input type=\"text\" name=\"destinationParam4\" />\n");
      out.write("      <br/>\n");
      out.write("      Destination Parameter 5: <input type=\"text\" name=\"destinationParam5\" />\n");
      out.write("      </br><br/><br/>\n");
      out.write("      <input type=\"submit\" value=\"Convert\"/>\n");
      out.write("   </form>\n");
      out.write("</body>\n");
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
