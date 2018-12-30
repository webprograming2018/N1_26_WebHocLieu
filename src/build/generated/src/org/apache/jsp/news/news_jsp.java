package org.apache.jsp.news;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.SubContent;

public final class news_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <div id=\"wrap\" class=\"wrap\">\n");
      out.write("            <main>\n");
      out.write("                <article>\n");
      out.write("                \n");
      out.write("                ");
 
                    SubContent subContent = (SubContent)request.getAttribute("subContent");
                    String h1 = subContent.getH1();
                    String h2 = subContent.getH2();
                    String time = subContent.getTime().toString();
                    String content = subContent.getContent();
      out.write("                \n");
      out.write("                <h1>");
      out.print(h1);
      out.write("</h1>\n");
      out.write("                <p>");
      out.print(time);
      out.write("</p>\n");
      out.write("                <h2>");
      out.print(h2);
      out.write("</h2>\n");
      out.write("                <div>");
      out.print(content);
      out.write("</div>\n");
      out.write("                </article>\n");
      out.write("                <aside>\n");
      out.write("                    <iframe src=\"https://calendar.google.com/calendar/embed?src=be2kevkq2cj5tgc9tibfiju6ds%40group.calendar.google.com&ctz=Asia%2FSaigon\" style=\"border: 0\" width=\"200\" height=\"200\" frameborder=\"0\" scrolling=\"no\"></iframe>\n");
      out.write("                </aside>\t\t\t\t\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write('\n');
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
