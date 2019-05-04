package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_002dmovie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logo.jsp", out, false);
      out.write("\n");
      out.write("        <title>CGV - CMS</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "css.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body id=\"page-top\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header-top.jsp", out, false);
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("            <div id=\"content-wrapper\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <!-- Breadcrumbs-->\n");
      out.write("                    <ol class=\"breadcrumb\">\n");
      out.write("                        <li class=\"breadcrumb-item\">\n");
      out.write("                            <a href=\"home\">Trang chủ</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"breadcrumb-item active\">Thêm phim</li>\n");
      out.write("                    </ol>\n");
      out.write("\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <i class=\"fas fa-plus-square\"></i>\n");
      out.write("                            Nhập thông tin phim mới</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form method=\"get\" action=\"\">\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-5 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"username\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Tên tài khoản\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("                                            <label for=\"inputEmail\">Tên Phim</label>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-2 col-md-5\">\n");
      out.write("                                        <select class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option value=\"\">Độ tuổi</option>\n");
      out.write("                                            <option value=\"0\">0</option>\n");
      out.write("                                            <option value=\"13\">13</option>\n");
      out.write("                                            <option value=\"15\">15</option>\n");
      out.write("                                            <option value=\"18\">18</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-5 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"date\" name=\"username\" id=\"inputDate\" class=\"form-control\" placeholder=\"Ngày khởi chiếu\" required=\"required\" >\n");
      out.write("                                            <label for=\"inputDate\">Ngày khởi chiếu</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-2 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"number\" name=\"username\" id=\"inputTime\" class=\"form-control\" placeholder=\"Thời lượng (Phút)\" required=\"required\">\n");
      out.write("                                            <label for=\"inputTime\">Thời lượng</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                 <div class=\"row form-group\">\n");
      out.write("                                    <div class=\"col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <select class=\"form-control\" id=\"exampleFormControlSelect1\" multiple=\"multiple\">\n");
      out.write("                                            <option value=\"0\">0</option>\n");
      out.write("                                            <option value=\"13\">13</option>\n");
      out.write("                                            <option value=\"15\">15</option>\n");
      out.write("                                            <option value=\"18\">18</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"username\" id=\"inputDirector\" class=\"form-control\" placeholder=\"Đạo diễn\">\n");
      out.write("                                            <label for=\"inputDirector\">Đạo diễn</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"username\" id=\"inputActor\" class=\"form-control\" placeholder=\"Diễn viên\">\n");
      out.write("                                            <label for=\"inputActor\">Diễn viên</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"username\" id=\"inputTrailer\" class=\"form-control\" placeholder=\"Trailer\">\n");
      out.write("                                            <label for=\"inputTrailer\">Trailer</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"file\" name=\"username\" id=\"inputThumb\" class=\"form-control\" placeholder=\"Thumb\">\n");
      out.write("                                            <label for=\"inputThumb\">Thumb</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"file\" name=\"username\" id=\"inputImage\" class=\"form-control\" placeholder=\"Ảnh\">\n");
      out.write("                                            <label for=\"inputImage\">Ảnh</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"inputContent\">Nội dung</label>\n");
      out.write("                                    <textarea class=\"form-control\" id=\"inputContent\" rows=\"5\" id=\"comment\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"btn btn-primary\" type=\"submit\">Thêm</button>\n");
      out.write("                                <a class=\"btn btn-danger\" href=\"home\" style=\"margin-left: 10\">Hủy</a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-footer small text-muted\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("    </div> \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "scrolltotop.jsp", out, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logout.jsp", out, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "javascript.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            let now = new Date();\n");
      out.write("            let year = now.getFullYear();\n");
      out.write("            let day = now.getDate();\n");
      out.write("            let month = now.getMonth() + 1;\n");
      out.write("            if (day < 10) {\n");
      out.write("                day = '0' + day;\n");
      out.write("            }\n");
      out.write("            if (month < 10) {\n");
      out.write("                month = '0' + month\n");
      out.write("            }\n");
      out.write("            var today = year + '-' + month + '-' + day;\n");
      out.write("            $('#inputDate').val(today);\n");
      out.write("        });\n");
      out.write("    </script>\n");
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
