<%-- 
    Document   : menu
    Created on : Apr 23, 2019, 10:55:39 AM
    Author     : Asus
--%>

<%@page import="common.CodeDefine"%>
<%@page import="util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<!-- Sidebar -->
<ul  id="nav" class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="/mt-web-cms/home">
            <i class="fas fa-fw fa-home"></i>
            <span>Trang chủ</span>
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-film"></i>
            <span>Quản lý phim</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Phim</h6>
            <a class="dropdown-item <%=(role == 3 ? "disabled" : "")%>" href="/mt-web-cms/add-movie">Thêm phim</a>
            <a class="dropdown-item" href="/mt-web-cms/movie">Xem danh sách phim</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Danh mục phim</h6>
            <a class="dropdown-item <%=(role == 3 ? "disabled" : "")%>" href="/mt-web-cms/add-category">Thêm danh mục</a>
            <a class="dropdown-item" href="/mt-web-cms/category">Xem danh mục</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-tv"></i>
            <span>Quản lý phòng chiếu</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="/mt-web-cms/add-room">Thêm phòng chiếu</a>
            <a class="dropdown-item" href="/mt-web-cms/room">Xem phòng chiếu</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-calendar-alt"></i>
            <span>Q.lý kế hoạch chiếu</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="/mt-web-cms/add-time">Thêm lịch chiếu</a>
            <a class="dropdown-item" href="/mt-web-cms/time-movie">Xem lịch chiếu</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-user-friends"></i>
            <span>Quản lý người dùng</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Người dùng CMS</h6>
            <a class="dropdown-item <%=(role == 3 ? "disabled" : "")%>" href="/mt-web-cms/add-user-admin">Thêm người dùng</a>
            <a class="dropdown-item" href="/mt-web-cms/user-admin">Xem danh sách</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Người dùng App Mobile</h6>
            <a class="dropdown-item" href="/mt-web-cms/user-mobile">Xem danh sách</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/mt-web-cms/ticket">
            <i class="fas fa-fw fa-ticket-alt"></i>
            <span>Quản lý vé</span></a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-user-alt"></i>
            <span>Cá nhân</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="/mt-web-cms/info">Thông tin cá nhân</a>
            <a class="dropdown-item" href="/mt-web-cms/change-password">Đổi mật khẩu</a>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Đăng xuất</a>
        </div>
    </li>
</ul>


<!-- /.content-wrapper -->
