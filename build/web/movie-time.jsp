<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="service.MovieTimeService"%>
<%@page import="model.MovieTimeMapping"%>
<%@page import="java.util.List"%>
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
                        <li class="breadcrumb-item ">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item active">Danh sách lịch chiếu</li>
                    </ol>
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center" >
                            <i class="fas fa-table"></i>
                            Danh sách lịch chiếu

                            <a href="add-time" class="btn btn-primary" style="margin-left: auto">Thêm lịch chiếu</a>
                        </div>
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
                                            <th>Người thêm</th>
                                            <th>Ngày thêm</th>
                                            <th>Người sửa</th>
                                            <th>Ngày sửa</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<MovieTimeMapping> mList = MovieTimeService.getIntance().getAll();
                                            if (mList != null) {
                                                for (MovieTimeMapping m : mList) {
                                        %>
                                        <tr>
                                            <td><%=m.getIdMovie()%></td>
                                            <td><%=m.getIdRoom()%></td>
                                            <td><%=m.getPrice()%></td>
                                            <td><%=m.getTimeStart()%></td>
                                            <td><%=m.getDateStart()%></td>
                                            <td><%=m.getCreateBy()%></td>
                                            <td><%=m.getTimeCreate()%></td>
                                            <td><%=m.getUpdateBy()%></td>
                                            <td><%=m.getTimeUpdate()%></td>
                                            <td>
                                                <a title="Sửa lịch chiếu"  href="edit-movie?id=1" class="mr10 btn btn-success"><i class="fas fa-edit"></i></a>
                                                <a title="Xóa lịch chiếu" href="#" class="mr10 btn btn-danger"><i class="fas fa-trash"></i></a>
                                            </td>
                                        </tr>
                                        <%
                                                }
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
                </div>
                <jsp:include page="footer.jsp"/>
            </div>
        </div> 
        <jsp:include page="scrolltotop.jsp"/>
        <jsp:include page="logout.jsp"/>
        <jsp:include page="javascript.jsp"/>
        <script>
            
            
        </script>
    </body>
</html>
