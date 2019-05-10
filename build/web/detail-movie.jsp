<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="util.CustomToken"%>
<%@page import="daoimpl.UserAdminDAO"%>
<%@page import="util.CommonUtils"%>
<%@page import="service.MovieService"%>
<%@page import="pojos.Movie"%>
<%@page import="common.CodeDefine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="logo.jsp"/>
        <title>VENUS - CMS</title>
        <jsp:include page="css.jsp"/>
    </head>
    <body id="page-top">
        <%
            Movie movie = null;
            Integer idMovie = -1;
            if (request.getParameter("id") != null) {
                idMovie = Integer.parseInt(request.getParameter("id"));
            }
            if (idMovie != -1) {
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
        %> 
        <jsp:include page="header-top.jsp"/>
        <div id="wrapper">
            <jsp:include page="menu.jsp"/>
            <div id="content-wrapper">
                <div class="container-fluid">
                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item">
                            <a href="movie">Danh sách phim</a>
                        </li>
                        <li class="breadcrumb-item active"><%=(movie == null ? "404 NOT FOUND" : movie.getName())%></li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center">
                            <i class="fas fa-fw fa-film"></i>
                            Chi tiết phim
                            <a href="edit-movie?id=<%=idMovie %>" class="btn btn-primary <%=(role == 3 ? "disabled" : "")%>"  style="margin-left: auto">Sửa thông tin</a>
                        </div>
                        <div class="card-body">
                            <% if (movie == null) { %>
                            <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>
                            <% } else {%>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Mã phim:&nbsp;&nbsp;</span><span><%=movie.getId()%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Tên phim:&nbsp;&nbsp;</span><span><%=(movie.getName() == null ? "" : movie.getName())%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Khởi chiếu:&nbsp;&nbsp;</span><span><%=(movie.getPartTime() == null ? "" : CommonUtils.convertDate(movie.getPartTime()))%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Thời lượng:&nbsp;&nbsp;</span><span><%=(movie.getTime() == null ? "" : movie.getTime() + " Phút")%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Đạo diễn:&nbsp;&nbsp;</span><span><%=(movie.getDirector() == null ? "" : movie.getDirector())%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Độ tuổi:&nbsp;&nbsp;</span><span><%=(movie.getOld() == null ? "" : movie.getOld())%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Lượt xem:&nbsp;&nbsp;</span><span><%=(movie.getView() == null ? "" : movie.getView())%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Thumb(160x237):</span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><img src="<%=(movie.getThumb() == null ? "" : CommonUtils.ip + movie.getThumb())%>" width="160" height="237" /></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Ảnh (175x260):</span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><image src="<%=(movie.getImageUrl() == null ? "" : CommonUtils.ip + movie.getImageUrl())%>" width="175" height="260"></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Nội dung:</span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><%=movie.getContain()%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Trailer:</span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><iframe  src="//www.youtube.com/embed/<%=movie.getTrailer()%>?rel=0&showinfo=0" allowfullscreen></iframe></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Người tạo:&nbsp;&nbsp;</span><span><%=(movie.getTime() == null ? "" : UserAdminDAO.getInsance().findById(movie.getCreateBy()).getDisplayName())%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Thời gian tạo:&nbsp;&nbsp;</span><span><%=(movie.getDirector() == null ? "" : CommonUtils.formatDate(movie.getTimeUpdate()))%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Người sửa gần đây nhất:&nbsp;&nbsp;</span><span><%=(movie.getOld() == null ? "" : UserAdminDAO.getInsance().findById(movie.getUpdateBy()).getDisplayName())%></span></div>
                            </div>
                            <div class="row">
                                <div class="col-12"><span style="font-weight: bold">Thời gian gần đây nhất:&nbsp;&nbsp;</span><span><%=(movie.getView() == null ? "" : CommonUtils.formatDate(movie.getTimeUpdate()))%></span></div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
                <jsp:include page="footer.jsp"/>
            </div>
        </div> 
        <jsp:include page="scrolltotop.jsp"/>
        <jsp:include page="logout.jsp"/>
        <jsp:include page="javascript.jsp"/>
    </body>
</html>
