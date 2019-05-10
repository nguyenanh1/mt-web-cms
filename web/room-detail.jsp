<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="pojos.ZoomDetail"%>
<%@page import="java.util.List"%>
<%@page import="service.RoomService"%>
<%@page import="pojos.Room"%>
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
                    <%
                        int idRoom;
                        if (request.getParameter("id") == null) {
                            idRoom = -1;
                        } else {
                            try {
                                idRoom = Integer.parseInt(request.getParameter("id"));
                            } catch (Exception e) {
                                idRoom = -1;
                            }
                        }
                        Room room = RoomService.getInstance().getRoomById(idRoom);
                        List<ZoomDetail> details = RoomService.getInstance().findAllZoomDetailFindByIdRoom(room.getIdRoom());
                    %>

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item active">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item active">
                            <a href="room">Danh sách phòng</a>
                        </li>
                        <li class="breadcrumb-item">
                            <%= (room == null ? "404 Not Found" : room.getNameRoom())%>
                        </li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-tv"></i>
                            Thông tin phòng</div>
                        <div class="card-body">
                            <% if (room == null) { %>
                            <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>
                            <% } else {%>
                            <div class="row">
                                <div class="col-12">Tên phòng:&nbsp;&nbsp;<span><%=(room.getNameRoom() == null ? "" : room.getNameRoom())%></span></div>
                            </div>
                            <div class="row" style="margin-top: 10px">
                                <div class="col-12">Số hàng:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><%=(room.getNumRow() == null ? "" : room.getNumRow())%></span></div>
                            </div>
                            <div class="row" style="margin-top: 10px">
                                <div class="col-12">Số cột:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><%=(room.getNumCol() == null ? "" : room.getNumCol())%></span></div>
                            </div>

                            <%}%>
                        </div>
                    </div>
                    <% if (room != null && details != null) {%>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-couch"></i>
                            Thông tin chi tiết ghế</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Vị trí</th>
                                            <th>Hàng</th>
                                            <th>Cột</th>
                                            <th>Loại ghế</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <%

                                            for (ZoomDetail r : details) {

                                        %>
                                        <tr>
                                    <form action="RoomController?action=editdetail&id=<%=r.getId()%>" method="post">
                                        <td><%=r.getPostion()%></td>
                                        <td><%=r.getRow()%></td>
                                        <td><%=r.getCol()%></td>
                                        <td>
                                            <select class="form-control" name="type" id="exampleFormControlSelect1">
                                                <option <%=(r.getType() == 1 ? "selected" : "")%> value="1">Ghế Thường</option>
                                                <option <%=(r.getType() == 2 ? "selected" : "")%> value="2">Ghế Vip</option>
                                            </select>
                                        </td>
                                        <td class="text-center"><button class="btn btn-outline-primary"><i class="fas fa-save"></i></button></td>
                                    </form>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                    <%
                        }
                    %>
                    <jsp:include page="footer.jsp"/>
                </div>
            </div> 
            <jsp:include page="scrolltotop.jsp"/>
            <jsp:include page="logout.jsp"/>
            <jsp:include page="javascript.jsp"/>
    </body>
</html>
