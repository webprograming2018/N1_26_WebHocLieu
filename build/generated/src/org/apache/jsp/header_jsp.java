package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>PTIT STUDY</title>\n");
      out.write("        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"../header.css\">-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.2/css/all.css\" integrity=\"sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!--<script src=\"https://apis.google.com/js/client:platform.js?onload=renderButton\" async defer></script>-->\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"785882447208-cnnkdb3q86glg81ftiil2tdovtugsqrg.apps.googleusercontent.com\">\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"./js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./js/javascript.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
  int i; // i = 1 la da dang nhap, i = 0 la chua dang nhap
            String user = null;
            session = request.getSession();
            if (session.isNew()) {
                session.setAttribute("user", "");
                i = 0;
            } else {
                user = session.getAttribute("user").toString();
                if (user.equals("")) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
        
      out.write("\n");
      out.write("        <header id=\"header\">\n");
      out.write("            <div class =\"wrap\">\n");
      out.write("                <div id=\"logo\"></div>");
 //
                    if (i == 0) {
      out.write("\n");
      out.write("                <div id=\"profile\" class=\"text\">Sign In</div>\n");
      out.write("                ");
 } else {
      out.write("\n");
      out.write("                <div id='admin' class=\"text\">\n");
      out.write("                    ");
      out.print(session.getAttribute("name").toString());
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div id=\"signout\" class=\"text\">Sign out</div>\n");
      out.write("<!--                <scrip>\n");
      out.write("                    function signout(){\n");
      out.write("                    alert('a');\n");
      out.write("                    }\n");
      out.write("                </scrip>-->\n");
      out.write("\n");
      out.write("                ");
 }
                
      out.write("\n");
      out.write("                <div id=\"search_area\">\n");
      out.write("                    <input type=\"text\" name=\"text_search\" id=\"text_search\" placeholder=\"type content to search\" class=\"text\">\n");
      out.write("                    <button id=\"search\" class=\"text\">Search</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"wrap\">\n");
      out.write("            <nav id=\"nav\" class=\"nav2\">\n");
      out.write("                <ul>\n");
      out.write("                    <li title=\"Home\">\n");
      out.write("                        <a href=\"home\">HOME</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li title=\"study process\">\n");
      out.write("                        <a>Study Process</a>\n");
      out.write("                        <ul id=\"case_study\">\n");
      out.write("                            <li title=\"study C\"><a href='studyweb'>STUDY WEB</a></li>\n");
      out.write("                            <li title=\"study java\"><a href=\"#\">STUDY JAVA</a></li>\n");
      out.write("                            <li title=\"study javascript\"><a href=\"#\">STUDY JAVASCRIPT</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li title=\"library\">\n");
      out.write("                        <a href=\"library\">Library</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href ='viewwork'>View Work</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li title=\"profile\">\n");
      out.write("                        <a href=\"profile.html\">Profile</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"sign\" class=\"main-content-agile\">\n");
      out.write("            <div class=\"popup\">\n");
      out.write("                <h2>Using PTIT Account</h2>\n");
      out.write("                <form name=\"aspnetForm\" method=\"post\" id=\"aspnetForm\">\n");
      out.write("                    <input type=\"hidden\" name=\"__EVENTTARGET\" id=\"__EVENTTARGET\" value=\"\" />\n");
      out.write("                    <input type=\"hidden\" name=\"__EVENTARGUMENT\" id=\"__EVENTARGUMENT\" value=\"\" />\n");
      out.write("\n");
      out.write("                    <!-- <div> -->\n");
      out.write("\n");
      out.write("                    <!-- <input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"CA0B0334\" /> -->\n");
      out.write("                    <!-- </div> -->\n");
      out.write("                    <div class=\"field mr-bottom\">\n");
      out.write("                        <span class=\"fa fa-user-o\" aria-hidden=\"true\"></span>\n");
      out.write("                        <input placeholder=\"User\" name=\"ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa\" type=\"text\" id=\"ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa\"\n");
      out.write("                               required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field\">\n");
      out.write("                        <span class=\"fa fa-key\" aria-hidden=\"true\"></span>\n");
      out.write("                        <input placeholder=\"Password\" name=\"ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau\" type=\"password\" id=\"ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau\"\n");
      out.write("                               required />\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"error\">\n");
      out.write("                    </p>\n");
      out.write("                    <div class=\"sub\">\n");
      out.write("                        <a id=\"ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_lnkBtnQuenMK\" href=\"javascript:__doPostBack('ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$lnkBtnQuenMK','')\">Forgot password!</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"submit\">\n");
      out.write("                        <input type=\"submit\" name=\"ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$btnDangNhap\" value=\"Sign In\" id=\"ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_btnDangNhap\" />\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
