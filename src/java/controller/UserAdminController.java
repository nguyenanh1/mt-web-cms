/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.CodeDefine;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;
import util.CustomToken;

/**
 *
 * @author Asus
 */
@WebServlet("/UserAdminController")
public class UserAdminController extends BaseController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        xuLy(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        xuLy(req, resp);
    }

    private void xuLy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            switch (action) {
                case "add":
                    add(req, resp);
                    break;
                case "edit":
                    edit(req, resp);
                    break;
                case "del":
                    break;
            }
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String isName = req.getParameter("isName");
        String isLastName = req.getParameter("isLastName");
        int role = Integer.parseInt(req.getParameter("role"));
        int idCreater = Integer.parseInt(req.getSession().getAttribute(CodeDefine.USER_ID).toString());
        String mess = UserService.getInstance().createAccount(username, password, isName, isLastName, role, idCreater);

        switch (mess) {
            case UserService.CREATE_ACCOUNT_SUCCSESS:
                resp.sendRedirect(req.getContextPath() + "/add-user-admin?result=success");
                break;
            case UserService.CREATE_ACCOUNT_USER_CREATED:
                resp.sendRedirect(req.getContextPath() + "/add-user-admin?result=-1");
                break;
            case UserService.CREATE_ACCOUNT_FAIL:
                resp.sendRedirect(req.getContextPath() + "/add-user-admin?result=-2");
                break;
        }
       
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
