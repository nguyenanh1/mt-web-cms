<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="util.CommonUtils"%>
<%@page import="service.UserMobileService"%>
<%@page import="pojos.User"%>
<%@page import="java.util.List"%>
<%@page import="common.CodeDefine"%>
<%@page import="java.util.Date" %>
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
                        <li class="breadcrumb-item active">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item">Người dùng Mobile</li>
                    </ol>
                    <%
                        List<User> mList = UserMobileService.getInstance().getAll();
                    %>
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center" >
                            <i class="fas fa-table"></i>
                            Người dùng Mobile
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Email</th>
                                            <th>Họ</th>
                                            <th>Tên</th>
                                            <th>Địa chỉ</th>
                                            <th>Điện thoại</th>
                                            <th>Chi tiêu</th>
                                            <th>Điểm</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            if (mList != null) {
                                                for (User u : mList) {
                                        %>
                                        <tr>
                                            <td><%=(u.getEmail() == null ? "" : u.getEmail())%></td>
                                            <td><%=(u.getLastname() == null ? "" : u.getLastname())%></td>
                                            <td><%=(u.getName() == null ? "" : u.getName())%></td>
                                            <td><%=(u.getAddresss() == null ? "" : u.getAddresss())%></td>
                                            <td><%=(u.getPhone() == null ? "" : u.getPhone())%></td>
                                            <td><%=(u.getBalace() == null ? "" : u.getBalace())%> </td>
                                            <td><%=(u.getPoint() == null ? "" : u.getPoint())%></td>
                                            <td class="text-center">
                                                <a href="#" title="Hủy kích hoạt" class="btn btn-warning"><i class="fas fa-lock "></i></a>
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
