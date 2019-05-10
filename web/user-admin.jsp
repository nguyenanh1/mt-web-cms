<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="java.util.Date"%>
<%@page import="util.CommonUtils"%>
<%@page import="service.UserService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserAdminMapping"%>
<%@page import="java.util.List"%>
<%@page import="util.CustomToken"%>
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
            int role;
            CustomToken mToken;
            if (session.getAttribute(CodeDefine.TOKEN) != null) {
                String token = session.getAttribute(CodeDefine.TOKEN).toString();
                mToken = new CustomToken(token);
                role = mToken.getRole();
            } else {
                role = -1;
            }
            List<UserAdminMapping> mList = UserService.getInstance().getAll();
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
                        <li class="breadcrumb-item active">Quản lý người dùng</li>

                    </ol>
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center" >
                            <i class="fas fa-table"></i>
                            Danh sách người dùng CMS

                            <a href="add-user-admin" class="btn btn-primary <%=(role == 3 ? "disabled" : "")%>" style="margin-left: auto">Thêm người dùng</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tên tài khoản</th>
                                            <th>Họ</th>
                                            <th>Tên</th>
                                            <th>Quyền</th>
                                            <th>Đăng nhập lần cuối</th>
                                            <th>Người thêm</th>
                                            <th>Ngày thêm</th>
                                            <th>Người sửa</th>
                                            <th>Ngày sửa</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            if (mList != null) {
                                                for (UserAdminMapping item : mList) {
                                        %>
                                        <tr>
                                            <td><%=item.getUsername()%></td>
                                            <td><%=item.getName()%></td>
                                            <td><%=item.getLastName()%></td>
                                            <td><%=item.getRole()%></td>
                                            <td><%=item.getLastLogin()%></td>
                                            <td><%=item.getCreatBy()%></td>
                                            <td><%=item.getCreateTime()%></td>
                                            <td><%=item.getUpdateBy()%></td>
                                            <td><%=item.getUpdateTime()%></td>
                                            <td class="text-center">
                                                <%
                                                    if (item.getId() != 1) {
                                                %>
                                                <a title="Xóa người dùng" href="UserAdminController?action=del&id=<%=item.getId()%>" class="mr10 btn btn-danger <%=(role == 3 ? "disabled" : "")%>">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                                <%
                                                    }
                                                %>
                                            </td>
                                        </tr>
                                        <%                                                }
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
