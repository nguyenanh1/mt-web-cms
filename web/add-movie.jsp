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
        <title>CGV - CMS</title>
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
            List<Category> mListCate = CategoryService.getInstance().getAllCate();
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
                        <li class="breadcrumb-item active">Thêm phim</li>
                    </ol>

                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-plus-square"></i>
                            Nhập thông tin phim mới</div>
                        <div class="card-body">
                            <%
                                if (role != 3) {
                            %>
                            <form method="post" action="MovieController?action=add" enctype="multipart/form-data">
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="name" id="inputEmail" class="form-control" placeholder="Tên tài khoản" required="required" autofocus="autofocus">
                                            <label for="inputEmail">Tên Phim</label>
                                        </div>

                                    </div>
                                    <div class="form-group col-sm-12 col-lg-2 col-md-5">
                                        <select class="form-control" name="old" id="exampleFormControlSelect1">
                                            <option value="-1">Độ tuổi</option>
                                            <option value="0">0</option>
                                            <option value="13">13</option>
                                            <option value="15">15</option>
                                            <option value="18">18</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="date" name="datestart" id="inputDate" class="form-control" placeholder="Ngày khởi chiếu" required="required" >
                                            <label for="inputDate">Ngày khởi chiếu</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12 col-lg-2 col-md-5">
                                        <div class="form-label-group">
                                            <input type="number" name="time" id="inputTime" class="form-control" placeholder="Thời lượng (Phút)" required="required">
                                            <label for="inputTime">Thời lượng</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-sm-12 col-lg-7 col-md-5">
                                        <select class="form-control" name="cate" id="exampleFormControlSelect1" required multiple="multiple">
                                            <% for (Category cate : mListCate) {%>
                                            <option value="<%=cate.getId()%>"><%=cate.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="director" id="inputDirector" class="form-control" placeholder="Đạo diễn">
                                            <label for="inputDirector">Đạo diễn</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="actor" id="inputActor" class="form-control" placeholder="Diễn viên">
                                            <label for="inputActor">Diễn viên</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="trailer" id="inputTrailer" class="form-control" placeholder="Trailer">
                                            <label for="inputTrailer">Trailer</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="file" name="thumb" id="inputThumb" class="form-control" placeholder="Thumb">
                                            <label for="inputThumb">Thumb</label>
                                            <img id="thumb" class="d-none" width="160px" height="237px"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="file" name="image" id="inputImage" class="form-control" placeholder="Ảnh">
                                            <label for="inputImage">Ảnh</label>
                                            <img id="image" class="d-none" width="165px" height="260px"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputContent">Nội dung</label>
                                    <textarea class="form-control" name="contain" id="inputContent" rows="5" id="comment"></textarea>
                                </div>
                                <button class="btn btn-primary" type="submit">Thêm</button>
                                <a class="btn btn-danger" href="javascript:history.back()" style="margin-left: 10px">Hủy</a>

                                <%
                                } else {
                                %>
                                <div class="alert alert-danger" role="alert">
                                    Tài khoản của bạn không có quyền này. Trở về trang <a href="movie" class="alert-link">danh sách phim</a>
                                </div>
                                <%
                                    }
                                %>
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

    <script>
        $(document).ready(function () {
            let now = new Date();
            let year = now.getFullYear();
            let day = now.getDate();
            let month = now.getMonth() + 1;
            if (day < 10) {
                day = '0' + day;
            }
            if (month < 10) {
                month = '0' + month;
            }
            var today = year + '-' + month + '-' + day;
            $('#inputDate').val(today);
        });
        function readURLThumb(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#thumb').attr('src', e.target.result);
                    $('#thumb').removeClass('d-none').add('.d-inline');
                };

                reader.readAsDataURL(input.files[0]);
            }
        }

        function readURLImage(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#image').attr('src', e.target.result);
                    $('#image').removeClass('d-none').add('.d-inline');
                };

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#inputThumb").change(function () {
            readURLThumb(this);
        });

        $("#inputImage").change(function () {
            readURLImage(this);
        });
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
