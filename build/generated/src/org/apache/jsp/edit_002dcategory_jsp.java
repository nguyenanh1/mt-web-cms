package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.CustomToken;
import service.CategoryService;
import pojos.Category;
import model.CategoryUser;
import common.CodeDefine;

public final class edit_002dcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    ");

                        String requestID = request.getParameter("id");
                        int id = -1;
                        try {
                            id = Integer.parseInt(requestID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Category category = CategoryService.getInstance().findById(id);
                    
      out.write("\n");
      out.write("                    <ol class=\"breadcrumb\">\n");
      out.write("                        <li class=\"breadcrumb-item\">\n");
      out.write("                            <a href=\"home\">Trang chủ</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"breadcrumb-item\">\n");
      out.write("                            <a href=\"category\">Danh mục phim</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                            if (category == null) {
                        
      out.write("\n");
      out.write("                        <li class=\"breadcrumb-item active\">404 Not found</li>\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                        <li class=\"breadcrumb-item active\">");
      out.print(category.getName());
      out.write("</li>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <i class=\"fas fa-plus-square\"></i>\n");
      out.write("                            Chỉnh sửa thông tin danh mục</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            ");

                                if (category == null) {
                            
      out.write("\n");
      out.write("                            <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>\n");
      out.write("                            ");

                            } else {
                                if (role != 3) {
                            
      out.write("\n");
      out.write("                            <form action=\"CategoryController?action=update&id=");
      out.print(id);
      out.write("\" method=\"post\">\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-5 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"name\" id=\"inputEmail\" value=\"");
      out.print(category.getName());
      out.write("\" class=\"form-control\" placeholder=\"Tên danh mục\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("                                            <label for=\"inputEmail\">Tên danh mục</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"btn btn-primary\" type=\"submit\">Sửa</button>\n");
      out.write("                                <a class=\"btn btn-danger\" href=\"category\" style=\"margin-left: 10px\">Danh mục phim</a>\n");
      out.write("                            </form>\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                                Tài khoản của bạn không có quyền này. Trở về trang <a href=\"movie\" class=\"alert-link\">danh sách phim</a>\n");
      out.write("                            </div>\n");
      out.write("                            ");
                                     }
                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "scrolltotop.jsp", out, false);
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "logout.jsp", out, false);
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "javascript.jsp", out, false);
      out.write("\n");
      out.write("            <script>\n");
      out.write("                let alert = GetURLParameter(\"alert\");\n");
      out.write("                if (alert === \"sucsses\") {\n");
      out.write("                    swal(\"Thông báo\", \"Sửa thành công\", \"success\")\n");
      out.write("                            .then((value) => {\n");
      out.write("                                if (value) {\n");
      out.write("                                    window.location.replace(\"category\");\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                }\n");
      out.write("                if (alert === \"fail\") {\n");
      out.write("                    swal(\"Thông báo\", \"Sửa thất bại\");\n");
      out.write("                }\n");
      out.write("            </script>\n");
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
