<%-- 
    Document   : movie-time
    Created on : May 9, 2019, 11:19:55 AM
    Author     : Asus
--%>

<%@page import="service.MovieTimeService"%>
<%@page import="model.MovieTimeMapping"%>
<%@page import="service.TicketService"%>
<%@page import="model.TicketMapping"%>
<%@page import="java.util.List"%>
<%@page import="util.CommonUtils"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
</head>
<body>
    <%
        Integer id = null;

        if (request.getParameter("id") != null) {
            id = CommonUtils.parseInteger(request.getParameter("id"));
        }
//        MovieTimeMapping
        MovieTimeMapping movieTimeMapping = null;
        if (id != null) {
            movieTimeMapping = MovieTimeService.getIntance().findById(id);
        }
        List<TicketMapping> mList = null;
        if (id != null) {
            mList = TicketService.getInstance().getListTicketByMovietTime(id);
        }
    %>

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
                    <li class="breadcrumb-item">
                        <a href="ticket">Quản lý vé</a>
                    </li>
                    <li class="breadcrumb-item active"><%=(movieTimeMapping == null ? "404 Not Found" : movieTimeMapping.getIdMovie() + " chiếu lúc " + movieTimeMapping.getTimeStart() + " " + movieTimeMapping.getDateStart())%></li>
                </ol>
                <!-- DataTables Example -->
                <div class="card mb-3">
                    <div class="card-header d-flex align-items-center" >
                        <i class="fas fa-table"></i>
                        Danh sách vé

                        <a href="add-time" class="btn btn-primary" style="margin-left: auto">Thêm lịch chiếu</a>
                    </div>
                    <div class="card-body">
                        <%
                            if (mList == null) {
                        %>
                        <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>
                        <%
                        } else {
                        %>
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Trạng thái</th>
                                        <th>Giá vé thực</th>
                                        <th>Vị trí</th>
                                        <th>Người thêm</th>
                                        <th>Ngày thêm</th>
                                        <th>Người sửa</th>
                                        <th>Ngày sửa</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (TicketMapping temp : mList) {
                                    %>
                                    <tr>
                                        <td><%=CommonUtils.getStatusTicket(temp.getStatus())%></td>
                                        <td><%=temp.getPrice()%></td>
                                        <td><%=temp.getPosition()%></td>
                                        <td><%=temp.getCreateBy()%></td>
                                        <td><%=temp.getTimeCreate()%></td>
                                        <td><%=temp.getUpdateBy()%></td>
                                        <td><%=temp.getTimeUpdate() %></td>
                                        <td>
                                            
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                        <%                            }
                        %>
                    </div>
                </div>
            </div>
            <div class="card-footer small text-muted"> 
                <%=("Dữ liệu lấy lúc " + CommonUtils.formatDate(new Date()))%>
            </div>
            <jsp:include page="footer.jsp"/>
        </div>
    </div> 
    <jsp:include page="scrolltotop.jsp"/>
    <jsp:include page="logout.jsp"/>
    <jsp:include page="javascript.jsp"/>
</body>
</html>
