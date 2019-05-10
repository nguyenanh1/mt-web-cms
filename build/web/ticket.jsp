<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="pojos.Movietime"%>
<%@page import="service.MovieTimeService"%>
<%@page import="pojos.Ticket"%>
<%@page import="pojos.Movie"%>
<%@page import="java.util.List"%>
<%@page import="pojos.Room"%>
<%@page import="service.UserMobileService"%>
<%@page import="service.UserService"%>
<%@page import="service.RoomService"%>
<%@page import="service.MovieService"%>
<%@page import="util.CommonUtils"%>
<%@page import="java.util.Date"%>
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
            String date = "";
            int idMovie = -1;
            if (request.getParameter("date") != null) {
                date = request.getParameter("date");
            }
            if (request.getParameter("movie") != null) {
                idMovie = CommonUtils.parseInteger(request.getParameter("movie"));
            }
            List<Movietime> mMovietimes = null;
            if (!date.equals("")) {
                mMovietimes = MovieTimeService.getIntance().getListByMovieAndDate(CommonUtils.converPartDate(date), idMovie);
            }
        %>

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
                        <li class="breadcrumb-item active">Quản lý vé</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            Chọn thông tin xem lịch chiếu</div>
                        <div class="card-body">
                            <form>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-md-7 col-lg-4">
                                        <label for="exampleFormControlInput1">Ngày chiếu</label>
                                        <input type="date" name="date" value="<%=date%>" class="form-control" required="" id="inputDate" placeholder="">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12 col-md-7 col-lg-4">
                                        <%
                                            List<Movie> movies = MovieService.getInstance().getListMovieIsShowing();
                                        %>
                                        <label for="exampleFormControlSelect1">Phim</label>
                                        <select name="movie" class="form-control" id="exampleFormControlSelect1">
                                            <%
                                                for (Movie m : movies) {
                                            %>
                                            <option <%=(idMovie == m.getId() ? "selected" : "")%> value="<%=m.getId()%>"><%=m.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <button class="btn btn-primary" type="submit">Xem</button>

                            </form>

                        </div>
                    </div>
                    <%
                        if (mMovietimes != null) {
                    %>
                    <div class="card mb-3">
                        <div class="card-header">
                            Danh sách vé</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Phim</th>
                                            <th>Phòng</th>
                                            <th>Giá vé gốc (VND)</th>
                                            <th>Giờ chiếu</th>
                                            <th>Ngày chiếu</th>

                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (Movietime m : mMovietimes) {
                                        %>
                                        <tr>
                                            <td><%=m.getIdMovie()%></td>
                                            <td><%=m.getIdRoom()%></td>
                                            <td><%=CommonUtils.decimalFormat(m.getPrice())%></td>
                                            <td><%=CommonUtils.converTime(m.getTimeStart())%></td>
                                            <td><%=CommonUtils.convertDate(m.getDateStart())%></td>
                                            <td class="text-center">
                                                <a title="xem danh sách vé" href="ticket-detail?id=<%=m.getId()%>" class="mr10 btn btn-info"><i class="fas fa-info-circle"></i></a>
                                            </td>
                                        </tr>
                                        <%

                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <div class="card-footer small text-muted"> 
                            <%=("Dữ liệu lấy lúc " + CommonUtils.formatDate(new Date()))%>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
                <jsp:include page="footer.jsp"/>
            </div>
        </div> 
        <jsp:include page="scrolltotop.jsp"/>
        <jsp:include page="logout.jsp"/>
        <jsp:include page="javascript.jsp"/>
        <script>
            $(document).ready(function () {
                let now = new Date();
                // var tomorrow = new Date(now.getTime() + (24 * 60 * 60 * 1000));
                let year = now.getFullYear();
                let day = now.getDate();
                let month = now.getMonth() + 1;
                if (day < 10) {
                    day = '0' + day;
                }
                if (month < 10) {
                    month = '0' + month;
                }
                var today = year + '-' + month + '-' + day;
                let dateParam = GetURLParameter("date");
                console.log(dateParam);
                if (!dateParam) {
                    $('#inputDate').val(today);
                }


                var max = new Date(now.getTime() + (14 * 24 * 60 * 60 * 1000));
                year = max.getFullYear();
                day = max.getDate();
                month = max.getMonth() + 1;
                if (day < 10) {
                    day = '0' + day;
                }
                if (month < 10) {
                    month = '0' + month;
                }
                var maxS = year + '-' + month + '-' + day;
                $('#inputDate').attr('max', maxS);
                $('#inputDate').attr('title', 'Bạn chỉ có thể tạo lịch chiếu trong khoảng từ ' + today + ' đến ' + maxS);
            });

    //            let mess = GetURLParameter("message");
    //            switch (mess) {
    //                case "success":
    //                    swal("Thông báo", "Thêm thành công", "success");
    //                    break;
    //                case "fail":
    //                    swal("Thông báo", "Có lỗi trong quá trình tạo vé");
    //                    break;
    //                case "ZOOMNOTUSE":
    //                    swal("Thông báo", "Phòng không tồn tại");
    //                    break;
    //                case "MOVIETIMEEXIXTS":
    //                    swal("Thông báo", "Phòng này đã được sử dụng vào thời điểm bạn tạo");
    //                    break;
    //                case "ZOOMNOTEXIST":
    //                    swal("Thông báo", "Phòng không tồn tại");
    //                    break;
    //                case "MOVIENOTEXIST":
    //                    swal("Thông báo", "Phim này không tồn tại");
    //                    break;
    //            }
        </script>
    </body>
</html>
