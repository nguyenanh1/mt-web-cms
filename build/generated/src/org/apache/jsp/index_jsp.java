package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import service.UserMobileService;
import service.UserService;
import service.RoomService;
import service.MovieService;
import util.CommonUtils;
import java.util.Date;
import common.CodeDefine;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>VENUS - CMS</title>\n");
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
      out.write("                        <!--                        <li class=\"breadcrumb-item active\">\n");
      out.write("                                                    <a href=\"home\">Trang chủ</a>\n");
      out.write("                                                </li>-->\n");
      out.write("                        <li class=\"breadcrumb-item active\">Trang chủ</li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 mb-3\">\n");
      out.write("                            <div class=\"card text-white bg-primary o-hidden h-100\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card-body-icon\">\n");
      out.write("                                        <i class=\"fas fa-fw fa-film\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mr-5\"> ");
      out.print(MovieService.getInstance().getSize());
      out.write(" Phim đang chiếu</div>\n");
      out.write("                                </div>\n");
      out.write("                                <a class=\"card-footer text-white clearfix small z-1\" href=\"movie\">\n");
      out.write("                                    <span class=\"float-left\">Xem chi tiết</span>\n");
      out.write("                                    <span class=\"float-right\">\n");
      out.write("                                        <i class=\"fas fa-angle-right\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 mb-3\">\n");
      out.write("                            <div class=\"card text-white bg-warning o-hidden h-100\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card-body-icon\">\n");
      out.write("                                        <i class=\"fas fa-fw fa-tv\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mr-5\">");
      out.print(RoomService.getInstance().numRoom());
      out.write(" Phòng chiếu</div>\n");
      out.write("                                </div>\n");
      out.write("                                <a class=\"card-footer text-white clearfix small z-1\" href=\"room\">\n");
      out.write("                                    <span class=\"float-left\">Xem chi tiết</span>\n");
      out.write("                                    <span class=\"float-right\">\n");
      out.write("                                        <i class=\"fas fa-angle-right\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 mb-3\">\n");
      out.write("                            <div class=\"card text-white bg-success o-hidden h-100\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card-body-icon\">\n");
      out.write("                                        <i class=\"fas fa-fw fa-user-friends\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mr-5\">");
      out.print(UserService.getInstance().numUserAdmin());
      out.write(" Người dùng CMS</div>\n");
      out.write("                                </div>\n");
      out.write("                                <a class=\"card-footer text-white clearfix small z-1\" href=\"user-admin\">\n");
      out.write("                                    <span class=\"float-left\">Xem chi tiết</span>\n");
      out.write("                                    <span class=\"float-right\">\n");
      out.write("                                        <i class=\"fas fa-angle-right\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-sm-6 mb-3\">\n");
      out.write("                            <div class=\"card text-white bg-danger o-hidden h-100\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"card-body-icon\">\n");
      out.write("                                        <i class=\"fas fa-fw fa-mobile\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mr-5\">");
      out.print(UserMobileService.getInstance().numUserMobile() );
      out.write(" Người dùng Mobile</div>\n");
      out.write("                                </div>\n");
      out.write("                                <a class=\"card-footer text-white clearfix small z-1\" href=\"user-mobile\">\n");
      out.write("                                    <span class=\"float-left\">Xem chi tiết</span>\n");
      out.write("                                    <span class=\"float-right\">\n");
      out.write("                                        <i class=\"fas fa-angle-right\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <i class=\"fas fa-chart-area\"></i>\n");
      out.write("                            Thống kê doanh thu</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <canvas id=\"myAreaChart\" width=\"100%\" height=\"30\"></canvas>\n");
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
