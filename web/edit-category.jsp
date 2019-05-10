<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="util.CustomToken"%>
<%@page import="service.CategoryService"%>
<%@page import="pojos.Category"%>
<%@page import="model.CategoryUser"%>
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
        %>
        <jsp:include page="header-top.jsp"/>
        <div id="wrapper">
            <jsp:include page="menu.jsp"/>
            <div id="content-wrapper">
                <div class="container-fluid">
                    <!-- Breadcrumbs-->
                    <%
                        String requestID = request.getParameter("id");
                        int id = -1;
                        try {
                            id = Integer.parseInt(requestID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Category category = CategoryService.getInstance().findById(id);
                    %>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item">
                            <a href="category">Danh mục phim</a>
                        </li>
                        <%
                            if (category == null) {
                        %>
                        <li class="breadcrumb-item active">404 Not found</li>
                            <%
                            } else {
                            %>
                        <li class="breadcrumb-item active"><%=category.getName()%></li>
                            <%
                                }
                            %>

                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-plus-square"></i>
                            Chỉnh sửa thông tin danh mục</div>
                        <div class="card-body">
                            <%
                                if (category == null) {
                            %>
                            <p>404 NOT FOUND! Không tìm thấy dữ liệu.</p>
                            <%
                            } else {
                                if (role != 3) {
                            %>
                            <form action="CategoryController?action=update&id=<%=id%>" method="post">
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="name" id="inputEmail" value="<%=category.getName()%>" class="form-control" placeholder="Tên danh mục" required="required">
                                            <label for="inputEmail">Tên danh mục</label>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-primary" type="submit">Sửa</button>
                                <a class="btn btn-danger" href="category" style="margin-left: 10px">Danh mục phim</a>
                            </form>
                            <%
                            } else {
                            %>
                            <div class="alert alert-danger" role="alert">
                                Tài khoản của bạn không có quyền này. Trở về trang <a href="category" class="alert-link">Danh sách danh mục</a>
                            </div>
                            <%                                     }
                                }
                            %>
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
                    swal("Thông báo", "Sửa thành công", "success")
                            .then((value) => {
                                if (value) {
                                    window.location.replace("category");
                                }
                            });
                }
                if (alert === "fail") {
                    swal("Thông báo", "Sửa thất bại");
                }
            </script>
    </body>
</html>
