package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.CustomToken;
import common.CodeDefine;

public final class add_002duser_002dadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            int role;
            CustomToken mToken;
            if (session.getAttribute(CodeDefine.TOKEN) != null) {
                String token = session.getAttribute(CodeDefine.TOKEN).toString();
                mToken = new CustomToken(token);
                role = mToken.getRole();
            } else {
                role = -1;
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
      out.write("                        <li class=\"breadcrumb-item active\">Thêm người dùng</li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <i class=\"fas fa-plus-square\"></i>\n");
      out.write("                            Nhập thông tin người dùng</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            ");

                                if (role != 3) {
                            
      out.write("\n");
      out.write("                            <form action=\"UserAdminController?action=add\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-6 col-md-12\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" pattern=\".{6,15}\" title=\"Tên tài khoản gồm 6-15 ký tự trở lên\" name=\"username\" id=\"inputUserName\" class=\"form-control\" placeholder=\"Tên tài khoản\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("                                            <label for=\"inputUserName\">Tên tài khoản</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-6 col-md-12\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"password\" pattern=\".{6,20}\" title=\"Mật khẩu gồm 6-20 ký tự trở lên\" name=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Mật khẩu\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("                                            <label for=\"inputPassword\">Mật khẩu</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-3 col-md-12\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"isName\" id=\"inputName\" class=\"form-control\" placeholder=\"Tên\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("                                            <label for=\"inputName\">Tên</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-3 col-md-12\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"isLastName\" id=\"inputLastName\" class=\"form-control\" placeholder=\"Họ\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("                                            <label for=\"inputLastName\">Họ</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <fieldset class=\"form-group col-lg-12 col-sm-12 col-md-12\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <legend class=\"col-form-label col-sm-3 col-lg-1 col-md-2 pt-0\">Quyền</legend>\n");
      out.write("                                            <div class=\"col-sm-10\">\n");
      out.write("                                                <div class=\"form-check\">\n");
      out.write("                                                    <input class=\"form-check-input\" type=\"radio\" name=\"role\" id=\"gridRadios2\" value=\"2\" required  ");
      out.print(role < 2 ? "" : "disabled");
      out.write(" >\n");
      out.write("                                                    <label class=\"form-check-label\" for=\"gridRadios   2\">\n");
      out.write("                                                        Quản trị viên\n");
      out.write("                                                    </label>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-check\">\n");
      out.write("                                                    <input class=\"form-check-input\" type=\"radio\" name=\"role\" id=\"gridRadios3\" value=\"3\" required ");
      out.print(role < 3 ? "" : "disabled");
      out.write(" >\n");
      out.write("                                                    <label class=\"form-check-label\" for=\"gridRadios3\">\n");
      out.write("                                                        Quản lý\n");
      out.write("                                                    </label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </fieldset>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"btn btn-primary\" type=\"submit\">Thêm</button>\n");
      out.write("                                <a class=\"btn btn-danger\" href=\"home\" style=\"margin-left: 10px\">Hủy</a>\n");
      out.write("                            </form>\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                                Tài khoản của bạn không có quyền này. Trở về trang <a href=\"user-admin\" class=\"alert-link\">Danh sách người dùng CMS</a>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
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
      out.write("        <script>\n");
      out.write("            let result = GetURLParameter('result');\n");
      out.write("            switch (result) {\n");
      out.write("                case 'success':\n");
      out.write("                    swal(\"Thông báo\", \"Thêm thành công\", \"success\");\n");
      out.write("                    break;\n");
      out.write("                case '-1':\n");
      out.write("                    swal(\"Thông báo\", \"Tên tài khoản đã được sử dụng\");\n");
      out.write("                    break;\n");
      out.write("                case '-2':\n");
      out.write("                    swal(\"Thông báo\", \"Thêm thất bại\");\n");
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
