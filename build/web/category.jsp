<%-- 
    Document   : index
    Created on : Apr 23, 2019, 10:28:51 AM
    Author     : Asus
--%>

<%@page import="util.CommonUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="util.CustomToken"%>
<%@page import="service.CategoryService"%>
<%@page import="model.CategoryUser"%>
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
    <body>
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
                        <li class="breadcrumb-item active">Danh mục phim</li>
                    </ol>
                    <div class="card mb-3">
                        <div class="card-header d-flex align-items-center" >
                            <i class="fas fa-table"></i>
                            Danh sách danh mục phim
                            <a href="add-category" class="btn btn-primary <%=(role == 3 ? "disabled" : "")%>"  style="margin-left: auto">Thêm danh mục</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tên</th>
                                            <th>Người thêm</th>
                                            <th>Ngày thêm</th>
                                            <th>Người sửa</th>
                                            <th>Ngày sửa</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<CategoryUser> mList = CategoryService.getInstance().getAllCateUser();
                                            for (CategoryUser cate : mList) {
                                        %>
                                        <tr>

                                            <td><%=cate.getCategoryName()%></td>
                                            <td><%=cate.getUserCreate()%></td>
                                            <td><%=cate.getTimeCreate()%></td>
                                            <td><%=cate.getUserUpdate()%></td>
                                            <td><%=cate.getTimeUpdate()%></td>
                                            <td class="text-center">
                                                <a title="Sửa danh mục" href="edit-category?id=<%=cate.getId()%>" class="mr10 btn btn-success <%=(role == 3 ? "disabled" : "")%>"><i class="fas fa-edit"></i></a>
                                                <button title="Xóa danh mục" onclick="deleteCate(<%=cate.getId()%>)" class="mr10 btn btn-danger <%=(role == 3 ? "disabled" : "")%>"><i class="fas fa-trash"></i></button>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted"> 
                            <%=("Dữ liệu lấy lúc " +CommonUtils.formatDate(new Date()))%>
                        </div>
                    </div>
                </div>
                <jsp:include page="footer.jsp"/>

            </div>
        </div> 

        <div class="modal fade" id="confirmDialog" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Bạn có muốn xóa bản ghi này ?</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary"  type="button" data-dismiss="modal">Hủy</button>
                        <a class="btn btn-primary" id="del" href="#">Đồng ý</a>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="scrolltotop.jsp"/>
        <jsp:include page="logout.jsp"/>
        <jsp:include page="javascript.jsp"/>
        <script>
            let alert = GetURLParameter("alert");
            if (alert === "sucsses") {
                swal("Thông báo", "Xóa thành công", "success")
                        .then((value) => {
                            if (value) {
                                window.location.replace("category");
                            }
                        });
            }



            if (alert === "fail") {
                swal("Thông báo", "Xóa thất bại").then((value) => {
                    if (value) {
                        window.location.replace("category");
                    }
                });
            }

            function deleteCate(id) {
                console.log(id);
                $('#confirmDialog').modal('show');
                $('#confirmDialog #del').attr('href','CategoryController?action=del&id='+id);
            }

        </script>
    </body>
</html>
