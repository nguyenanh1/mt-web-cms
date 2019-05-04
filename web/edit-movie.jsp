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
        <title>CGV - CMS</title>
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
                        <li class="breadcrumb-item">
                            <a href="movie">Danh sách phim</a>
                        </li>
                        <li class="breadcrumb-item active">Chạy ngay đi</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-edit"></i>
                            Sửa thông tin phim</div>
                        <div class="card-body">
                            <form>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-5 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Tên tài khoản" required="required" autofocus="autofocus">
                                            <label for="inputEmail">Tên Phim</label>
                                        </div>

                                    </div>
                                    <div class="form-group col-sm-12 col-lg-2 col-md-5">
                                        <select class="form-control" id="exampleFormControlSelect1">
                                            <option value="">Độ tuổi</option>
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
                                            <input type="date" name="username" id="inputDate" class="form-control" placeholder="Ngày khởi chiếu" required="required" >
                                            <label for="inputDate">Ngày khởi chiếu</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12 col-lg-2 col-md-5">
                                        <div class="form-label-group">
                                            <input type="number" name="username" id="inputTime" class="form-control" placeholder="Thời lượng (Phút)" required="required">
                                            <label for="inputTime">Thời lượng</label>
                                        </div>
                                    </div>
                                </div>
                                 <div class="row form-group">
                                    <div class="col-sm-12 col-lg-7 col-md-5">
                                        <select class="form-control" id="exampleFormControlSelect1" multiple="multiple">
                                            <option value="0">0</option>
                                            <option value="13">13</option>
                                            <option value="15">15</option>
                                            <option value="18">18</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="username" id="inputDirector" class="form-control" placeholder="Đạo diễn">
                                            <label for="inputDirector">Đạo diễn</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="username" id="inputActor" class="form-control" placeholder="Diễn viên">
                                            <label for="inputActor">Diễn viên</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="text" name="username" id="inputTrailer" class="form-control" placeholder="Trailer">
                                            <label for="inputTrailer">Trailer</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="file" name="username" id="inputThumb" class="form-control" placeholder="Thumb">
                                            <label for="inputThumb">Thumb</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="form-group col-sm-12 col-lg-7 col-md-5">
                                        <div class="form-label-group">
                                            <input type="file" name="username" id="inputImage" class="form-control" placeholder="Ảnh">
                                            <label for="inputImage">Ảnh</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputContent">Nội dung</label>
                                    <textarea class="form-control" id="inputContent" rows="5" id="comment"></textarea>
                                </div>
                                <button class="btn btn-primary" type="submit">Đăng nhập</button>
                                <button class="btn btn-danger" style="margin-left: 10">Hủy</button>
                        </div>

                        </form>
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
