<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="util.CustomToken"%>
<%@page import="service.CategoryService"%>
<%@page import="pojos.Category"%>
<%@page import="java.util.List"%>
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
        <<title>VENUS - CMS</title>
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
        %>
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
                        <li class="breadcrumb-item active">Thêm danh mục</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-plus-square"></i>
                            Nhập thông tin danh mục mới</div>
                        <div class="card-body">
                            <%
                                if (role != 3) {
                            %>
                            <form action="CategoryController?action=add" method="post">
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="name" id="inputEmail" class="form-control" placeholder="Tên danh mục" required="required" autofocus="autofocus">
                                            <label for="inputEmail">Tên danh mục</label>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-primary" type="submit">Thêm</button>
                                <a class="btn btn-danger" href="javascript:history.back()" style="margin-left: 10px">Hủy</a>
                            </form>
                            <%
                            } else {
                            %>
                            <div class="alert alert-danger" role="alert">
                                Tài khoản của bạn không có quyền này. Trở về trang <a href="category" class="alert-link">Danh sách danh mục</a>
                            </div>
                            <%
                                }
                            %>
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
            let alert = GetURLParameter("alert");
            if (alert === "sucsses") {
                swal("Thông báo", "Thêm thành công", "success");
            }
            if (alert === "fail") {
                swal("Thông báo", "Thêm thất bại");
            }
        </script>
    </body>
</html>
