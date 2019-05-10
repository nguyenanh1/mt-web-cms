package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import service.CategoryService;
import pojos.Category;
import pojos.Category;
import java.util.List;
import java.util.List;
import util.CommonUtils;
import util.CustomToken;
import service.MovieService;
import pojos.Movie;
import common.CodeDefine;

public final class edit_002dmovie_jsp extends org.apache.jasper.runtime.HttpJspBase
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

            Movie movie = null;
            Integer idMovie = null;
            if (request.getParameter("id") != null) {
                idMovie = CommonUtils.parseInteger(request.getParameter("id"));
            }
            if (idMovie != null) {
                movie = MovieService.getInstance().findMovieById(idMovie);
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
        
      out.write(" \n");
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
      out.write("                        <li class=\"breadcrumb-item\">\n");
      out.write("                            <a href=\"movie\">Danh sách phim</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"breadcrumb-item active\">");
      out.print((movie == null ? "404 NOT FOUND" : movie.getName()));
      out.write("</li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <i class=\"fas fa-edit\"></i>\n");
      out.write("                            Sửa thông tin phim</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            ");

                                if (role == 3) {
                            
      out.write("\n");
      out.write("                            <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                                Tài khoản của bạn không có quyền này. Trở về trang <a href=\"movie\" class=\"alert-link\">danh sách phim</a>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                            } else {
                                if (movie == null) {
                            
      out.write("\n");
      out.write("                            <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>\n");
      out.write("                            ");

                            } else {
                                List<Category> mListCate = CategoryService.getInstance().getAllCate();

                            
      out.write("\n");
      out.write("                            <form>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-5 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"username\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Tên tài khoản\" required=\"required\" value=\"");
      out.print(movie.getName());
      out.write("\">\n");
      out.write("                                            <label for=\"inputEmail\">Tên Phim</label>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-2 col-md-5\">\n");
      out.write("                                        <select class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option value=\"\">Độ tuổi</option>\n");
      out.write("                                            <option ");
      out.print((movie.getOld()==0? "selected":"") );
      out.write(" value=\"0\">0</option>\n");
      out.write("                                            <option ");
      out.print((movie.getOld()==13? "selected":"") );
      out.write(" value=\"13\">13</option>\n");
      out.write("                                            <option ");
      out.print((movie.getOld()==15? "selected":"") );
      out.write(" value=\"15\">15</option>\n");
      out.write("                                            <option ");
      out.print((movie.getOld()==18? "selected":"") );
      out.write(" value=\"18\">18</option>\n");
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
      out.write("                                            <input type=\"number\" name=\"time\" id=\"inputTime\" value=\"");
      out.print(movie.getTime( ));
      out.write("\" class=\"form-control\" placeholder=\"Thời lượng (Phút)\" required=\"required\">\n");
      out.write("                                            <label for=\"inputTime\">Thời lượng</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row form-group\">\n");
      out.write("                                    <div class=\"col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <select class=\"form-control\" name=\"cate\" id=\"exampleFormControlSelect1\" required multiple=\"multiple\">\n");
      out.write("                                            ");
 for (Category cate : mListCate) {
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(cate.getId());
      out.write('"');
      out.write('>');
      out.print(cate.getName());
      out.write("</option>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"director\" id=\"inputDirector\" class=\"form-control\" value=\"");
      out.print(movie.getDirector());
      out.write("\" placeholder=\"Đạo diễn\">\n");
      out.write("                                            <label for=\"inputDirector\">Đạo diễn</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"actor\" id=\"inputActor\" class=\"form-control\" value=\"");
      out.print(movie.getActor());
      out.write("\" placeholder=\"Diễn viên\">\n");
      out.write("                                            <label for=\"inputActor\">Diễn viên</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"text\" name=\"trailer\" value=\"");
      out.print(movie.getTrailer());
      out.write("\" id=\"inputTrailer\" class=\"form-control\" placeholder=\"Trailer\">\n");
      out.write("                                            <label for=\"inputTrailer\">Trailer</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"file\" name=\"thumb\"  id=\"inputThumb\" class=\"form-control\" placeholder=\"Thumb\">\n");
      out.write("                                            <label for=\"inputThumb\">Thumb</label>\n");
      out.write("                                            <img src=\"");
      out.print((CommonUtils.ip+movie.getThumb()));
      out.write("\" width=\"160px\" height=\"237px\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"form-group col-sm-12 col-lg-7 col-md-5\">\n");
      out.write("                                        <div class=\"form-label-group\">\n");
      out.write("                                            <input type=\"file\" name=\"image\" src=\"");
      out.print((CommonUtils.ip+movie.getThumb()));
      out.write("\" id=\"inputImage\" class=\"form-control\" placeholder=\"Ảnh\">\n");
      out.write("                                            <label for=\"inputImage\">Ảnh</label>\n");
      out.write("                                            <img src=\"");
      out.print((CommonUtils.ip+movie.getThumb()));
      out.write("\" width=\"175px\" height=\"260px\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"inputContent\">Nội dung</label>\n");
      out.write("                                    <textarea class=\"form-control\" name=\"contain\" id=\"inputContent\" rows=\"5\" id=\"comment\">");
      out.print(movie.getContain() );
      out.write("</textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"btn btn-primary\" type=\"submit\">Đăng nhập</button>\n");
      out.write("                                <button class=\"btn btn-danger\" style=\"margin-left: 10px\">Hủy</button>\n");
      out.write("                        </div>\n");
      out.write("                        ");
}
                            }
      out.write("\n");
      out.write("                        </form>\n");
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
