<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="java.util.Date"%>
<%@page import="util.CustomToken"%>
<%@page import="util.CommonUtils"%>
<%@page import="service.MovieService"%>
<%@page import="pojos.Movie"%>
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
                        <li class="breadcrumb-item">
                            <a href="home">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item active">Danh sách phim</li>
                    </ol>
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center" >
                            <i class="fas fa-table"></i>
                            Danh sách phim

                            <a href="add-movie" class="btn btn-primary <%=(role == 3 ? "disabled" : "")%>" style="margin-left: auto">Thêm phim</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tên</th>
                                            <th>Ảnh</th>
                                            <th>Khởi chiếu</th>
                                            <th>Thời lượng</th>
                                            <th>View</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Movie> mList = MovieService.getInstance().getAllMovie();
                                            if (mList != null) {
                                                for (Movie mMovie : mList) {

                                        %>    
                                        <tr>
                                            <td><%=mMovie.getName()%></td>
                                            <td><img src="<%=(CommonUtils.ip + mMovie.getThumb())%>" width="160" height="237"/></td>
                                            <td><%=CommonUtils.convertDate(mMovie.getPartTime())%></td>
                                            <td><%=(mMovie.getTime() == null ? "" : mMovie.getTime().toString())%></td>
                                            <td><%=mMovie.getView()%></td>
                                            <td class="text-center">
                                                <a title="Chi tiết" href="detail-movie?id=<%=mMovie.getId()%>" class="mr10 btn btn-info"><i data-v-1f4de138="" class="fas fa-info-circle"></i></a>
                                                <a   title="Sửa phim" href="edit-movie?id=1" class="mr10 btn btn-success <%=(role == 3 ? "disabled" : "")%>"><i class="fas fa-edit"></i></a>
                                                <a href="#" data-id="<%=mMovie.getId()%>" title="<%=(mMovie.getStatus()==1?"Ngừng kinh doanh":"Kinh doanh") %>" class="btn-lock btn btn-warning  <%=(role == 3 ? "disabled" : "")%>"><i class="fas <%=(mMovie.getStatus()==1?"fa-lock":"fa-unlock" )%> fa-lock "></i></a>
                                                <a title="Xóa phim" href="MovieController?action=del" class="mr10 btn btn-danger <%=(role == 3 ? "disabled" : "")%>"><i data-v-1f4de138="" class="fas fa-trash"></i></a>
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
            </div>
        </div> 

        <jsp:include page="scrolltotop.jsp"/>
        <jsp:include page="logout.jsp"/>
        <jsp:include page="javascript.jsp"/>
        <script>
            $(document).ready(function () {
                $('.btn-lock').click(function (event) {
                    var $this = $(this);
                    var dataT = $this.attr("data-id");

                    $.ajax({
                        url: 'LockMovieAjax',
                        type: 'GET',
                        contentType: 'application/json',
                        dataType: 'json',
                        data: {
                            id: $this.attr("data-id")
                        },
                        success: function (data) {
                            swal("Thông báo", "Thành công", "success")
                                    .then((value) => {
                                        if (value) {
                                            window.location.replace("movie");
                                        }
                                    });

                            console.log(data.code);
                        },
                        error: function ()
                        {
                            alert("error");
                        }
                    });
                });
            });


        </script>
    </body>
</html>
