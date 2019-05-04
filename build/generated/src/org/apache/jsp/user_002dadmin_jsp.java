package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import util.CommonUtils;
import service.UserService;
import java.util.ArrayList;
import model.UserAdminMapping;
import java.util.List;
import util.CustomToken;
import common.CodeDefine;

public final class user_002dadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            List<UserAdminMapping> mList = UserService.getInstance().getAll();
        
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
      out.write("                        <li class=\"breadcrumb-item active\">Quản lý người dùng</li>\n");
      out.write("\n");
      out.write("                    </ol>\n");
      out.write("                    <!-- DataTables Example -->\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header d-flex align-items-center\" >\n");
      out.write("                            <i class=\"fas fa-table\"></i>\n");
      out.write("                            Danh sách người dùng CMS\n");
      out.write("\n");
      out.write("                            <a href=\"add-user-admin\" class=\"btn btn-primary ");
      out.print((role == 3 ? "disabled" : ""));
      out.write("\" style=\"margin-left: auto\">Thêm người dùng</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <div class=\"table-responsive\">\n");
      out.write("                                <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Tên tài khoản</th>\n");
      out.write("                                            <th>Họ</th>\n");
      out.write("                                            <th>Tên</th>\n");
      out.write("                                            <th>Quyền</th>\n");
      out.write("                                            <th>Đăng nhập lần cuối</th>\n");
      out.write("                                            <th>Người thêm</th>\n");
      out.write("                                            <th>Ngày thêm</th>\n");
      out.write("                                            <th>Người sửa</th>\n");
      out.write("                                            <th>Ngày sửa</th>\n");
      out.write("                                            <th>Thao tác</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        ");

                                            if (mList != null) {
                                                for (UserAdminMapping item : mList) {
                                        
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>");
      out.print(item.getUsername());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getName());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getLastName());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getRole());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getLastLogin());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getCreatBy());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getCreateTime());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getUpdateBy());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(item.getUpdateTime());
      out.write("</td>\n");
      out.write("                                            <td class=\"text-center\">\n");
      out.write("                                                ");

                                                    if (item.getId() != 1) {
                                                
      out.write("\n");
      out.write("                                                <a title=\"Xóa người dùng\" href=\"UserAdminController?action=del&id=");
      out.print(item.getId());
      out.write("\" class=\"mr10 btn btn-danger ");
      out.print((role == 3 ? "disabled" : ""));
      out.write("\">\n");
      out.write("                                                    <i class=\"fas fa-trash\"></i>\n");
      out.write("                                                </a>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
                                                }
                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-footer small text-muted\"> \n");
      out.write("                            ");
      out.print(("Dữ liệu lấy lúc " +CommonUtils.formatDate(new Date())));
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
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
