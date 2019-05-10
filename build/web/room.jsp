<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="model.RoomUser"%>
<%@page import="java.util.List"%>
<%@page import="service.RoomService"%>
<%@page import="pojos.Room"%>
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
            List<RoomUser> mList = RoomService.getInstance().findAll();
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
                        <li class="breadcrumb-item">Danh sách phòng</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center">
                            <i class="fas fa-table"></i>
                            Danh sách phòng chiếu
                            <a href="add-room" class="btn btn-primary"  style="margin-left: auto">Thêm phòng chiếu</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tên phòng</th>
                                            <th>Hàng</th>
                                            <th>Cột</th>
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
                                                for (RoomUser r : mList) {

                                        %>
                                        <tr>
                                            <td><%=r.getNameRoom()%></td>
                                            <td><%=r.getNumRow()%></td>
                                            <td><%=r.getNumCol()%></td>
                                            <td><%=r.getCreateBy()%></td>
                                            <td><%=r.getTimeCreate()%></td>
                                            <td><%=r.getUpdateBy()%></td>
                                            <td><%=r.getTimeUpdate()%></td>
                                            <td class="text-center">
                                                <a title="Chi tiết" href="room-detail?id=<%=r.getIdRoom()%>" class="mr10 btn btn-info"><i data-v-1f4de138="" class="fas fa-info-circle"></i></a>
                                                <a title="Sửa phòng" href="edit-movie?id=1" class="mr10 btn btn-success"><i class="fas fa-edit"></i></a>
                                                <a title="Xóa phòng" href="RoomController?action=del&id=<%=r.getIdRoom()%> " class="mr10 btn btn-danger"><i class="fas fa-trash"></i></a>
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
            let mess = GetURLParameter("mess");
            switch (mess) {
                case 'success':
                    swal("Thông báo", "Xóa thành công", "success")
                            .then((value) => {
                                if (value) {
                                    window.location.replace("room");
                                }
                            });
                    break;
                case 'fail':
                    swal("Thông báo", "Xóa thất bại").then((value) => {
                        if (value) {
                            window.location.replace("room");
                        }
                    });
                    break;
                case 'havetime':
                    swal("Thông báo", "Bạn không thể xóa phòng này lúc này").then((value) => {
                        if (value) {
                            window.location.replace("room");
                        }
                    });
                    break;
            }
        </script>
    </body>
</html>
