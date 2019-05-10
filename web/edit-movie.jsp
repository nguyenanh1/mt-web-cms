<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="service.CategoryService"%>
<%@page import="pojos.Category"%>
<%@page import="pojos.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="util.CommonUtils"%>
<%@page import="util.CustomToken"%>
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
                        <div class="card-header">
                            <i class="fas fa-edit"></i>
                            Sửa thông tin phim</div>
                        <div class="card-body">
                            <%
                                if (role == 3) {
                            %>
                            <div class="alert alert-danger" role="alert">
                                Tài khoản của bạn không có quyền này. Trở về trang <a href="movie" class="alert-link">danh sách phim</a>
                            </div>
                            <%
                            } else {
                                if (movie == null) {
                            %>
                            <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>
                            <%
                            } else {
                                List<Category> mListCate = CategoryService.getInstance().getAllCate();

                            %>
                            <form>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Tên tài khoản" required="required" value="<%=movie.getName()%>">
                                            <label for="inputEmail">Tên Phim</label>
                                        </div>

                                    </div>
                                    <div class="form-group col-sm-12 col-lg-2 col-md-5">
                                        <select class="form-control" id="exampleFormControlSelect1">
                                            <option value="">Độ tuổi</option>
                                            <option <%=(movie.getOld()==0? "selected":"") %> value="0">0</option>
                                            <option <%=(movie.getOld()==13? "selected":"") %> value="13">13</option>
                                            <option <%=(movie.getOld()==15? "selected":"") %> value="15">15</option>
                                            <option <%=(movie.getOld()==18? "selected":"") %> value="18">18</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="date" name="username" id="inputDate" class="form-control" placeholder="Ngày khởi chiếu" required="required" >
                                            <label for="inputDate">Ngày khởi chiếu</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12 col-lg-2 col-md-5">
                                        <div class="form-label-group">
                                            <input type="number" name="time" id="inputTime" value="<%=movie.getTime( )%>" class="form-control" placeholder="Thời lượng (Phút)" required="required">
                                            <label for="inputTime">Thời lượng</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-sm-12 col-lg-7 col-md-5">
                                        <select class="form-control" name="cate" id="exampleFormControlSelect1" required multiple="multiple">
                                            <% for (Category cate : mListCate) {%>
                                            <option value="<%=cate.getId()%>"><%=cate.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="director" id="inputDirector" class="form-control" value="<%=movie.getDirector()%>" placeholder="Đạo diễn">
                                            <label for="inputDirector">Đạo diễn</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="actor" id="inputActor" class="form-control" value="<%=movie.getActor()%>" placeholder="Diễn viên">
                                            <label for="inputActor">Diễn viên</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="trailer" value="<%=movie.getTrailer()%>" id="inputTrailer" class="form-control" placeholder="Trailer">
                                            <label for="inputTrailer">Trailer</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="file" name="thumb"  id="inputThumb" class="form-control" placeholder="Thumb">
                                            <label for="inputThumb">Thumb</label>
                                            <img src="<%=(CommonUtils.ip+movie.getThumb())%>" width="160px" height="237px"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="file" name="image" src="<%=(CommonUtils.ip+movie.getThumb())%>" id="inputImage" class="form-control" placeholder="Ảnh">
                                            <label for="inputImage">Ảnh</label>
                                            <img src="<%=(CommonUtils.ip+movie.getThumb())%>" width="175px" height="260px"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputContent">Nội dung</label>
                                    <textarea class="form-control" name="contain" id="inputContent" rows="5" id="comment"><%=movie.getContain() %></textarea>
                                </div>
                                <button class="btn btn-primary" type="submit">Đăng nhập</button>
                                <button class="btn btn-danger" style="margin-left: 10px">Hủy</button>
                        </div>
                        <%}
                            }%>
                        </form>
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
