package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags-->\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"au theme template\">\n");
      out.write("        <meta name=\"author\" content=\"Hau Nguyen\">\n");
      out.write("        <meta name=\"keywords\" content=\"au theme template\">\n");
      out.write("\n");
      out.write("        <!-- Title Page-->\n");
      out.write("        <title>CGV - LOGIN</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"https://www.cgv.vn/media/favicon/default/mst_icon_1_.ico\">\n");
      out.write("\n");
      out.write("        <!-- Fontfaces CSS-->\n");
      out.write("        <link href=\"../assets/back-end/css/font-face.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/font-awesome-4.7/css/font-awesome.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/font-awesome-5/css/fontawesome-all.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/mdi-font/css/material-design-iconic-font.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS-->\n");
      out.write("        <link href=\"../assets/back-end/vendor/bootstrap-4.1/bootstrap.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("        <!-- Vendor CSS-->\n");
      out.write("        <link href=\"../assets/back-end/vendor/animsition/animsition.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/wow/animate.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/css-hamburgers/hamburgers.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/slick/slick.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/select2/select2.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"../assets/back-end/vendor/perfect-scrollbar/perfect-scrollbar.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("        <!-- Main CSS-->\n");
      out.write("        <link href=\"../assets/back-end/css/theme.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"animsition\">\n");
      out.write("        <div class=\"page-wrapper\">\n");
      out.write("            <div class=\"page-content--bge5\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"login-wrap\">\n");
      out.write("                        <div class=\"login-content\">\n");
      out.write("                            <div class=\"login-logo\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <img src=\"https://www.cgv.vn/skin/frontend/cgv/default/images/cgvlogo.png\" alt=\"CoolAdmin\">\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"login-form\">\n");
      out.write("                                <form action=\"\" method=\"post\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Tài khoản</label>\n");
      out.write("                                        <input class=\"au-input au-input--full\" type=\"text\" name=\"username\" placeholder=\"Tên đăng nhập (Gồm 6 - 20 ký tự)\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label>Mật khẩu</label>\n");
      out.write("                                        <input class=\"au-input au-input--full\" type=\"password\" name=\"password\" placeholder=\"Mật khẩu (Gồm 6 ký tự)\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"login-checkbox\">\n");
      out.write("                                        <label>\n");
      out.write("                                            <input type=\"checkbox\" name=\"remember\">Ghi nhớ tài khoản\n");
      out.write("                                        </label>\n");
      out.write("                                        <label>\n");
      out.write("                                            <a href=\"#\">Quên mật khẩu?</a>\n");
      out.write("                                        </label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <button class=\"au-btn au-btn--block au-btn--green m-b-20\" type=\"submit\">Đăng Nhập</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Jquery JS-->\n");
      out.write("        <script src=\"../assets/back-end/vendor/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <!-- Bootstrap JS-->\n");
      out.write("        <script src=\"../assets/back-end/vendor/bootstrap-4.1/popper.min.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/bootstrap-4.1/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Vendor JS       -->\n");
      out.write("        <script src=\"../assets/back-end/vendor/slick/slick.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/wow/wow.min.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/animsition/animsition.min.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/counter-up/jquery.waypoints.min.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/counter-up/jquery.counterup.min.js\">\n");
      out.write("        </script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/circle-progress/circle-progress.min.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/perfect-scrollbar/perfect-scrollbar.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/chartjs/Chart.bundle.min.js\"></script>\n");
      out.write("        <script src=\"../assets/back-end/vendor/select2/select2.min.js\">\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <!-- Main JS-->\n");
      out.write("        <script src=\"../assets/back-end/js/main.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--        <script>\n");
      out.write("            $.ajax({\n");
      out.write("                url: '/api/get-by-price',\n");
      out.write("                type: 'POST',\n");
      out.write("                contentType: 'application/json',\n");
      out.write("                dataType: 'json',\n");
      out.write("                data: JSON.stringify(request),\n");
      out.write("                success: function (data) {\n");
      out.write("                    showListProduct(data);\n");
      out.write("                    console.log(data);\n");
      out.write("                },\n");
      out.write("                error: function ()\n");
      out.write("                {\n");
      out.write("                    alert(\"error\");\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>-->\n");
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
