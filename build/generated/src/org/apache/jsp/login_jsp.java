package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.CodeDefine;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>CGV CMS - Login</title>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logo.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Custom fonts for this template-->\n");
      out.write("        <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template-->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-dark\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"card card-login mx-auto mt-5\">\n");
      out.write("                <div class=\"card-header\">Đăng nhập vào hệ thống</div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form method=\"post\" action=\"LoginController\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"form-label-group\">\n");
      out.write("                                <input type=\"text\" name=\"username\" id=\"inputEmail\" value=\"\" class=\"form-control\" placeholder=\"Tên tài khoản\" required=\"required\">\n");
      out.write("                                <label for=\"inputEmail\">Tên tài khoản</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"form-label-group\">\n");
      out.write("                                <input type=\"password\" name=\"password\" value=\"\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Mật khẩu\" required=\"required\">\n");
      out.write("                                <label for=\"inputPassword\">Mật khẩu</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div  id=\"fail2\" class=\"d-none\">\n");
      out.write("                            <p style=\"color: red\">Tài khoản không tồn tại</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div  id=\"fail3\" class=\"d-none\">\n");
      out.write("                            <p style=\"color: red\">Mật khẩu đăng nhập không đúng</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div  id=\"fail4\" class=\"d-none\">\n");
      out.write("                            <p style=\"color: red\">Tài khoản của bạn đang đăng nhập ở 1 thiết bị khác</p>\n");
      out.write("                        </div>\n");
      out.write("                        <button class=\"btn btn-primary btn-block\" type=\"submit\">Đăng nhập</button>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"text-center\" style=\"margin-top: 10px\">\n");
      out.write("                        <a class=\"d-block small\" href=\"#\">Quên mật khẩu?</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript-->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Core plugin JavaScript-->\n");
      out.write("        <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function GetURLParameter(sParam) {\n");
      out.write("                var sPageURL = window.location.search.substring(1);\n");
      out.write("                var sURLVariables = sPageURL.split('&');\n");
      out.write("                for (var i = 0; i < sURLVariables.length; i++) {\n");
      out.write("                    var sParameterName = sURLVariables[i].split('=');\n");
      out.write("                    if (sParameterName[0] === sParam)\n");
      out.write("                    {\n");
      out.write("                        return sParameterName[1];\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            let fail = GetURLParameter('fail');\n");
      out.write("            switch (fail) {\n");
      out.write("                case '-1':\n");
      out.write("                    $('#fail2').removeClass('d-none').addClass('d-inline');\n");
      out.write("                    break;\n");
      out.write("                case '-2':\n");
      out.write("                    $('#fail3').removeClass('d-none').addClass('d-inline');\n");
      out.write("                    break;\n");
      out.write("                case '-3' :\n");
      out.write("                    $('#fail4').removeClass('d-none').addClass('d-inline');\n");
      out.write("                    break;\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
