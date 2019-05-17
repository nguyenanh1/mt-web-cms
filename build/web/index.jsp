<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

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
        <jsp:include page="header-top.jsp"/>
        <div id="wrapper">
            <jsp:include page="menu.jsp"/>
            <div id="content-wrapper">
                <div class="container-fluid">
                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <!--                        <li class="breadcrumb-item active">
                                                    <a href="home">Trang chủ</a>
                                                </li>-->
                        <li class="breadcrumb-item active">Trang chủ</li>
                    </ol>
                    <div class="row">
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-primary o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-film"></i>
                                    </div>
                                    <div class="mr-5"> <%=MovieService.getInstance().getSize()%> Phim đang chiếu</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="movie">
                                    <span class="float-left">Xem chi tiết</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-warning o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-tv"></i>
                                    </div>
                                    <div class="mr-5"><%=RoomService.getInstance().numRoom()%> Phòng chiếu</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="room">
                                    <span class="float-left">Xem chi tiết</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-success o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-user-friends"></i>
                                    </div>
                                    <div class="mr-5"><%=UserService.getInstance().numUserAdmin()%> Người dùng CMS</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="user-admin">
                                    <span class="float-left">Xem chi tiết</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6 mb-3">
                            <div class="card text-white bg-danger o-hidden h-100">
                                <div class="card-body">
                                    <div class="card-body-icon">
                                        <i class="fas fa-fw fa-mobile"></i>
                                    </div>
                                    <div class="mr-5"><%=UserMobileService.getInstance().numUserMobile() %> Người dùng Mobile</div>
                                </div>
                                <a class="card-footer text-white clearfix small z-1" href="user-mobile">
                                    <span class="float-left">Xem chi tiết</span>
                                    <span class="float-right">
                                        <i class="fas fa-angle-right"></i>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-chart-area"></i>
                            Thống kê lượng vé bán</div>
                        <div class="card-body">
                            <canvas id="myAreaChart" width="100%" height="30"></canvas>
                        </div>
                        <div class="card-footer small text-muted"> 
                            <%=("Dữ liệu lấy lúc " +CommonUtils.formatDate(new Date()))%>
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
