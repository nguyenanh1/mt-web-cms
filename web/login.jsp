<%-- 
    Document   : login
    Created on : Apr 23, 2019, 10:29:18 AM
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

        <title>CGV CMS - Login</title>

        <jsp:include page="logo.jsp"/>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body class="bg-dark">
        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Đăng nhập vào hệ thống</div>
                <div class="card-body">
                    <form method="post" action="LoginController">
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" name="username" id="inputEmail" value="" class="form-control" placeholder="Tên tài khoản" required="required" autofocus="autofocus">
                                <label for="inputEmail">Tên tài khoản</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="password" name="password" value="" id="inputPassword" class="form-control" placeholder="Mật khẩu" required="required">
                                <label for="inputPassword">Mật khẩu</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="remember-me">
                                    Ghi nhớ thông tin đăng nhập
                                </label>
                            </div>
                        </div>
                        <div  id="fail2" class="d-none">
                            <p style="color: red">Tài khoản không tồn tại</p>
                        </div>
                        <div  id="fail3" class="d-none">
                            <p style="color: red">Mật khẩu đăng nhập không đúng</p>
                        </div>
                        <div  id="fail4" class="d-none">
                            <p style="color: red">Tài khoản của bạn đang đăng nhập ở 1 thiết bị khác</p>
                        </div>
                        <button class="btn btn-primary btn-block" type="submit">Đăng nhập</button>
                    </form>
                    <div class="text-center" style="margin-top: 10px">
                        <a class="d-block small" href="#">Quên mật khẩu?</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script>
            function GetURLParameter(sParam) {
                var sPageURL = window.location.search.substring(1);
                var sURLVariables = sPageURL.split('&');
                for (var i = 0; i < sURLVariables.length; i++) {
                    var sParameterName = sURLVariables[i].split('=');
                    if (sParameterName[0] === sParam)
                    {
                        return sParameterName[1];
                    }
                }
            }
            let fail = GetURLParameter('fail');
            switch (fail) {
                case '-1':
                    $('#fail2').removeClass('d-none').addClass('d-inline');
                    break;
                case '-2':
                    $('#fail3').removeClass('d-none').addClass('d-inline');
                    break;
                case '-3' :
                    $('#fail4').removeClass('d-none').addClass('d-inline');
                    break;
            }
        </script>
    </body>
</html>
