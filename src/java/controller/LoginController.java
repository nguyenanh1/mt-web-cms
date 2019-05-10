/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.CodeDefine;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;

/**
 *
 * @author Asus
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private UserService mUserService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        HttpSession session = request.getSession();
        session.removeAttribute(CodeDefine.USER_ID);
        mUserService = UserService.getInstance();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String result = mUserService.login(username, password);
        
        switch (result) {
            case UserService.LOGIN_USER_NOT_FOUND:
                response.sendRedirect(request.getContextPath()+"/login?fail=-1");
                break;
            case UserService.LOGIN_PASSWORD_WRONG:
                response.sendRedirect(request.getContextPath()+"/login?fail=-2");
                break;
            case UserService.LOGIN_IN_OTHER_DEVICE:
                response.sendRedirect(request.getContextPath()+"/login?fail=-3");
                break;
            default:
                session.setMaxInactiveInterval(60*15*1000);
                session.setAttribute(CodeDefine.USER_ID, mUserService.findByUser(username).getId());
                session.setAttribute(CodeDefine.TOKEN, result);
                session.setAttribute(CodeDefine.DISPLAY_NAME, mUserService.findByUser(username).getDisplayName());
                response.sendRedirect(request.getContextPath()+"/home");
                break;
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
