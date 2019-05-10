<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

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
                        <li class="breadcrumb-item">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item active">Thêm phòng chiếu</li>
                    </ol>

                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-plus-square"></i>
                            Nhập thông tin phòng chiếu mới</div>
                        <div class="card-body">
                            <form action="RoomController?action=add" method="post">
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-6 col-md-12">
                                        <div class="form-label-group">
                                            <input type="text" name="name" id="inputNameRoom" class="form-control" placeholder="Tên tài khoản" required="required" autofocus="autofocus">
                                            <label for="inputNameRoom">Tên phòng</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-3 col-md-6">
                                        <div class="form-label-group">
                                            <input type="number" name="row" id="inputRow" min="2" class="form-control" placeholder="Hàng" required="required" >
                                            <label for="inputRow">Hàng</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12 col-lg-3 col-md-6">
                                        <div class="form-label-group">
                                            <input type="number" name="col" id="inputCol" min="2" class="form-control" placeholder="Cột" required="required" >
                                            <label for="inputCol">Cột</label>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <button class="btn btn-primary" type="submit">Thêm</button>
                                <a class="btn btn-danger" href="javascript:history.back()" style="margin-left: 10px">Hủy</a>
                        </div>

                        </form>
                    </div>
                    <div class="card-footer small text-muted"></div>
                </div>
            </div> 
        </div>
    </div> 
    <jsp:include page="scrolltotop.jsp"/>
    <jsp:include page="logout.jsp"/>
    <jsp:include page="javascript.jsp"/>
</body>
</html>
