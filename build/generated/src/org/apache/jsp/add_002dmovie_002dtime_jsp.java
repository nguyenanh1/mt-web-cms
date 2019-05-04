package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.CodeDefine;

public final class add_002dmovie_002dtime_jsp extends org.apache.jasper.runtime.HttpJspBase
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

            if (session.getAttribute(CodeDefine.USER_ID) == null) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        
      out.write("\n");
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
      out.write("                        <li class=\"breadcrumb-item active\">\n");
      out.write("                            <a href=\"home\">Trang chủ</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"breadcrumb-item\">Thêm lịch chiếu</li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <i class=\"fas fa-plus-square\"></i>\n");
      out.write("                            Thêm lịch chiếu\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-md-12 col-lg-6\">\n");
      out.write("                                        <label for=\"exampleFormControlSelect1\">Chọn phim</label>\n");
      out.write("                                        <select name=\"movie\" class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option>1</option>\n");
      out.write("                                            <option>2</option>\n");
      out.write("                                            <option>3</option>\n");
      out.write("                                            <option>4</option>\n");
      out.write("                                            <option>5</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-md-5 col-lg-2\">\n");
      out.write("                                        <label for=\"exampleFormControlInput1\">Giờ chiếu</label>\n");
      out.write("                                        <input type=\"time\" name=\"time\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-md-7 col-lg-4\">\n");
      out.write("                                        <label for=\"exampleFormControlInput1\">Ngày chiếu</label>\n");
      out.write("                                        <input type=\"date\" name=\"date\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-md-12 col-lg-6\">\n");
      out.write("                                        <label for=\"exampleFormControlSelect1\">Phòng chiếu</label>\n");
      out.write("                                        <select name=\"movie\" class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option>1</option>\n");
      out.write("                                            <option>2</option>\n");
      out.write("                                            <option>3</option>\n");
      out.write("                                            <option>4</option>\n");
      out.write("                                            <option>5</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-md-12 col-lg-6\">\n");
      out.write("                                        <label for=\"exampleFormControlInput1\">Giá vé</label>\n");
      out.write("                                        <input type=\"number\" name=\"time\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"(VND)\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"btn btn-primary\" type=\"submit\">Thêm</button>\n");
      out.write("                                <a class=\"btn btn-danger\" href=\"javascript:history.back()\" style=\"margin-left: 10px\">Hủy</a>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div> \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "scrolltotop.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logout.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "javascript.jsp", out, false);
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
