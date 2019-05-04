<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="service.RoomService"%>
<%@page import="pojos.Room"%>
<%@page import="java.util.List"%>
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
        <title>CGV - CMS</title>
        <jsp:include page="css.jsp"/>
    </head>
    <body id="page-top">
        <jsp:include page="header-top.jsp"/>
        <div id="wrapper">
            <jsp:include page="menu.jsp"/>
            <div id="content-wrapper">
                <div class="container-fluid">
                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item active">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item">Thêm lịch chiếu</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-plus-square"></i>
                            Thêm lịch chiếu
                        </div>
                        <div class="card-body">
                            <form action="MovieTimeController?action=add" method="post">
                                <div class="row">
                                    <div class="form-group col-sm-12 col-md-12 col-lg-6">
                                        <%
                                            List<Movie> mListIsShowing = MovieService.getInstance().getListMovieIsShowing();
                                        %>
                                        <label for="exampleFormControlSelect1">Chọn phim</label>
                                        <select name="movie" class="form-control" id="exampleFormControlSelect1">
                                            <%
                                                for (Movie m : mListIsShowing) {
                                            %>
                                            <option value="<%=m.getId()%>"><%=m.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12 col-md-5 col-lg-2">
                                        <label for="exampleFormControlInput1">Giờ chiếu</label>
                                        <input type="time" name="time" class="form-control" required="" id="exampleFormControlInput1" placeholder="">
                                    </div>
                                    <div class="form-group col-sm-12 col-md-7 col-lg-4">
                                        <label for="exampleFormControlInput1">Ngày chiếu</label>
                                        <input type="date" name="date" class="form-control" required="" id="exampleFormControlInput1" placeholder="">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12 col-md-12 col-lg-6">
                                        <%
                                            List<Room> mRooms = RoomService.getInstance().getAll();
                                        %>
                                        <label for="exampleFormControlSelect1">Phòng chiếu</label>
                                        <select name="room" class="form-control" id="exampleFormControlSelect1">
                                            <%
                                                for (Room r : mRooms) {
                                            %>
                                            <option value="<%=r.getIdRoom()%>"><%=r.getNameRoom()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12 col-md-12 col-lg-6">
                                        <label for="exampleFormControlInput1">Giá vé</label>
                                        <input type="number" name="time" class="form-control" min="1000" required="" title="Giá vé phải lớn hơn 1000" id="exampleFormControlInput1" placeholder="(VND)">
                                    </div>
                                </div>
                                <button class="btn btn-primary" type="submit">Thêm</button>
                                <a class="btn btn-danger" href="javascript:history.back()" style="margin-left: 10px">Hủy</a>
                            </form>
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
