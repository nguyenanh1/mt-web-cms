package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("    <!-- Sidebar -->\n");
      out.write("    <ul class=\"sidebar navbar-nav\">\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"index.html\">\n");
      out.write("          <i class=\"fas fa-fw fa-home\"></i>\n");
      out.write("          <span>Trang chủ</span>\n");
      out.write("        </a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"pagesDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          <i class=\"fas fa-fw fa-film\"></i>\n");
      out.write("          <span>Quản lý phim</span>\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"pagesDropdown\">\n");
      out.write("          <h6 class=\"dropdown-header\">Phim</h6>\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Thêm phim</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"register.html\">Xem danh sách phim</a>\n");
      out.write("          <div class=\"dropdown-divider\"></div>\n");
      out.write("          <h6 class=\"dropdown-header\">Danh mục phim</h6>\n");
      out.write("          <a class=\"dropdown-item\" href=\"404.html\">Thêm danh mục</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"blank.html\">Xem danh mục</a>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"pagesDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          <i class=\"fas fa-fw fa-tv\"></i>\n");
      out.write("          <span>Quản lý phòng chiếu</span>\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"pagesDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Thêm phòng chiếu</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Xem phòng chiếu</a>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"pagesDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          <i class=\"fas fa-fw fa-calendar-alt\"></i>\n");
      out.write("          <span>Q.lý kế hoạch chiếu</span>\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"pagesDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Thêm lịch chiếu</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Xem lịch chiếu</a>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"tables.html\">\n");
      out.write("          <i class=\"fas fa-fw fa-user-friends\"></i>\n");
      out.write("          <span>Quản lý người dùng</span></a>\n");
      out.write("      </li>\n");
      out.write("       <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"tables.html\">\n");
      out.write("          <i class=\"fas fa-fw fa-ticket-alt\"></i>\n");
      out.write("          <span>Quản lý vé</span></a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"pagesDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          <i class=\"fas fa-fw fa-user-alt\"></i>\n");
      out.write("          <span>Cá nhân</span>\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"pagesDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Thông tin cá nhân</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Đổi mật khẩu</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"login.html\">Đăng xuất</a>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write(" \n");
      out.write("    <!-- /.content-wrapper -->\n");
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
