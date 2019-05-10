<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

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
                        <li class="breadcrumb-item active">Thêm người dùng</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-plus-square"></i>
                            Nhập thông tin người dùng</div>
                        <div class="card-body">
                            <%
                                if (role != 3) {
                            %>
                            <form action="UserAdminController?action=add"  method="post">
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-6 col-md-12">
                                        <div class="form-label-group">
                                            <input type="text" pattern=".{6,15}" title="Tên tài khoản gồm 6-15 ký tự trở lên" name="username" id="inputUserNameNew" class="form-control" placeholder="Tên tài khoản" required="required" autofocus="autofocus">
                                            <label for="inputUserNameNew">Tên tài khoản</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-6 col-md-12">
                                        <div class="form-label-group">
                                            <input type="password" pattern=".{6,20}" title="Mật khẩu gồm 6-20 ký tự trở lên"  autocomplete="new-password" name="password" id="inputPasswordNew" class="form-control" placeholder="Mật khẩu" required="required" autofocus="autofocus">
                                            <label for="inputPasswordNew">Mật khẩu</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-3 col-md-12">
                                        <div class="form-label-group">
                                            <input type="text" name="isName" id="inputName" class="form-control" placeholder="Tên" required="required" autofocus="autofocus">
                                            <label for="inputName">Tên</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12 col-lg-3 col-md-12">
                                        <div class="form-label-group">
                                            <input type="text" name="isLastName" id="inputLastName" class="form-control" placeholder="Họ" required="required" autofocus="autofocus">
                                            <label for="inputLastName">Họ</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <fieldset class="form-group col-lg-12 col-sm-12 col-md-12">
                                        <div class="row">
                                            <legend class="col-form-label col-sm-3 col-lg-1 col-md-2 pt-0">Quyền</legend>
                                            <div class="col-sm-10">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="role" id="gridRadios2" value="2" required  <%=role < 2 ? "" : "disabled"%> >
                                                    <label class="form-check-label" for="gridRadios2">
                                                        Quản trị viên
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="role" id="gridRadios3" value="3" required <%=role < 3 ? "" : "disabled"%> >
                                                    <label class="form-check-label" for="gridRadios3">
                                                        Quản lý
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                                <button class="btn btn-primary" type="submit">Thêm</button>
                                <a class="btn btn-danger" href="javascript:history.back()" style="margin-left: 10px">Hủy</a>
                            </form>
                            <%
                            } else {
                            %>
                            <div class="alert alert-danger" role="alert">
                                Tài khoản của bạn không có quyền này. Trở về trang <a href="user-admin" class="alert-link">Danh sách người dùng CMS</a>
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
            let result = GetURLParameter('result');
            switch (result) {
                case 'success':
                    swal("Thông báo", "Thêm thành công", "success");
                    break;
                case '-1':
                    swal("Thông báo", "Tên tài khoản đã được sử dụng");
                    break;
                case '-2':
                    swal("Thông báo", "Thêm thất bại");
                    break;
            }
        </script>
    </body>
</html>
